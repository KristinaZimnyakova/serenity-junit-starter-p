package bookstore.steps;

import bookstore.pages.ProfilePage;
import net.thucydides.core.annotations.Step;

public class ProfileSteps {

    ProfilePage profilePage;

    //�� ����� �� ���
    @Step("� ������� ������������ ���� ������")
    public void check_button_profile(){
        profilePage.getButtonDeleteAccount().shouldBeEnabled();
        profilePage.getButtonGoToStore().shouldBeEnabled();
        profilePage.getButtonDeleteAllBooks().shouldBeEnabled();
    }

}
