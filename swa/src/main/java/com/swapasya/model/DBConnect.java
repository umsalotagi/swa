package com.swapasya.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.swapasya.config.SpringMongoConfig;

public class DBConnect {
	public static MongoOperations op;
	
public static MongoOperations getConnection()
	{
	System.out.println("Getting connection");
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	
	
	op = (MongoOperations) ctx.getBean("mongoTemplate");
	System.out.println("got bean");
	
return op;
		
	}
	
}
