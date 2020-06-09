package com.cpresource.problem.parser.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cpresource.problem.parser.tag.*;

@RestController
public class ProblemByTagController {
	
	@Autowired
	public ProblemByTagController() {

	}
	
	GetProblemsByTags service = new GetProblemsByTags();
	
	@GetMapping(value = "/tags/{tag}")
	public TagProblem getProblemsByTag(@PathVariable String tag) throws URISyntaxException {
		/*
		 * Result r = Store.readData(id); if( r != null) {
		 * System.out.println("found in data"); return r; }
		 */
		System.out.println("inside problemTag controller");
		return service.getProblemsByTags(tag);
		//return problemService.getData(id);
	}
}
