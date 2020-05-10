package com.cpresource.problem.parser.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DemoProblemsService {

	public DemoProblems getData(String contestID) {
		DemoProblems pb = new DemoProblems();
		String inline = ""; 
		try {
			double start = System.currentTimeMillis();
			URL url = new URL("https://codeforces.com/api/problemset.problems");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " +responsecode);
			if(responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " +responsecode);
			else
			{
				//Scanner functionality will read the JSON data from the stream
				//start = System.currentTimeMillis();
				Scanner sc = new Scanner(url.openStream());
				System.out.println("Reading Stream");
				while(sc.hasNext())
				{
					inline+=sc.nextLine();
				}
				sc.close();
			}
			double end = System.currentTimeMillis();
			System.out.println("Time taken to read string"+(end-start)/1000);
			start = System.currentTimeMillis();
			System.out.println("Starting Parsing");
			JSONParser parse = new JSONParser();
			JSONObject jobj = (JSONObject)parse.parse(inline);
			JSONObject result = (JSONObject) jobj.get("result");
			JSONArray problemsList = (JSONArray)result.get("problems");
			HashMap<String, ArrayList<String>> contestProblem = new HashMap<>();
			for(int i=0;i<problemsList.size();i++) {

				JSONObject problem = (JSONObject)problemsList.get(i);

				String contestId = (String) problem.get("contestId").toString();
				String problemName = (String)problem.get("name");
				problemName.replaceAll("\\s", "");
				if(contestProblem.get(contestId) != null) {
					contestProblem.get(contestId).add(problemName);
				}else {
					ArrayList<String> arr = new ArrayList<String>();
					arr.add(problemName);
					contestProblem.put(contestId, arr);
				}

			}
			pb.setContestID(contestID);
			pb.setProblems(contestProblem.get(pb.getContestID()));
			//			ArrayList<String> list = contestProblem.get("373");
			//			for(int i=0;i<list.size();i++) {
			//				System.out.println(list.get(i));
			//			}
			conn.disconnect();
			end = System.currentTimeMillis();
			System.out.println("ime Taken by ProblemService "+(end-start)/1000);
			return pb;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;

	}

}
