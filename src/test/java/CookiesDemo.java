import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class CookiesDemo {
	// @Test(priority=1)
	void testCookies() {
		given().when().get("https://www.google.com/").then()
				.cookie("AEC", "Ackid1SrFWYwYNqflxQYS5RMjQv8HvlOOhcs7WDViWHsu8nPmBmJ-j1U7n0").log().all();
	}

	@Test(priority = 2)
	void getCookiesInfo() {
		Response res = given().when().get("https://www.google.com/");

		// get single cookie
		String cookie_value = res.getCookie("AEC");
		System.out.println("Value of cookie is ===> " + cookie_value);

		// get all cookies info
		Map<String, String> cookies_values = res.getCookies();

//		System.out.println(cookies_values.keySet());
		for (String k : cookies_values.keySet()) {
			String cookievalue = res.getCookie(k);
			System.out.println(k + "   " + cookievalue);
		}
	}
}
