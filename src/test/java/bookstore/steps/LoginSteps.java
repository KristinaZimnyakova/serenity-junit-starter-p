package bookstore.steps;

import bookstore.models.User;
import bookstore.pages.LoginPage;
import bookstore.pages.ProfilePage;
import net.thucydides.core.annotations.Step;

public class LoginSteps {

    LoginPage loginPage;
    ProfilePage profilePage;

    @Step("Могу ввести учетные данные пользователя")
    public void enter_login_and_password(User user){
        loginPage.enterLogin(user.getLogin());
        loginPage.enterPaasword(user.getPassword());
        loginPage.clickLogin();
    }

    @Step("и успешно пройти аунтитификацию")
    public void check_succes_login(){
        profilePage.waitForCondition().withTimeoutOf(10).second()
                .until(i -> profilePage.getDriver().getCurrentUrl().contains("profile"));
        profilePage.shouldContainText("Profile");
        profilePage.getLogoutButton().shouldBeEnabled();
    }

    @Step
    public void check_fail_login(){
        loginPage.waitForTextToAppear("Invalid username or password!", 10000);
    }
}
