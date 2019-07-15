package com.api.util;

import org.testng.annotations.BeforeSuite;

public class TestBase {

	protected static String baseURI;
    protected RestUtil restUtil;

    // @BeforeSuite(alwaysRun = true)
    // public void setup() {
    //
    // }

	@BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
		
		//Base URI
        baseURI = PropertiesUtil.getEnvProperty("baseURI");
        System.out.println(baseURI);
        restUtil = new RestUtil();
	}

}