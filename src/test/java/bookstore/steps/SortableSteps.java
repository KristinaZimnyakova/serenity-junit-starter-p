package bookstore.steps;

import bookstore.pages.SortablePage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

public class SortableSteps {

    SortablePage sortablePage;

    @Step("Могу перетащить элемент")
    public void moveElement(WebDriver driver){
        for (int i=0; i<5; i++) {
            sortablePage.moveElement(driver).build().perform();
        }

    }
}
