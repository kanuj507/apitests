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
    	RestUtil.url=url;
        Response response = RestAssured.given().log().ifValidationFails().get(url);
        response.then().log().ifError();
        return response;
    }

    public static Response postByUrl(String url) {
    	RestUtil.url=url;
        Response response = RestAssured.
                given()
                .log()
                .all()
                .post(url);
        response.then().log().ifError();
        return response;
    }

    public static Response deleteByUrl(String url) {
        RestUtil.url = url;
        Response response = RestAssured.given().log().all().delete(url);
        return response;
    }

    public static Response postByUrl(String url, Map<String, Object> body) {
    	RestUtil.url=url;
        Response response = RestAssured.
                given()
                .log()
                .all()
                .body(body)
                .post(url);
        response.then().log().body();
        return response;
    }
    
    public static Response putByUrl(String url, Map<String, Object> body) {
        RestUtil.url=url;
        Response response = RestAssured.
                given()
                .log()
                .all()
                .body(body)
                .put(url);
        response.then().log().all();
        return response;
    }

    public static Response postCallJsonUrl(String url,HashMap<String, String> headers, String body) {
    	RestUtil.url=url;
        Response   response =RestAssured. given()
                .headers(headers)
                .body(body)
                .log()
                .all()
                .when()
                .post(url);
        return response;
    }

    public static Response getCallUrl(String url, HashMap<String, String> headers) {
    	RestUtil.url=url;
        Response response = RestAssured.
                given()
                .headers(headers)
                .log()
                .all()
                .get(url);
        return response;
    }
}

