package bookstore.pages;

import lombok.Getter;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://HOST/register")
@Getter
public class RegisterPage extends PageObject {

    @FindBy(xpath = "//input[@id='firstname']")
    WebElementFacade firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElementFacade lastNameInput;

    @FindBy(xpath = "//input[@id='userName']")
    WebElementFacade userNameInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElementFacade passwordInput;

    public void enterFirstName(String firstName){
        firstNameInput.type(firstName);
    }

    public void enterLastName(String lastName) { lastNameInput.type(lastName); }

    public void enterUserName(String userName){
        userNameInput.type(userName);
    }

    public void enterPaasword(String password){
        passwordInput.type(password);
    }

    public void clickRecaptcha(){
        find("//div[@class=\"recaptcha-checkbox-border\"]").click();
    }

    public void clickRegister(){
        find("//button[@id='register']").click();
    }



}
