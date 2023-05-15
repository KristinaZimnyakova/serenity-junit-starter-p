package bookstore.tests;

import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.Test;

public class AddBookTest {

    @Test
    public void add_book(){
        String user = "{\"userName\":\"11kris\",\"password\":\"Kristin@123\"}";
        String token = SerenityRest.given().contentType("application/json").body(user)
                .when().log().all().post("https://demoqa.com/Account/v1/GenerateToken")
                .then().log().all().extract().body().jsonPath().get("token");
        SerenityRest.given().contentType("application/json").body(user)
                .when().log().all().post("https://demoqa.com/Account/v1/Login")
                .then().log().all();
        String body = "{\"userId\":\"7fd35b7a-1968-4266-a8a3-6421447b39cf\",\"collectionOfIsbns\":[{\"isbn\":\"9781449325862\"}]}";
        SerenityRest.given().auth().oauth2(token)
                .contentType("application/json").cookie("token", token).cookie("userName", "11kris").body(body)
                .when().log().all().post("https://demoqa.com/BookStore/v1/Books")
                .then().log().all();
    }
}
