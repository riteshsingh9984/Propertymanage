/**
 * 
 */
package com.demo.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.MyServer;
import com.google.gson.Gson;

import ironman.propertyutility.bean.DbProperty;
import ironman.propertyutility.controllers.ApplicationBeanLoader;

/**
 * @author bmp
 *
 */
@Controller
public class PropConfigController {

	@RequestMapping("/")
	public ModelAndView showMessage() {
		
		System.out.println("from controller");
		return new ModelAndView("myserver/create");
	}
	
	@RequestMapping("/myserverCreateForm")
	public ModelAndView myserverForm() throws Exception {
		
		System.out.println("from server controller");
		/*DbProperty dbConfig = (DbProperty) ApplicationBeanLoader.INSTANCE.getBean("dbConfig");
        
        System.out.println(dbConfig.toString());
        dbConfig.setIpAddress("cutom");
        System.out.println("=============HELLLLLLLLOOOOOOOOO==================");*/
		return new ModelAndView("myserver/create");
	}
	
	@RequestMapping(value="/myserverSave", method=RequestMethod.POST)
	public ModelAndView myserverSave(@ModelAttribute("myserver") MyServer myServer ,HttpServletRequest request) throws Exception {
		Gson gson = new Gson();
		myServer.setIsActive("0");
		myServer.setIsDeleted("0");
		myServer.createMyServer();
		
		return new ModelAndView("myserver/result");
	}
	
	@RequestMapping("myserverList")
	public ModelAndView serverList() {
		
		System.out.println("Server-List");
		return new ModelAndView("myserver/result");
	}
	
	@RequestMapping("/myservers")
	public @ResponseBody String getList( ) throws Exception {
		 
		Gson gson = new Gson();
		
		Map<String,Object>map=new HashMap<String,Object>();
		Map<String,Object>map1=new HashMap<String,Object>();
		
		Set<Object>list=new HashSet<Object>();
		MyServer ob = new MyServer();
			for(MyServer myServer: ob.getMyServerList()){
				
				map1=new HashMap<String,Object>();
				
				try{
				if(myServer.getId()!=null){
					map1.put("0",myServer.getId().trim());
				}else
					map1.put("0","Not-Set");
				
				if(myServer.getServerName()!=null){
					map1.put("1", myServer.getServerName().trim());
				}else
					map1.put("1","Not-Set");
				
				if(myServer.getPortNo()!=null){
					map1.put("2", myServer.getPortNo().trim());
				}else
					map1.put("2","Not-Set");
					
				if(myServer.getIpAddress()!=null){
					map1.put("3",myServer.getIpAddress().trim());
				}
				else
					map1.put("3","Not-set");
				
				if(myServer.getIsActive()!=null){
					map1.put("4",myServer.getIsActive().trim());
				}
				else
					map1.put("3","Not-set");
					
				list.add(map1);
				}catch(Exception ee){
					ee.printStackTrace();	
				}
			}
		
		map.put("data",list);
		
		return gson.toJson(map);
	}
	
	@RequestMapping("/upserver")
	public @ResponseBody String upServer(@RequestParam(value="serverId")String serverId,HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		System.out.println(serverId);
		MyServer s = new MyServer(serverId).getMyServerById();
		boolean flag = false;
	    if(s.getIsActive().equals("1"))
	    	s.setIsActive("0");
	    else{
	    	s.setIsActive("1");
	    	flag = true;
	    }
	    s.updateMyServer();
	    if(flag){
	    	DbProperty dbConfig = (DbProperty) ApplicationBeanLoader.INSTANCE.getBean("dbConfig");
	        
	        System.out.println("Serverv is going to switch from : "+dbConfig.getInfo());
	        dbConfig.setIpAddress(s.getIpAddress().trim());
	        dbConfig.setPortNo(s.getPortNo().trim());
	        dbConfig.setInfo(s.getInfo());
	        System.out.println("Server Switched Successfully On "+s.getInfo()+". Server Name:"+s.getServerName());
	    }else{
	    	DbProperty dbConfig = (DbProperty) ApplicationBeanLoader.INSTANCE.getBean("dbConfig");
	    	if(dbConfig.getPortNo().equals(s.getPortNo()) && dbConfig.getIpAddress().equals(s.getIpAddress())){
	    		dbConfig.setIpAddress("127.0.0.1");
		        dbConfig.setPortNo("8080");
		        dbConfig.setInfo("default");
		        System.out.println("Server Switched Successfully On "+dbConfig.getInfo()+".");
	    	}
	    }
	    	
		return serverId+","+s.getIsActive();
	}
	
	@RequestMapping("/manualserverCreateForm")
	public ModelAndView manualserverForm() throws Exception {
		
		System.out.println("from manualserver controller");
		
		return new ModelAndView("myserver/manualserver");
	}
	
	@RequestMapping(value="/manualserverSave", method=RequestMethod.POST)
	public ModelAndView manualserverSave(@ModelAttribute("manualserver") MyServer myServer ,HttpServletRequest request) throws Exception {
		
		DbProperty dbConfig = (DbProperty) ApplicationBeanLoader.INSTANCE.getBean("dbConfig");
        
        System.out.println("Serverv is going to switch from : "+dbConfig.getInfo());
        dbConfig.setIpAddress(myServer.getIpAddress().trim());
        dbConfig.setPortNo(myServer.getPortNo().trim());
        dbConfig.setInfo(myServer.getInfo());
        System.out.println("Server Switched Successfully On "+myServer.getInfo()+". Server Name:"+myServer.getServerName());
		
		return new ModelAndView("myserver/result");
	}
}