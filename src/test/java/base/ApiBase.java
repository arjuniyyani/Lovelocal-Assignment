package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class ApiBase {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }
}
