package bookstore.pages;

import lombok.Getter;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;


@DefaultUrl("https://HOST/sortable")
@Getter
public class SortablePage extends PageObject {

    @FindBy(xpath = "//div[@id='demo-tabpane-list']//div[text()='Six']")
    WebElementFacade elementSix;

    @FindBy(xpath = "//div[@class='vertical-list-container mt-4']//div[@class='list-group-item list-group-item-action'][1]")
    WebElementFacade elementFirst;

    public Actions moveElement(WebDriver driver){
        Actions action = new Actions(driver)
                .clickAndHold(elementFirst)
                .moveToElement(elementSix)
                .pause(Duration.ofSeconds(1))
                .release();
        return action;
    }

    public List<String> listOfElements(){
        return findAll("//div[@id='demo-tabpane-list']//div//div").stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }
}


