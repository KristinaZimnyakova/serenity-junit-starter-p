package bookstore.pages;

import bookstore.models.UserForPracticeForm;
import lombok.Getter;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@DefaultUrl("https://HOST/automation-practice-form")
@Getter
public class PracticeFormPage extends PageObject {

    @FindBy(xpath = "//input[@id='firstName']")
    WebElementFacade firstNameInput;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElementFacade lastNameInput;

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElementFacade userEmailInput;

    int i;
    String gender = "//input[@type='radio']" + '['+ i + "]";

    @FindBy(xpath = "//label[@for='gender-radio-1']") //один из 3 переделать c gender selector
    WebElementFacade genderInput;

    @FindBy(xpath = "//input[@id='userNumber']")
    WebElementFacade userNumberInput;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    WebElementFacade dateOfBirthInput;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    WebElementFacade monthSelect;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']/option") //один из 12 переделать
    WebElementFacade monthSelectOption;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    WebElementFacade yearSelect;

    @FindBy(xpath = "//select[@class=\"react-datepicker__year-select\"]/option[106]")
    WebElementFacade yearSelectOption106;

    @FindBy(xpath = "//div[@class='react-datepicker__week'][3]/div[2]")
    WebElementFacade dateSelect;

    @FindBy(xpath = "//input[@id='subjectsInput']")
    WebElementFacade subjectsInput; //сюда отправить e

    @FindBy(xpath = "//div[text()='English' and contains(@id, 'react-select-2-option')]")
    WebElementFacade subjectsAutoComplete;

    @FindBy(xpath = "//div[@class='css-12jo7m5 subjects-auto-complete__multi-value__label']") //для гет текст проверки
    WebElementFacade subjectsResult;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']") //один из 3 переделать c hobbies selector
    WebElementFacade checkboxHobbies;

    @FindBy(xpath = "//input [@id='uploadPicture']")
    WebElementFacade uploadPictureInput;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElementFacade currentAddressTextarea;

    @FindBy(xpath = "//div[text()='Select State']")
    WebElementFacade selectState;

    @FindBy(xpath = "//div[@id='react-select-3-option-1']")
    WebElementFacade selectStateOption;

    @FindBy(xpath = "//div[text()=\"Select City\"]")
    WebElementFacade selectCity;

    @FindBy(xpath = "//div[@id=\"react-select-4-option-0\"]")
    WebElementFacade selectCityOptions;

    @FindBy(xpath = "td[text()='Student Name'] + td") //нерабочий
    WebElementFacade studentNameText;

    @FindBy(xpath = "//button[@id=\"closeLargeModal\"]")
    WebElementFacade closeButton;

    public void fillingPage(UserForPracticeForm userForPracticeForm){
        firstNameInput.type(userForPracticeForm.getFirstName());
        lastNameInput.type(userForPracticeForm.getLastName());
        userEmailInput.type(userForPracticeForm.getUserEmail());
        genderInput.click();
        userNumberInput.type(userForPracticeForm.getUserNumber());

        dateOfBirthInput.click();
        monthSelect.click();
        monthSelectOption.click();
        yearSelect.click();
        yearSelectOption106.click();
        dateSelect.click();

        subjectsInput.type("e");
        subjectsAutoComplete.click();

        checkboxHobbies.click();

        currentAddressTextarea.type(userForPracticeForm.getCurrentAddress());

        selectState.click();
        selectStateOption.click();
        selectCity.click();
        selectCityOptions.click();
    }

    public void clickSubmit(){
        find("//button[@id='submit']").click();
    }

    public void addFile(String picturePath){
        uploadPictureInput.sendKeys(picturePath);
    }




}
