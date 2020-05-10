package com.cpresource.problem.parser.service;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"status","result" })
public class Problem {
	@JsonProperty("status")
	private String status;
	@JsonProperty("result")
	HashMap<String, Object> result = new HashMap<String,Object>();


	// Getter Methods 

	public String getStatus() {
		return status;
	}

	public HashMap<String, Object> getResult() {
		return result;
	}

	// Setter Methods 

	public void setStatus( String status ) {
		this.status = status;
	}

	public void setResult( HashMap<String, Object>  result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "TestProblem [status=" + status + ", result=" + result + ", getStatus()=" + getStatus()
				+ ", getResult()=" + getResult() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
}
