package bookstore.services;

import bookstore.models.User;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddBook {

    public static final String URL = "https://demoqa.com";

    public static HashMap<String, Object> jsonBook(String userId, String isbn) {
        HashMap<String, Object> json = new HashMap<>();
        json.put("userId", userId);
        List<HashMap<String, Object>> collectionOfIsbns = new ArrayList<>();
        HashMap<String, Object> book1 = new HashMap<>();
        book1.put("isbn", isbn);
        collectionOfIsbns.add(book1);
        json.put("collectionOfIsbns", collectionOfIsbns);
        return json;
    }

    public static HashMap<String, Object> jsonBookDelete(String userId, String isbn) {
        HashMap<String, Object> json = new HashMap<>();
        json.put("userId", userId);
        json.put("isbn", isbn);
        return json;
    }


    public static String getToken(User user){
        RestAssured.baseURI = AddBook.URL;
        String token = SerenityRest.given().contentType("application/json").body(user)
                .when().log().ifValidationFails().post("/Account/v1/GenerateToken")
                .then().log().ifValidationFails().extract().body().jsonPath().get("token");
        return token;
    }

    public static String authorization(User user){
        RestAssured.baseURI = AddBook.URL;
        String userId = SerenityRest.given().contentType("application/json").body(user)
                .when().log().ifValidationFails().post("/Account/v1/Login")
                .then().log().ifValidationFails().extract().body().jsonPath().get("userId");
        return userId;
    }

    public static ResponseBodyExtractionOptions addBook(String token, String userId, String isbn){
        RestAssured.baseURI = AddBook.URL;
        return SerenityRest.given().auth().oauth2(token)
                .contentType("application/json")
                .body(jsonBook(userId, isbn))
                .when().log().ifValidationFails().post("/BookStore/v1/Books")
                .then().log().ifValidationFails().extract().body();
    }

    public static ValidatableResponse deleteBook(String token, String userId, String isbn){
        RestAssured.baseURI = AddBook.URL;
        return SerenityRest.given().auth().oauth2(token)
                .contentType("application/json")
                .body(jsonBookDelete(userId, isbn))
                .when().log().ifValidationFails().delete("/BookStore/v1/Book")
                .then().log().ifValidationFails();
    }

}
