package com.cpresource.problem.parser.tag;

import java.util.ArrayList;
import java.util.HashMap;

public class TagProblem {
	private String tagName;
	private Integer count;
	private HashMap<Integer,ArrayList<String>> problems;
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void TagProblem() {
		
	}
	
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public HashMap<Integer,ArrayList<String>> getProblems() {
		return problems;
	}

	public void setProblems(HashMap<Integer,ArrayList<String>> problems) {
		this.problems = problems;
	}


		
}


