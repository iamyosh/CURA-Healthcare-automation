package apiTests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class loginAPITest extends apiBaseTest {

    @Test
    public void loginTest() {

        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("username", "John Doe")
                        .formParam("password", "ThisIsNotAPassword")
                        .when()
                        .post("/authenticate");

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
    }
}
