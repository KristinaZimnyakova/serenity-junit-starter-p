package bookstore.tests;

import bookstore.models.User;
import bookstore.models.UserForPracticeForm;
import bookstore.pages.LoginPage;
import bookstore.pages.PracticeFormPage;
import bookstore.steps.LoginSteps;
import bookstore.steps.PracticeFormSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SerenityJUnit5Extension.class)
public class PracticeFormTest {

    @Managed
    WebDriver driver;
    @Steps
    LoginSteps loginSteps;
    @Steps
    PracticeFormSteps practiceFormStep;

    LoginPage loginPage;
    PracticeFormPage practiceFormPage;

    static UserForPracticeForm userForPracticeForm;
    static User user;

    public static String userDir = System.getProperty("user.dir");
    String picturePath = String.format("%s\\photo.jpg", userDir);

    @BeforeAll
    public static void createUser(){
        userForPracticeForm = UserForPracticeForm.builder().firstName("Ivan").lastName("Petrov").userEmail("123@mail.ru")
                .userNumber("1234567890").currentAddress("Samara")
                .build();
        user = User.builder().userName("11kris").password("Kristin@123")
                .build();
    }

    @BeforeEach
    public void openPageAndLogin(){
        loginPage.open();
        loginSteps.enter_login_and_password(user);
        loginPage.waitForCondition().withTimeoutOf(10).second()
                .until(i -> loginPage.getDriver().getCurrentUrl().contains("profile"));
        practiceFormPage.open();
    }

    @Test
    @Title("Заполнение всех полей")
    public void check_filling() {
        practiceFormStep.filling_page(userForPracticeForm, picturePath);
        //practiceFormStep.click_submit(); //кнопки submit нет - Нужно уменьшить масштаб
    }




}
