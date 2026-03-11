package restassuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
given()
  set cookies, add auth, add param, set headers info etc....
when()
  get, post, put, delete...
then()
  validate status code, extract response, extract headers cookies & response body....
*/

public class GET_Request {
	
	@Test
	  public void getWeatherDetails() 
	  {
	    given()
	      .when()
	        .get("https://openweathermap.org/api")
	      .then()
		        .statusCode(200)
		        .statusLine("HTTP/1.1 200 OK")
		        .header("Content-Type", "text/html; charset=utf-8");
		
	}
}
