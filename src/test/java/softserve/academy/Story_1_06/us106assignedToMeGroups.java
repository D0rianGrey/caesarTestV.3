package softserve.academy.Story_1_06;

import org.testng.annotations.*;
import softserve.academy.BaseTest;
import softserve.academy.actions.AdminPanelActions;
import softserve.academy.actions.GroupsPageActions;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.*;

import static softserve.academy.models.Utils.getDriver;
import static softserve.academy.models.Utils.setDriver;

public class us106assignedToMeGroups {

    @BeforeClass(groups = {"teachersGroups"})
    public void setUpForOrdinaryTest(){

        setDriver()
                .manage()
                .window()
                .maximize();

        new LoginPageActions()
                .openLoginPage()
                .waitLogInPageLoad()
                .login(new User("sasha", "1234"))
                .waitPageLoaded();
    }
//    @DataProvider(name = "provideGroupData")
//    public Object[][] groups() {
//        return new Object[][]{
//                {new Group("DP-019-MQC",Location.DNIPRO,true,Direction.MQC,
//                        "20.10.2018", "20.12.2018","O. Reuta",
//                        "O.Lozoviagin",GroupStage.IN_PROCESS)},
//
//                {new Group("DP-019-JAVA",Location.DNIPRO,false,Direction.JAVA,
//                        "10.02.2018", "10.10.2018","O.Lozoviagin",
//                        "O. Reuta",GroupStage.BOARDING)}
//        };
//    }

    @Test(dataProvider = "provideGroupData", groups = {"teachersGroups"})
    public void teachersAbilityToSeeAllAssignedToThemGroups(Group group){
//        new AdminPanelActions()
//                .openAdminPanel()
//                .openGroupTab()
//                .openCreateModal()
//                .fillAllGroupFieldsAndSubmit(group);
        new GroupsPageActions()
                .verifyAssigntToMeGroups()
                .assertAll();
    }

    @AfterMethod(groups = {"teachersGroups"})
    public void tearDown() {
        getDriver().quit();
    }
}
