package bookstore.tests;

import bookstore.pages.SortablePage;
import bookstore.steps.SortableSteps;
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
import java.util.stream.Collectors;

@ExtendWith(SerenityJUnit5Extension.class)
public class SortableTest {
    @Managed
    WebDriver driver;
    SortablePage sortablePage;

    @Steps
    SortableSteps sortableSteps;

    @BeforeEach
    public void openPage(){
        sortablePage.open();
    }

    @Test
    @Title("Обратная сортировка")
    public void sort(){
        sortableSteps.moveElement(driver);
        List<String> resultList= sortablePage.listOfElements();
        Assertions.assertEquals(6, resultList.size());
        Assertions.assertEquals("One", resultList.get(5));
        Assertions.assertEquals("Six", resultList.get(0));
    }
}
