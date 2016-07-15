package com.lovi.twr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.lovi.puppyio.core.annotation.Controller;
import com.lovi.puppyio.core.annotation.ModelAttribute;
import com.lovi.puppyio.core.annotation.PathVariable;
import com.lovi.puppyio.core.annotation.RequestMapping;
import com.lovi.puppyio.core.async.AsyncExecutor;
import com.lovi.puppyio.core.exception.JsonParserException;
import com.lovi.puppyio.core.web.ApplicationContextData;
import com.lovi.puppyio.core.web.HttpResponse;
import com.lovi.puppyio.core.web.enums.HttpMethod;
import com.lovi.twr.model.User;
import com.lovi.twr.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping
	public void findAll(ApplicationContextData contextData, HttpResponse response) throws JsonParserException{
		response.writePOJO(userService.findAll(contextData));
	}
	
	@RequestMapping(value="/{id}")
	public void findById(@PathVariable("id") Integer id, ApplicationContextData contextData, HttpResponse response) throws JsonParserException{
		User user = userService.findById(contextData, id);
		response.writePOJO(user);
	}
	
	@RequestMapping(method=HttpMethod.POST)
	public void save(@ModelAttribute User user, ApplicationContextData contextData, HttpResponse response) throws JsonParserException{
		userService.save(contextData, user);
		response.setResponseCode(201);
		response.writePOJO(user);
	}
	
	@RequestMapping("/async_test/{wait}")
	public void asyncTest(@PathVariable("wait")Integer waitSecond, HttpResponse response){
		
		AsyncExecutor<String> executor = AsyncExecutor.create();
		executor.run(()->{
			long startTime = System.nanoTime();
			
			try {
				Thread.sleep(1000 * waitSecond);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			long elapsedTimeNs = System.nanoTime() - startTime;
			return "async operation , wait second : " + (elapsedTimeNs/1000000000f);
			
		}, r->{
			response.write(r);
		}, fail->{
			response.setResponseCode(500);
			response.write(fail.getMessage());
		});
		
	}
}
