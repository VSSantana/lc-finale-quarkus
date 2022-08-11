package br.com.letscode.resource;

@QuarkusTest
public class CategoryResourceTest {

    public void testsIfRequestStatusCodeIs200() {
        RestAssured.given().get("category/list").then().statusCode(200);
    }

}
