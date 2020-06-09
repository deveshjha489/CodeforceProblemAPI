package com.cpresource.problem.parser.tag;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class GetProblemsByTags {
	@Autowired
	HttpSession session;

	private final RestTemplate restTemplate = new RestTemplate();
	public TagProblem  getProblemsByTags(String tagName) throws URISyntaxException {
		System.out.println("Inside getProblemsByTag");
		HttpHeaders headers = new HttpHeaders();
		String requestUrl = "https://codeforces.com/api/problemset.problems?tags="+tagName;
		URI uri = new URI(requestUrl.replace(" ", "%20"));
		RequestEntity<String> requestEntity = new RequestEntity<>(headers, HttpMethod.GET,
				uri);
		ResponseEntity<TagResult> responseEntity = restTemplate.exchange(requestEntity, TagResult.class);

		HashMap<String,Object>  result= responseEntity.getBody().getResult();
		ArrayList<HashMap<String,Object>> problemsList = (ArrayList<HashMap<String,Object>>) result.get("problems");
		int problemListSize = problemsList.size();
		HashMap<Integer, ArrayList<String>> problemTagList = new HashMap<Integer,ArrayList<String>>();
		for(int i=0;i<problemListSize;++i) {
			String problemName = problemsList.get(i).get("name").toString();
			Integer problemRating = (Integer) problemsList.get(i).get("rating");
			if(problemRating == null)problemRating = 5555;//Not rated
			if(problemTagList.get(problemRating) != null) {
				problemTagList.get(problemRating).add(problemName);
			}else {
				ArrayList<String> problemByRating = new ArrayList<String>();
				problemByRating.add(problemName);
				problemTagList.put(problemRating, problemByRating);
			}	
		}
		TagProblem tagProblem = new TagProblem();
		tagProblem.setTagName(tagName);
		tagProblem.setProblems(problemTagList);
		tagProblem.setCount(problemListSize);
		System.out.println(problemTagList);
		return tagProblem;
	}
}
