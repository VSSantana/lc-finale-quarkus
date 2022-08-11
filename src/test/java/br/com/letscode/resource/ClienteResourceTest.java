package br.com.letscode.resource;

@QuarkusTest
public class ClienteResourceTest {

    public void testsIfRequestStatusCodeIs200() {
        RestAssured.given().get("client/list").then().statusCode(200);
    }

}
