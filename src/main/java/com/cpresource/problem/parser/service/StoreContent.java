package com.cpresource.problem.parser.service;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreContent {
	private HashMap<String, ArrayList<String>> problems;



	public StoreContent() {
	}

	public HashMap<String, ArrayList<String>> getProblems() {
		return problems;
	}

	public void setProblems(HashMap<String, ArrayList<String>> problems) {
		this.problems = problems;
	}
}
