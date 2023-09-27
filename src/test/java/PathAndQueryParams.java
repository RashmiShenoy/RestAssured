import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.*;

public class PathAndQueryParams {
	//https://reqres.in/api/users?page=2&id=5
	
	@Test
	void testPathAndQueryParams() {
		given()
			.pathParam("mypath1", "api")
			.pathParam("mypath2", "users")
			.queryParam("page", 2)
			.queryParam("id", 5)
		.when()
			.get("https://reqres.in/{mypath1}/{mypath2}")
		.then()
			.statusCode(200)
			.log().all();
	}
}
