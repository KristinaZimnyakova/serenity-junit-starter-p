package bookstore.pages;


import lombok.Getter;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;



@DefaultUrl("https://HOST/login")
@Getter
public class LoginPage extends PageObject {

    @FindBy(xpath = "//input[@id='userName']")
    WebElementFacade loginInput;

    @FindBy(xpath = "//button[.='Log out']")
    WebElementFacade logoutButton;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElementFacade passwordInput;

    public void enterLogin(String login){
        loginInput.type(login);
    }

    public void enterPaasword(String password){
        passwordInput.type(password);
    }

    public void clickLogin(){
        find("//*[@id=\"login\"]").click();
    }




}
