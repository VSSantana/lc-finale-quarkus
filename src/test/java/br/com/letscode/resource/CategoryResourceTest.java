package br.com.letscode.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
public class CategoryResourceTest {

    public void testsIfRequestStatusCodeIs200() {
        RestAssured.given().get("category/list").then().statusCode(200);
    }

}
