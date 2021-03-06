package com.dev.apitest;

import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.testng.Assert;
import com.google.gson.JsonParser;


public class validator {
    JsonParser parser = new JsonParser();

    public void validateResponse(Response res, int code){
        System.out.println("----------------Validating Response-----------------");
        verifyStatusCode(res, code);
        System.out.println("----------------Validation Done-----------------");
    }

    public void verifyStatusCode(Response res){
        int statusCode = res.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    public void verifyStatusCode(Response res, int code){
        int statusCode = res.getStatusCode();
        Assert.assertEquals(statusCode, code);
    }

    public void verifyStatus(Response res){

        JsonObject response = parser.parse(res.getBody().asString()).getAsJsonObject();
        String status = response.getAsJsonObject().get("status").getAsString();
        Assert.assertEquals(status, "success");
    }
}
