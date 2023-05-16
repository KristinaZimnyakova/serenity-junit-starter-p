package bookstore.tests;

import bookstore.models.User;
import bookstore.pages.LoginPage;
import bookstore.pages.ProfilePage;
import bookstore.services.AddBook;
import bookstore.steps.AddBookSteps;
import bookstore.steps.LoginSteps;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddBookTest {

    @Managed
    WebDriver driver;
    @Steps
    AddBookSteps addBookSteps;
    @Steps
    LoginSteps loginSteps;
    ProfilePage profilePage;
    LoginPage loginPage;

    static User user;
    AddBook addBook;
    String isbn = "9781449325862";
    String token;
    String userId;

    @BeforeAll
    public void createUser(){
        user = User.builder().userName("11kris").password("Kristin@123")
                .build();
    }

    @AfterEach
    public void deleteBook(){
        token = addBook.getToken(user);
        userId = addBook.authorization(user);
        ValidatableResponse response= addBook.deleteBook(token, userId, isbn);
        response.statusCode(204);
    }

    @Test
    @Title("Тест добавления книги")
    public void add_book(){
        token = addBook.getToken(user);
        userId = addBook.authorization(user);
        ResponseBodyExtractionOptions body = addBookSteps.add_book(token, userId, isbn);
        assertEquals(body.jsonPath().get("books[0].isbn"), isbn);
        loginPage.open();
        loginSteps.enter_login_and_password(user);
        loginPage.waitForCondition().withTimeoutOf(10).second()
                .until(i -> loginPage.getDriver().getCurrentUrl().contains("profile"));
        assertThat(profilePage.getBook()).contains(isbn);
    }
}
