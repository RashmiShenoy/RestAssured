package validation;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ParsingJSONResponseData {
@Test(priority=1)
void testJsonResponse() {
	//Approach 1
	given()
		.contentType("ContentType.JSON")
	.when()
		.get("http://localhost:3000/store")
	.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		.body("book[3].title", equalTo("The Lord of the Rings"));
	}
}
