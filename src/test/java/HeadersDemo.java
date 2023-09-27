import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HeadersDemo {
//	 @Test(priority=1)
		void testHeaders() {
			given().when().get("https://www.google.com/")
			.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip")
			.header("Server", "gws");
		}
	 
	 @Test(priority=2)
		void getHeaders() {
			Response res = given().when().get("https://www.google.com/");
			
			//Get single header info
			String headervalue = res.getHeader("Content-Type");
			System.out.println("The value of Content-Type header is:" + headervalue);
					
			//Get all headers info
			Headers myheaders = res.getHeaders();
			
			for(Header hd : myheaders) {
				System.out.println(hd.getName()+"  "+hd.getValue());
			}
			
		}
}
