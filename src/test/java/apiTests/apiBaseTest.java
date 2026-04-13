package apiTests;
import io.restassured.RestAssured;

public class apiBaseTest {

        public apiBaseTest() {
            RestAssured.baseURI = "https://katalon-demo-cura.herokuapp.com";
        }
}
