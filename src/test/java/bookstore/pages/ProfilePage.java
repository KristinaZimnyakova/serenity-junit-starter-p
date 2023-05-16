package bookstore.pages;

import lombok.Getter;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://HOST/profile")
@Getter

public class ProfilePage extends PageObject {

    @FindBy(xpath = "//button[.='Log out']")
    WebElementFacade logoutButton;

    @FindBy(xpath = "//label[@id='userName-value']")
    WebElementFacade userNameValue;

    @FindBy(xpath = "//button[@id='gotoStore']")
    WebElementFacade buttonGoToStore;

    @FindBy(xpath = "//button[text()='Delete Account']")
    WebElementFacade buttonDeleteAccount;

    @FindBy(xpath = "//div[@class='text-right button di']/button[text()='Delete All Books']")
    WebElementFacade buttonDeleteAllBooks;

    @FindBy(xpath = "//span/a")
    WebElementFacade bookTitle;

    public String getUserNameValue(){
        return userNameValue.getText();
    }

    public String getBook(){
        return bookTitle.getAttribute("href");
    }

    public void goToStore(){
        buttonGoToStore.click();
    }

}
