package bookstore.tests;

import bookstore.models.UserRegister;
import bookstore.pages.RegisterPage;
import bookstore.steps.RegistorSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static bookstore.dataGenerator.DataGenerator.generator;

@ExtendWith(SerenityJUnit5Extension.class)
public class RegisterTest {

    @Managed
    WebDriver driver;
    @Steps
    RegistorSteps registorSteps;

    RegisterPage registerPage;
    static UserRegister userRegister;

    @BeforeEach
    public void openLoginPage(){
        registerPage.open();
        userRegister = userRegister.builder()
                .firstName(generator()).lastName(generator()).userName(generator()).password(generator()).build();
    }

    @Test
    @Title("Тест успешной регистрации")
    //падает на капче
    public void success_registor(){
        registorSteps.enter_new_user(userRegister);
    }



}
