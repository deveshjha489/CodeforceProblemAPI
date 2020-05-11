package com.cpresource.problem.parser.service;

import java.net.URI;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ProblemService {
	@Autowired
	HttpSession session;

	@Autowired
	Problem problems;

	private final RestTemplate restTemplate = new RestTemplate();

	public Result getData(String CID) throws URISyntaxException {
		double start = System.currentTimeMillis();
		HttpHeaders headers = new HttpHeaders();

		RequestEntity<String> requestEntity = new RequestEntity<>(headers, HttpMethod.GET,
				new URI("https://codeforces.com/api/problemset.problems"));
		ResponseEntity<Problem> responseEntity = restTemplate.exchange(requestEntity, Problem.class);

		HashMap<String,Object>  result= responseEntity.getBody().getResult();
		ArrayList<HashMap<String,Object>> problemsList = (ArrayList<HashMap<String,Object>>) result.get("problems");
		HashMap<String,ArrayList<String>> contestProblem = new HashMap<String,ArrayList<String>>();
		System.out.println("start");
		Integer problemsListSize = problemsList.size();
		for(int i=0;i<problemsListSize;i++) {
			String contestId = problemsList.get(i).get("contestId").toString();
			String problemName = (String)problemsList.get(i).get("name");
			if(contestProblem.get(contestId) != null) {
				contestProblem.get(contestId).add(problemName);
			}else {
				ArrayList<String> arr = new ArrayList<String>();
				arr.add(problemName);
				contestProblem.put(contestId, arr);
			}
		}
		StoreContent pb = new StoreContent();
		pb.setProblems(contestProblem);
		Store.storeData(pb);
		Result requiredData = new Result();
		requiredData.setContestID(CID);
		requiredData.setProblems(contestProblem.get(CID));
		double end = System.currentTimeMillis();
		System.out.println("Time Taken by TestProblemService :" + (end-start)/1000);
		return requiredData;
	}

}
