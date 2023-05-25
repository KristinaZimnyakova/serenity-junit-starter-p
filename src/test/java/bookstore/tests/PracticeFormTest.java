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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
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
    String subject = "English";
    String pictureName = "photo.jpg";

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
        practiceFormPage.open();
    }

    @Test
    @Title("Тест формы регистрации студента с заполнением всех полей")
    public void check_filling() throws InterruptedException {
        practiceFormStep.filling_page(userForPracticeForm, picturePath, subject);
        practiceFormPage.getSubmitButton().shouldBeEnabled();
        practiceFormStep.click_submit(driver);
        String studentName = userForPracticeForm.getFirstName() + " " + userForPracticeForm.getLastName();
        Assertions.assertEquals(studentName, practiceFormPage.getStudentNameText().getText());
        Assertions.assertEquals(userForPracticeForm.getUserEmail(), practiceFormPage.getStudentEmailText().getText());
        Assertions.assertEquals(userForPracticeForm.getUserNumber(), practiceFormPage.getStudentMobileText().getText());
        Assertions.assertEquals(subject, practiceFormPage.getStudentSubjectsText().getText());
        Assertions.assertEquals(pictureName, practiceFormPage.getStudentPictureText().getText());
        Assertions.assertEquals(userForPracticeForm.getCurrentAddress(), practiceFormPage.getStudentAddressText().getText());
        Assertions.assertFalse(practiceFormPage.getStudentGenderText().getText().isEmpty());
        Assertions.assertFalse(practiceFormPage.getStudentHobbiesText().getText().isEmpty());
        Assertions.assertFalse(practiceFormPage.getStudentStateAndCityText().getText().isEmpty());
        Assertions.assertFalse(practiceFormPage.getStudentDateOfBirthText().getText().isEmpty());
        practiceFormPage.getCloseButton().shouldBeEnabled();
        practiceFormPage.getCloseButton().click();
    }




}
