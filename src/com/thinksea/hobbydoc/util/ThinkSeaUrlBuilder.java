package com.thinksea.hobbydoc.util;

public class ThinkSeaUrlBuilder {

	public static final String BASE_URL = "http://192.168.1.2:84/WebAPI2/Service1.svc";
	public static final String GET_ALL_DATA_ENDPOINT ="/GetAllData";
	
	public String getAllDataURL(){
		return BASE_URL+GET_ALL_DATA_ENDPOINT;
	}
	
}
