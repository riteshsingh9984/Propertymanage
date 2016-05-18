package com.connection;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

public class MongoDb {
	
	/**
	 * IP of that machine where mongoDB installed
	 */
	protected static final String DB_MACHINE_IP = "127.0.0.1";
	/**
	 * MongoDB PortNo
	 */
	protected static final Integer DB_PORT = 27017;
	
	private Mongo getConection() throws UnknownHostException{
		Mongo mongo = null;
		try{
			mongo =  new Mongo(DB_MACHINE_IP, DB_PORT);
		}catch(Exception ee){
			ee.printStackTrace();
		}
		return mongo;
	}
	
	protected WriteResult create(Object object, String collectionName, String dbName) throws UnknownHostException{
		
		WriteResult wr = null;
		try{
			DB db = getConection().getDB(dbName);
			DBCollection collection = db.getCollection(collectionName);
			Gson g = new Gson();
			DBObject dbObject = (DBObject)JSON.parse(g.toJson(object));
			wr = collection.insert(dbObject);
		}catch(Exception ee){
			ee.printStackTrace();
		}
		return wr;
	}
	
	protected DBObject findById(String id, String collectionName, String dbName) throws UnknownHostException{
		
		DB db = getConection().getDB(dbName);
		DBCollection collection = db.getCollection(collectionName);
		
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("id", id);
		
		DBCursor cursor = collection.find(whereQuery);
		while(cursor.hasNext()) {
		    return cursor.next();
		}
		return whereQuery;
	}
	
	protected Set<DBObject> makeAndQuery(Map<String,Object> map, String collectionName, String dbName) throws UnknownHostException{
		
		Set<DBObject> list = new HashSet<DBObject>();
		
		DB db = getConection().getDB(dbName);
		DBCollection collection = db.getCollection(collectionName);
		
		BasicDBObject andQuery = new BasicDBObject();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		
		for (Map.Entry<String,Object> entry : map.entrySet()) {
			
		    obj.add(new BasicDBObject(entry.getKey(), entry.getValue()));
		}
		andQuery.put("$and", obj);
		DBCursor cursor = collection.find(andQuery);
		while(cursor.hasNext()) {
		    list.add(cursor.next());
		}
		return list;
	}
	
	protected Set<DBObject> makeWhereQuery(String attribute, Object value, String collectionName, String dbName) throws UnknownHostException{
		
		Set<DBObject> list = new HashSet<DBObject>();
		DB db = getConection().getDB(dbName);
		DBCollection collection = db.getCollection(collectionName);
		
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put(attribute, value);
		
		DBCursor cursor = collection.find(whereQuery);
		while(cursor.hasNext()) {
		    list.add(cursor.next());
		}
		return list;
	}
	
	protected List<DBObject> getAllDocs(String collectionName, String dbName) throws UnknownHostException{
		
		List<DBObject> list = new ArrayList<DBObject>();
		DB db = getConection().getDB(dbName);
		DBCollection collection = db.getCollection(collectionName);
		
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
		   DBObject obj = cursor.next();
		   list.add(obj);
		}
		return list;
	}
	
	protected WriteResult updateDocs(String updateName,String updateKey, Object object, String collectionName, String dbName) throws UnknownHostException{
		
		WriteResult wr = null;
		try{
			Gson g = new Gson();
			DB db = getConection().getDB(dbName);
			DBCollection collection = db.getCollection(collectionName);
			BasicDBObject searchQuery = new BasicDBObject().append(updateName, updateKey);
			DBObject dbObject = (DBObject)JSON.parse(g.toJson(object));
			wr = collection.update(searchQuery, dbObject);
		}catch(Exception ee){
			ee.printStackTrace();
		}
		
		return wr;
	}
}
