package bookstore.tests;

import bookstore.models.User;
import bookstore.pages.BookStorePage;
import bookstore.pages.LoginPage;
import bookstore.pages.ProfilePage;
import bookstore.steps.BookStoreSteps;
import bookstore.steps.LoginSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class BookStoreTest {

    @Managed
    WebDriver driver;
    @Steps
    LoginSteps loginSteps;
    @Steps
    BookStoreSteps bookStoreSteps;

    LoginPage loginPage;
    ProfilePage profilePage;
    BookStorePage bookStorePage;
    static User user;

    String bookInput;

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
        profilePage.goToStore();
    }

    @Test
    @Title("Поиск книги и переход на страницу с информацией о книге")
    public void search_and_choose_book(){
        //bookStoreSteps.serch_certain_book();
        //bookStoreSteps.goToBookInformation();

        bookInput = bookStorePage.searchBook();
        String bookTitle = bookStorePage.getBook().getText();
        assertThat(bookInput).isEqualTo(bookTitle);
        bookStorePage.chooseBook();
        assertThat(bookStorePage.getDriver().getCurrentUrl()).contains("books?book=");
        assertThat(bookInput).isEqualTo(bookStorePage.getTitleBook().getText());
        bookStorePage.getBackToStoreButton().shouldBeEnabled();
        bookStorePage.getAddToYourCollectionButton().shouldBeEnabled();
    }

}
