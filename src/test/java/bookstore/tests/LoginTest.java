package bookstore.tests;

import bookstore.models.User;
import bookstore.pages.LoginPage;
import bookstore.pages.ProfilePage;
import bookstore.steps.LoginSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class LoginTest {

    @Managed
    WebDriver driver;
    @Steps
    LoginSteps loginSteps;

    LoginPage loginPage;
    ProfilePage profilePage;
    static User user;

    @BeforeAll
    public static void createUser(){
        user = User.builder().login("upaul").password("Qwerty123!")
                .build();
    }

    @BeforeEach
    public void openLoginPage(){
        loginPage.open();
    }

    @Test
    @Title("Тест успешной авторизации")
    public void success_login(){
        loginSteps.enter_login_and_password(user);
        loginSteps.check_succes_login();
    }

    @Test
    @Title("Тест НЕ успешной авторизации")
    public void fail_login(){
        User failUser = User.builder().login("upaul").password("Qwerty123")
                .build();
        loginSteps.enter_login_and_password(failUser);
        loginSteps.check_fail_login();
    }


}
