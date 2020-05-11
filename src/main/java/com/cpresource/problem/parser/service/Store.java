package com.cpresource.problem.parser.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.codehaus.jackson.map.ObjectMapper;

public class Store {
	public static void storeData(StoreContent pb) {
		ObjectMapper  mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("data.json"), pb);
			String jsonInString = mapper.writeValueAsString(pb);
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pb);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static Result readData(String contestID) {
		ObjectMapper  mapper = new ObjectMapper();
		try {
			StoreContent problems = mapper.readValue(new File("data.json"),StoreContent.class);
			HashMap<String, ArrayList<String>> contestProblem = problems.getProblems();
			if(contestProblem.get(contestID) != null){
				Result requiredData = new Result();
				requiredData.setContestID(contestID);
				requiredData.setProblems(contestProblem.get(contestID));
				return requiredData;
			}
			else {
				return null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
