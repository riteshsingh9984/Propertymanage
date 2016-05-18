/**
 * 
 */
package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ironman.propertyutility.bean.DbProperty;
import ironman.propertyutility.controllers.ApplicationBeanLoader;

/**
 * @author bmp
 *
 */
@Controller
public class DemoController {

	@RequestMapping("/check1")
	public ModelAndView show1Message() throws Exception {
		
		String data = null;
		
		DbProperty dbConfig = (DbProperty) ApplicationBeanLoader.INSTANCE.getBean("dbConfig");
		data = "Server-PortNo: "+dbConfig.getPortNo()+", Server-IpAddress: "+dbConfig.getIpAddress();
		data = data+", Server-Info: "+dbConfig.getInfo();
		return new ModelAndView("demos/hello","data", data);
	}
	
	@RequestMapping("/check2")
	public ModelAndView show2Message() throws Exception {
		
		String data = null;
		
		DbProperty dbConfig = (DbProperty) ApplicationBeanLoader.INSTANCE.getBean("dbConfig");
		data = "Server-PortNo: "+dbConfig.getPortNo()+", Server-IpAddress: "+dbConfig.getIpAddress();
		data = data+", Server-Info: "+dbConfig.getInfo();
		return new ModelAndView("demos/hello","data", data);
	}
	
	@RequestMapping("/check3")
	public ModelAndView show3Message() throws Exception {
		
		String data = null;
		
		DbProperty dbConfig = (DbProperty) ApplicationBeanLoader.INSTANCE.getBean("dbConfig");
		data = "Server-PortNo: "+dbConfig.getPortNo()+", Server-IpAddress: "+dbConfig.getIpAddress();
		data = data+", Server-Info: "+dbConfig.getInfo();
		return new ModelAndView("demos/hello","data", data);
	}
	
	@RequestMapping("/check4")
	public ModelAndView show4Message() throws Exception {
		
		String data = null;
		
		DbProperty dbConfig = (DbProperty) ApplicationBeanLoader.INSTANCE.getBean("dbConfig");
		data = "Server-PortNo: "+dbConfig.getPortNo()+", Server-IpAddress: "+dbConfig.getIpAddress();
		data = data+", Server-Info: "+dbConfig.getInfo();
		
		return new ModelAndView("demos/hello","data", data);
	}
}