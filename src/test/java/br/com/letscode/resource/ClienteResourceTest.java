package br.com.letscode.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
public class ClienteResourceTest {

    public void testsIfRequestStatusCodeIs200() {
        RestAssured.given().get("client/list").then().statusCode(200);
    }

}
