package com.selenium.FrameworkUtil;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;

public class FunctionHelper {
	Gson gson = new Gson();
	RestAssuredHelper restAssuredHelper;
	UrlConstants urlConstants;

	public FunctionHelper(String baseUrl) {
		restAssuredHelper = new RestAssuredHelper();
		urlConstants = new UrlConstants(baseUrl);
	}

	public Response createAddress() throws Exception {

		Response response;
		try {
			String payload = gson.toJson(new Address().getAddressPOJO());
			response = restAssuredHelper.postAPI(urlConstants.placeUrl + "qaclick123", payload);
			if (response.getStatusCode() != 200) {

				throw new Exception();
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return response;
	}

}


