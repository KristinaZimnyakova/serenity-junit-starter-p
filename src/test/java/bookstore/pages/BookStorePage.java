package bookstore.pages;

import lombok.Getter;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://HOST/books")
@Getter
public class BookStorePage extends PageObject {

    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElementFacade book;

    @FindBy(xpath = "//input[@placeholder='Type to search']")
    WebElementFacade searchInput;

    @FindBy(xpath = "//div[@id='title-wrapper']//label[@id='userName-value']")
    WebElementFacade titleBook;

    @FindBy(xpath = "//div[@class='text-left fullButton']/button[@id='addNewRecordButton']")
    WebElementFacade backToStoreButton;

    @FindBy(xpath = "//div[@class='text-right fullButton']/button[@id='addNewRecordButton']")
    WebElementFacade addToYourCollectionButton;


    public String searchBook(){
        String bookTitle = book.getText();
        searchInput.type(bookTitle);
        return bookTitle;
    }
    public void chooseBook(){
        book.click();
    }

}
