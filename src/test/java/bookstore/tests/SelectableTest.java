package bookstore.tests;

import bookstore.pages.SelectablePage;
import bookstore.steps.SelectablePageSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.util.List;

@ExtendWith(SerenityJUnit5Extension.class)
public class SelectableTest {

    @Managed
    WebDriver driver;
    @Steps
    SelectablePageSteps selectPageSteps;
    SelectablePage selectablePage;

    @BeforeEach
    public void openPage(){
        selectablePage.open();
    }

    @Test
    @Title("Выделение всех элементов")
    public void selectElements(){
        selectPageSteps.selectAllElements();
        List<String> classElementsList = selectPageSteps.getClassElements();
        classElementsList.stream().forEach(classElement ->
                Assertions.assertEquals("mt-2 list-group-item active list-group-item-action", classElement));
    }

}
