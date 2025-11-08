package Days01;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SimpleAPITest {
    
    @Test
    void getUsers() {
        given()
        
        .when()
            .get("https://reqres.in/api/users?page=2")
        
        .then()
            .statusCode(200)
            .body("page", equalTo(2))
            .log().all();
    }
}