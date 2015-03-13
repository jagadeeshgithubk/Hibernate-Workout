package com.test.controller;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	private ScopeObject scopeObject;
	@Autowired
	private ScopeObject1 scopeObject1;
	
	@Autowired
	@Qualifier("testChild3")
	private ChilldClassForScopeObject testChild;
	
	@Autowired
	@Qualifier("testChild4")
	private ChilldClassForScopeObject testChild1; 
	
	@Autowired
//	@Resource(name="testService")
	@Qualifier("testService")
	private TestService tService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		scopeObject.setName("..........test..........");
		model.addAttribute("message", "...");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
		
		model.addAttribute("message", "scopeObject1:" + scopeObject1.geScopeObject().getName()+":"+":"+testChild.getLastName1()+":"+name);
		model.addAttribute("counter", ++counter);
		try {
			tService.executeQuery(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("[welcomeName] counter : {}", counter);
		return VIEW_INDEX;

	}

}