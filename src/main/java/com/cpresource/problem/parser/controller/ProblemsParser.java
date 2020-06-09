package com.cpresource.problem.parser.controller;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpresource.problem.parser.service.DemoProblems;
import com.cpresource.problem.parser.service.DemoProblemsService;
import com.cpresource.problem.parser.service.Result;
import com.cpresource.problem.parser.service.Store;
import com.cpresource.problem.parser.service.ProblemService;

@RestController
public class ProblemsParser {

	@Autowired
	public ProblemsParser() {

	}
	
	ProblemService problemService = new ProblemService();	
	
	@GetMapping(value = "/contest/{id}")
	public Result getProblems(@PathVariable String id) throws URISyntaxException {
		Result r = Store.readData(id);
		if( r != null) {
			System.out.println("found in data");
			return r;
		}
		return problemService.getData(id);
		//return problemService.getData(id);
	}

}
