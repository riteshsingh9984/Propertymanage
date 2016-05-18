package ironman.propertyutility.controllers;

import ironman.propertyutility.bean.DbProperty;

public class Test {

	public static void main(String...strings) throws Exception{
		DbProperty dbConfig = (DbProperty) ApplicationBeanLoader.INSTANCE.getBean("dbConfig");
        
        System.out.println(dbConfig.toString());
        System.out.println("===============================");
	}
}
