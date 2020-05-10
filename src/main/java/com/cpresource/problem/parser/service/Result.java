package com.cpresource.problem.parser.service;

import java.util.ArrayList;

public class Result {
	private String contestID;
	private ArrayList<String> problems;

	public void Result() {
		
	}
	
	public ArrayList<String> getProblems() {
		return problems;
	}

	public void setProblems(ArrayList<String> problems) {
		this.problems = problems;
	}

	public String getContestID() {
		return contestID;
	}

	public void setContestID(String contestID) {
		this.contestID = contestID;
	}

	@Override
	public String toString() {
		return "Result [contestID=" + contestID + ", problems=" + problems + ", getProblems()=" + getProblems()
				+ ", getContestID()=" + getContestID() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
