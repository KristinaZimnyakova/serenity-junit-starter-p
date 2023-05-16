package bookstore.tests;

import bookstore.models.User;
import bookstore.pages.LoginPage;
import bookstore.pages.ProfilePage;
import bookstore.steps.LoginSteps;
import bookstore.steps.ProfileSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SerenityJUnit5Extension.class)
public class ProfileTest {
    @Managed
    WebDriver driver;
    @Steps
    LoginSteps loginSteps;
    @Steps
    ProfileSteps profileSteps;

    LoginPage loginPage;
    ProfilePage profilePage;
    static User user;

    @BeforeAll
    public static void createUser(){
        user = User.builder().userName("11kris").password("Kristin@123")
                .build();
    }

    @BeforeEach
    public void openPageAndLogin(){
        loginPage.open();
        loginSteps.enter_login_and_password(user);
        loginPage.waitForCondition().withTimeoutOf(10).second()
                .until(i -> loginPage.getDriver().getCurrentUrl().contains("profile"));
    }


    @Test
    @Title("Проверка, что User Name в профиле соответсвует логину пользователя")
    public void check_login(){
        assertEquals(profilePage.getUserNameValue(), user.getUserName());
    }

    @Test
    @Title("Проверка наличия кнопок в профиле пользователя")
    public void check_button(){
        profilePage.waitForCondition().withTimeoutOf(10).second()
                .until(i -> profilePage.getButtonGoToStore().shouldBePresent());
        profilePage.getButtonDeleteAccount().shouldBeEnabled();
        profilePage.getButtonGoToStore().shouldBeEnabled();
        profilePage.getButtonDeleteAllBooks().shouldBeEnabled();
    }



}
