package bookstore.steps;

import bookstore.services.AddBook;
import io.restassured.response.ResponseBodyExtractionOptions;
import net.thucydides.core.annotations.Step;

public class AddBookSteps {

    AddBook addBook;

    @Step("Могу добавить книгу")
    public ResponseBodyExtractionOptions add_book(String token, String userId, String isbn){
        return addBook.addBook(token, userId, isbn);
    }


}
