package bookstore.steps;

import bookstore.models.UserForPracticeForm;
import bookstore.pages.PracticeFormPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

public class PracticeFormSteps {

    PracticeFormPage practiceFormPage;

    @Step("Могу заполнить форму")
    public void filling_page(UserForPracticeForm userForPracticeForm, String picturePath, String subject){
        practiceFormPage.fillingPage(userForPracticeForm, subject);
        practiceFormPage.addFile(picturePath);
    }

    @Step("и нажать submit")
    public void click_submit(WebDriver driver) throws InterruptedException {
        practiceFormPage.javaScriptClick(practiceFormPage.getSubmitButton(), driver);
    }
}
