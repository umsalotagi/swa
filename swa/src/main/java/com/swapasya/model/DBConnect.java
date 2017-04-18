package com.swapasya.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.swapsya.config.SpringMongoConfig;

public class DBConnect {
	public static MongoOperations op;
static
	{
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	op = (MongoOperations) ctx.getBean("mongoTemplate");

		
	}
	
}
