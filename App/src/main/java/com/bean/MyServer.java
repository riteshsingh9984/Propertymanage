/**
 * 
 */
package com.bean;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.connection.MongoDb;
import com.google.gson.Gson;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

/**
 * @author bmp
 *
 */
public class MyServer extends MongoDb {

	private static final String DB_NAME = "myserver";
	private static final String COLLECTION_NAME = "serverroom";
	
	private String id;
	private String portNo;
	private String ipAddress;
	private String serverName;
	private String info;
	private String isActive;
	private String isDeleted;
	
	public MyServer(){}
	public MyServer(String id){
		this.id = id;
	}
	
	/**
	 * @return the id1
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id1 the id1 to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the portNo
	 */
	public String getPortNo() {
		return portNo;
	}


	/**
	 * @param portNo the portNo to set
	 */
	public void setPortNo(String portNo) {
		this.portNo = portNo;
	}


	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}


	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}


	/**
	 * @return the serverName
	 */
	public String getServerName() {
		return serverName;
	}


	/**
	 * @param serverName the serverName to set
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}


	/**
	 * @return the isActive
	 */
	public String getIsActive() {
		return isActive;
	}


	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	/**
	 * @return the isDeleted
	 */
	public String getIsDeleted() {
		return isDeleted;
	}


	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	/**
	 * This method use to create object in CouchDB
	 * 
	 * @update RITESH SINGH at 24 March 2016
	 * @param object
	 * @param bucket
	 * @return Response
	 * @throws UnknownHostException 
	 */
	public WriteResult createMyServer() throws UnknownHostException{
		return this.create(this, COLLECTION_NAME, DB_NAME);
	}
	
	
	/**
	 * This method use to getAll Projects
	 * 
	 * @param object
	 * @param bucket
	 * @return List<JsonObject>
	 * @throws UnknownHostException 
	 */
	public List<MyServer> getMyServerList() throws UnknownHostException{
			
		Gson gson = new Gson();
		List<DBObject> list = this.getAllDocs(COLLECTION_NAME, DB_NAME);
		List<MyServer> myServers = new ArrayList<MyServer>();
		for(DBObject data : list){
			MyServer p = gson.fromJson(gson.toJson(data), MyServer.class);
			myServers.add(p);
		}
	
		return myServers;
	}
	
	/**
	 * This method use to get Projects from CouchDB on the basis of given key
	 * 
	 * @param object
	 * @param bucket
	 * @return Project
	 * @throws UnknownHostException 
	 */
	/*public Project getProject(String key){
		Gson gson = new Gson();	
		Project project = gson.fromJson(this.getDocsOnKey(BUCKET_NAME, key), Project.class);
		return project;
	}*/
	
	public MyServer getMyServerById() throws UnknownHostException{
		try{
			DBObject data = findById(this.id, COLLECTION_NAME,DB_NAME);
			Gson gson = new Gson();

			MyServer myServer = gson.fromJson(gson.toJson(data), MyServer.class);
			return myServer;
		}catch(Exception ee){
			ee.printStackTrace();
		}
		return null;
	}
	
	public Set<MyServer> getWhereQuery(String attribute, Object value) throws UnknownHostException{
		Set<MyServer> list = new HashSet<MyServer>();
		try{
			Set<DBObject> datalist = makeWhereQuery(attribute, value, COLLECTION_NAME, DB_NAME);
			Gson gson = new Gson();
			try{
				for(DBObject data : datalist){
					list.add(gson.fromJson(gson.toJson(data), MyServer.class));
				}
			}catch(Exception ee){
				ee.printStackTrace();
			}
			return list;
		}catch(Exception ee){
			ee.printStackTrace();
		}
		return null;
	}
	
	public Set<MyServer> getAndQuery(Map<String, Object> map) throws UnknownHostException{
		Set<MyServer> list = new HashSet<MyServer>();
		try{
			Set<DBObject> datalist = makeAndQuery(map, COLLECTION_NAME, DB_NAME);
			Gson gson = new Gson();
			try{
				for(DBObject data : datalist){
					list.add(gson.fromJson(gson.toJson(data), MyServer.class));
				}
			}catch(Exception ee){
				ee.printStackTrace();
			}
			return list;
		}catch(Exception ee){
			ee.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method use to update Server from MongoDB
	 * 
	 * @update RITESH SINGH at 17 May 2016
	 * @param object
	 * @param bucket
	 * @return null
	 * @throws UnknownHostException 
	 */
	public void updateMyServer() throws UnknownHostException{
		updateDocs("id",this.getId().trim(), this, COLLECTION_NAME, DB_NAME);
	}
	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	
}
