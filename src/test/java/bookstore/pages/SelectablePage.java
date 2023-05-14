package bookstore.pages;

import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("https://HOST/selectable")
@Getter
public class SelectablePage extends PageObject {

    @FindBy(xpath = "//ul[@id='verticalListContainer']//li")
    List<WebElementFacade> selectableElementsGroup;


}
