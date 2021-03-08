package testCases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_Or_Read_A_Product {
	
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void read_All_Products() {
		Response response=
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-type","application/json; charset=UTF-8")
			.queryParam("id", "1209")
		.when()
			.get("/read_one.php")
		.then()
			.extract().response();
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		JsonPath js = new JsonPath(responseBody);
		
		String productID = js.getString("id");
		String productname = js.getString("name");
		String productdescription = js.getString("description");
		
		Assert.assertEquals(productID, "1209");
		Assert.assertEquals(productname, "HP Laptop Elite Pro");
		Assert.assertEquals(productdescription, "Super fast laptop");


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
