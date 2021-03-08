package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class Creat_A_Product {

	@Test
	public void CreatAproduct() {
		HashMap payload = new HashMap();
		
		payload.put("name", "HP Laptop Elite Pro");
		payload.put("description", "Super fast laptop");
		payload.put("price", "1199");
		payload.put("category_name", "Electronics");
		payload.put("category_id", "2");

		
		Response response=
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-type","application/json; charset=UTF-8")
			.body(payload)
		.when()
			.get("/create.php")
		.then()
			.extract().response();
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		JsonPath js = new JsonPath(responseBody);
		
		String message = js.getString("message");
		Assert.assertEquals(message, "Product was created.");
		

//		test
//		String productname = js.getString("name");
//		String productdescription = js.getString("description");
//		
//		Assert.assertEquals(productID, "1209");
//		Assert.assertEquals(productname, "HP Laptop Elite Pro");
//		Assert.assertEquals(productdescription, "Super fast laptop");

//
//		System.out.println(productID);		
						
//		js.prettyPrint();		
//		System.out.println(js);
		
//		int statusCode = response.getStatusCode();
//		System.out.println("Status Code" +statusCode );
//		Assert.assertEquals(statusCode, 201);
//		softAssert.assertEquals(statusCode, 201);
		
//		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
//		System.out.println("responseTime" + responseTime);
//		if(responseTime<= 2000) {
//			System.out.println("Response time within range");
//			
//		}else {
//			System.out.println("not acceptable");
//		}
	}

}
