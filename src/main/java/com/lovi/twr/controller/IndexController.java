package com.lovi.twr.controller;

import com.lovi.puppyio.core.annotation.Controller;
import com.lovi.puppyio.core.annotation.RequestMapping;
import com.lovi.puppyio.core.annotation.RequestParm;
import com.lovi.puppyio.core.web.ApplicationContextData;
import com.lovi.puppyio.core.web.ViewAttribute;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping
	public void loadView(@RequestParm(value="q", defaultValue="welcome...") String q, ViewAttribute viewAttribute, ApplicationContextData contextData){
		viewAttribute.put("msg", "msg : " + q);
		viewAttribute.loadView("home");
	}
}
