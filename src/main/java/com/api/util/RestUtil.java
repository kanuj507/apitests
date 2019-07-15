package com.api.util;

import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;


public class RestUtil {

	private static String url="";
	
	public static String getCurrentUrl(){
		return url;
	}

    public static Response getByUrl(String url) {
        Response response = RestAssured.given().log().ifValidationFails().get(url);
        response.then().log().ifError();
        return response;
    }

    public static Response postByUrl(String url) {
        Response response = RestAssured.post(url);
        return response;
    }

    public static Response deleteByUrl(String url) {
        Response response = RestAssured.given().delete(url);
        return response;
    }

    public static Response postByUrl(String url, Map<String, Object> body) {
        Response response = RestAssured.
                given()
                .body(body)
                .post(url);
        return response;
    }
    
    public static Response putByUrl(String url, Map<String, Object> body) {
        Response response = RestAssured.
                given()
                .body(body)
                .put(url);
        return response;
    }
}

