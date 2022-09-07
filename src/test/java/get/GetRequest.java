package get;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GetRequest {

    @Test
    public void testGetMethod() {

        given().baseUri("https://reqres.in")
        .when().get("api/single_user")
        .then().log().all().assertThat().statusCode(200)
                           .assertThat().body("data.name", equalTo("Janet"));
    }

}
