package bookstore.steps;

import bookstore.models.UserForPracticeForm;
import bookstore.pages.PracticeFormPage;
import net.thucydides.core.annotations.Step;

public class PracticeFormSteps {

    PracticeFormPage practiceFormPage;

    @Step("Могу заполнить форму")
    public void filling_page(UserForPracticeForm userForPracticeForm, String picturePath){
        practiceFormPage.fillingPage(userForPracticeForm);
        practiceFormPage.addFile(picturePath);
    }

    @Step("и нажать submit")
    public void click_submit(){
        practiceFormPage.clickSubmit();
    }
}
