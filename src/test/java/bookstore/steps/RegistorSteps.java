package bookstore.steps;

import bookstore.models.UserRegister;
import bookstore.pages.RegisterPage;
import net.thucydides.core.annotations.Step;

public class RegistorSteps {

    RegisterPage registerPage;

    @Step("���� ������ ������ ������ ������������")
    public void enter_new_user(UserRegister userRegister){
        registerPage.enterFirstName(userRegister.getFirstName());
        registerPage.enterLastName(userRegister.getLastName());
        registerPage.enterUserName(userRegister.getUserName());
        registerPage.enterPaasword(userRegister.getPassword());
        registerPage.clickRecaptcha();
        registerPage.clickRegister();
    }
    @Step("� ������� ������ �����������")
    public void check_succes_registor(){

    }



}
