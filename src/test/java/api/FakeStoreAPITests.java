package api;

import base.ApiBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;
import io.qameta.allure.*;


public class FakeStoreAPITests extends ApiBase {
    @Epic("API Automation")
    @Feature("Products")
    @Description("Verify product getall functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test
public void testGetAllProducts() {
    Response response = ApiUtils.getAllProducts();
    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertTrue(response.jsonPath().getList("id").size() > 0);
}
    @Epic("API Automation")
    @Feature("Products")
    @Description("Verify product get single functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test
public void testGetSingleProduct() {
    Response response = ApiUtils.getProductById(1);
    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertEquals(response.jsonPath().getInt("id"), 1);
}
    @Epic("API Automation")
    @Feature("Products")
    @Description("Verify product add functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test
public void testAddProduct() {
    String body = "{\"title\": \"Test Product\", \"price\": 10.99, \"description\": \"Test Description\", \"image\": \"https://example.com/image.png\", \"category\": \"electronics\"}";
    Response response = ApiUtils.addProduct(body);
    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertEquals(response.jsonPath().getString("title"), "Test Product");
}
    @Epic("API Automation")
    @Feature("Products")
    @Description("Verify product update functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test
public void testUpdateProduct() {
    String body = "{\"title\": \"Updated Product\", \"price\": 12.99, \"description\": \"Updated Description\", \"image\": \"https://example.com/image.png\", \"category\": \"electronics\"}";
    Response response = ApiUtils.updateProduct(1, body);
    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertEquals(response.jsonPath().getString("title"), "Updated Product");
}
    @Epic("API Automation")
    @Feature("Products")
    @Description("Verify product delete functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test
public void testDeleteProduct() {
    Response response = ApiUtils.deleteProduct(1);
    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertEquals(response.jsonPath().getInt("id"), 1);
}
}
