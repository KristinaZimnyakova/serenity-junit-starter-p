package bookstore.steps;

import bookstore.pages.SelectablePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.List;

public class SelectablePageSteps {

    SelectablePage selectablePage;

    @Step("���� �������� ��� ��������")
    public void selectAllElements(){
        for(WebElementFacade selectableElement : selectablePage.getSelectableElementsGroup()){
            selectableElement.click();
        }
    }
    @Step("� �������� ����� ���������")
    public List<String> getClassElements(){
        List<String> classElementsList = new ArrayList<>();
        for(WebElementFacade selectableElement : selectablePage.getSelectableElementsGroup()){
            classElementsList.add(selectableElement.getAttribute("class"));
        }
        return classElementsList;
    }
}
