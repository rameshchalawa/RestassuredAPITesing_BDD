package restassuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;

public class POST_Request {
	
	public static HashMap map = new HashMap();
	
	@BeforeClass
	public void postData() {
		map.put("id", RestUtils.getId());
		map.put("username", RestUtils.getUserName());
		map.put("firstName", RestUtils.getFirstName());
		map.put("lastName", RestUtils.getLastName());
		map.put("email", RestUtils.getEmail());
		map.put("password", RestUtils.getPassword());
		map.put("phone", RestUtils.getPhone());
		map.put("userStatus", "1");
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		RestAssured.basePath = "/user";
		
	}
	
	@Test
	public void testPost() {
		
		given()
        .contentType("application/json")
        .body(map)
    .when()
        .post()
    .then()
        .statusCode(200)
        .and()
        .body("code", equalTo(200))
        .and()
        .body("type", equalTo("unknown"));
		
      }
		
}
