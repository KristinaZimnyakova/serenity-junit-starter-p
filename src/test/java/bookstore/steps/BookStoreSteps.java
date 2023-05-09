package bookstore.steps;

import bookstore.pages.BookStorePage;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BookStoreSteps {

    BookStorePage bookStorePage;
    String bookInput;

    @Step("Могу найти книгу в поиске")
    public void serch_certain_book(){
        bookInput = bookStorePage.searchBook();
        String bookTitle = bookStorePage.getBook().getText();
        assertThat(bookInput).isEqualTo(bookTitle);
    }

    @Step("и перейти в информацию о книге")
    public void goToBookInformation(){
        bookStorePage.chooseBook();
        assertThat(bookStorePage.getDriver().getCurrentUrl()).contains("books?book=");
        assertThat(bookInput).isEqualTo(bookStorePage.getTitleBook().getText());
        bookStorePage.getBackToStoreButton().shouldBeEnabled();
        bookStorePage.getAddToYourCollectionButton().shouldBeEnabled();
    }
}
