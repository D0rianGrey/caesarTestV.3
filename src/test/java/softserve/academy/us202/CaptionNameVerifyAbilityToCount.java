package softserve.academy.us202;

import org.testng.annotations.Test;
import softserve.academy.pages.TopMenu;
import softserve.academy.us101.BaseTest;

public class CaptionNameVerifyAbilityToCount extends BaseTest {


    @Test(groups = {"schedulePage"}, description = "test verify caption name to count selected group clicking  AllGroup Button")
    public void verifyAbilityToSelectAndDeselect() {

        new TopMenu()
                .goToSchedulePage()
                .clickCurrentGroupTab()
                .clickAllGroupsButton()
                .isSelectedAll()
                .verifyСounterOfSelectedGroups()
                .clickAllGroupsButton()
                .verifyDefaultStateAllGroupsButton()
                .isDeselectedAll()
                .assertAll();

    }

    @Test(groups = {"schedulePage"}, description = "test verify caption name to count selected group")
    public void verifyCounter() {


        new TopMenu()
                .goToSchedulePage()
                .clickCurrentGroupTab()
                .clickAllGroupsButton()
                .isSelectedAll()
                .verifyСounterOfSelectedGroups()
                .clickAllGroupsButton()
                .verifyDefaultStateAllGroupsButton()
                .isDeselectedAll()
                .verifyСounterOfSelectedGroups()
                .assertAll();

    }


}
