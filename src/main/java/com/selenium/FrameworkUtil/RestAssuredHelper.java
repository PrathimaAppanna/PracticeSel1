package com.selenium.FrameworkUtil;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.filter.log.LogDetail;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class RestAssuredHelper {
	
	
	public static Response postAPI(String url,String body)
	{
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.addHeader("Content-Type",ContentType.JSON.toString());
		builder.addHeader("cache-control","no-cache");
		builder.setBody(body);
		builder.log(LogDetail.ALL);
		RequestSpecification requestSpec =builder.build();
		return (Response) RestAssured.expect().given().spec(requestSpec).post(url);
		
	}
	
	public static Response getAPI(String url)
	{
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.addHeader("Content-Type",ContentType.JSON.toString());
		builder.addHeader("cache-control","no-cache");
		builder.addHeader("accept",ContentType.JSON.toString());
		builder.log(LogDetail.ALL);
		RequestSpecification requestSpec =builder.build();
		return (Response) RestAssured.expect().given().spec(requestSpec).get(url);
		
	}

	
}
