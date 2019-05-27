package softserve.academy.AdminTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import softserve.academy.BaseTest;
import softserve.academy.actions.AdminPanelActions;
import softserve.academy.actions.LoginPageActions;
import softserve.academy.models.User;

import java.util.logging.Level;
import java.util.logging.Logger;

import static softserve.academy.models.Utils.getDriver;
import static softserve.academy.models.Utils.setDriver;
@Test(groups = {"admin", "smoke"})
public class AdminSmokeTest extends AdminBaseTest {
   @Test(priority = 1, description = "Verifies each tabButton opens corresponding tab")
    public void allTabsOpenedByTabButtonClick() {
        new AdminPanelActions()
                .openAdminPanel()
                .openUserTab()
                .verifyOpenedTab("users")
                .openGroupTab()
                .verifyOpenedTab("groups")
                .openStudentTab()
                .verifyOpenedTab("students")
                .assertAll();
    }



    @Test(priority = 2, description = "Verifies each addButton opens modal window 'Create/Edit'")
    public void allModalsCreateEditOpenedByAddButtonClick() {
        new AdminPanelActions()
                .openAdminPanel()
                .openUserTab()
                .openCreateModal()
                .verifyOpened()
                .refresh()
                .openGroupTab()
                .openCreateModal()
                .verifyOpened()
                .refresh()
                .openStudentTab()
                .openCreateModal()
                .verifyOpened()
                .assertAll();
    }


    @Test(priority = 3, description = "Verifies editButton opens modal window 'Create/Edit'")
    public void modalsCreateEditOpenedByEditButtonClick() {
        new AdminPanelActions()
                .openAdminPanel()
                .openUserTab()
                .openEditModal(userLogIn.getLogin())
                .verifyOpened();

    }



}
