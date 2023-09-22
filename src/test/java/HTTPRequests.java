import org.testng.annotations.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.*;

import java.util.HashMap;

public class HTTPRequests {
	int id;
	
	@Test(priority=1)
	void getUser() {
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	}
	
	@Test(priority=2)
	void createUser() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "rash");
		map.put("job","trainer" );
		id = given()
			.contentType("application/json")
			.body(map)
		.when()
			.post("https://reqres.in/api/users/2")
			.jsonPath().getInt("id");
//		.then()
//			.statusCode(201)
//			.log().all();
	}
	
	@Test(priority=3, dependsOnMethods = {"createUser"})
	void updateUser() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "pavan");
		map.put("job","teacher" );
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put("https://reqres.in/api/users/" + id)
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority=4)
	void deleteUser() {
		given()
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
			.log().all();
	}
}
