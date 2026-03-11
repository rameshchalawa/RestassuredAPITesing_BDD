package restassuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
1) Test Status Code
2) log response
3) Verifying Single content in response body
4) Verifying Multiple contents in response body
5) Setting parameters & headers
 */

public class BasicValidations_JSON {
	
	//1) Test Status Code

		@Test(priority=1)
		public void testStatusCode() 
		{
			given()
			.when()
				.get("http://jsonplaceholder.typicode.com/posts/5")
			.then()
				.statusCode(200);
			
			//given().when().get("http://jsonplaceholder.typicode.com/posts/5").then().statusCode(200);
		}
		
		//2) log response
		@Test(priority=2)
		public void testLogging() 
		{
		    given()
		    
		    .when()
		        .get("http://jsonplaceholder.typicode.com/posts/2")
		    .then()
		        .statusCode(200)
		        .log().all();
		}
		
		//3) Verifying Single content in response body
		@Test(priority=3)
		public void testSingleContent() 
		{
		    given()
		        .when()
		            .get("http://jsonplaceholder.typicode.com/posts/2")
		        .then()
		            .statusCode(200)
		            .body("title", equalTo("qui est esse"));
		}
		
		//4) Verifying Multiple contents in response body
		@Test(priority=4)
		public void testMultipleContents() {
		    given()
		        .when()
		        .get("https://jsonplaceholder.typicode.com/posts")
		        .then()
		        .body("title",hasItems("qui est esse","nesciunt quas odio","magnam facilis autem"));
		}
		
		// 5) Setting parameters & headers
		@Test(priority=5)
		public void testParamsAndHeaders() {
		    given()
		        .param("MyName", "Ramesh")
		        .header("MyHeader", "Indian")
		    .when()
		        .get("https://jsonplaceholder.typicode.com/posts")
		    .then()
		        .statusCode(200)
		        .log().all();
		}

}
