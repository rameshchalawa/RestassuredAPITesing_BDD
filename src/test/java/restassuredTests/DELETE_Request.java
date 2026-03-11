package restassuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DELETE_Request {
	
	@Test
    public void deleteEmployeeRecord() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = "/delete/22";
        
        Response response =

        given()
          .when()
            .delete()
          .then()
            .statusCode(200)
            .statusLine("HTTP/1.1 200 OK")
            .log().all()
            .extract().response();
            
            String jsonString = response.asString();
            Assert.assertEquals(jsonString.contains("Successfully! Record has been deleted"), true);
    }

}
