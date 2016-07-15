package com.lovi.twr.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.lovi.puppyio.core.annotation.Controller;
import com.lovi.puppyio.core.annotation.ModelAttribute;
import com.lovi.puppyio.core.annotation.PathVariable;
import com.lovi.puppyio.core.annotation.RequestMapping;
import com.lovi.puppyio.core.exception.JsonParserException;
import com.lovi.puppyio.core.web.HttpResponse;
import com.lovi.puppyio.core.web.enums.HttpMethod;
import com.lovi.twr.exception.ServiceException;
import com.lovi.twr.model.JobSeeker;
import com.lovi.twr.service.JobSeekerService;

@Controller
@RequestMapping("/seekers")
public class JobSeekerController {

	@Autowired
	private JobSeekerService jobSeekerService;

	@RequestMapping
	public void getAll(HttpResponse response) throws JsonParserException, ServiceException {
		response.writePOJO(jobSeekerService.getAll());
	}
	
	@RequestMapping("/{id}")
	public void getById(@PathVariable("id") Integer id,HttpResponse response) throws JsonParserException, ServiceException {
		response.writePOJO(jobSeekerService.getById(id));
	}
	
	@RequestMapping(method=HttpMethod.POST)
	public void save(@ModelAttribute JobSeeker jobSeeker,HttpResponse response) throws JsonParserException, ServiceException {
		response.writePOJO(jobSeekerService.save(jobSeeker));
	}
	
	@RequestMapping(method=HttpMethod.DELETE)
	public void delete(@ModelAttribute JobSeeker jobSeeker,HttpResponse response) throws JsonParserException, ServiceException {
		jobSeekerService.delete(jobSeeker);
		response.writePOJO(jobSeeker + " deleted");
	}
}
