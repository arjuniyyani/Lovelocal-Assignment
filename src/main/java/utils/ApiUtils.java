package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static Response getAllProducts() {
        return given().when().get("/products");
    }

    public static Response getProductById(int id) {
        return given().when().get("/products/" + id);
    }

    public static Response addProduct(String body) {
        return given().header("Content-Type", "application/json").body(body).post("/products");
    }

    public static Response updateProduct(int id, String body) {
        return given().header("Content-Type", "application/json").body(body).put("/products/" + id);
    }

    public static Response deleteProduct(int id) {
        return given().when().delete("/products/" + id);
    }
}
