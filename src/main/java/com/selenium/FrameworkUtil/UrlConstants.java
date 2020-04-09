package com.selenium.FrameworkUtil;

public class UrlConstants {
	public String placeUrl = "/maps/api/place/add/json?key=";

	public UrlConstants(String baseUrl) {
		this.placeUrl = baseUrl + placeUrl;

	}

}
