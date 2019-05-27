package softserve.academy.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import softserve.academy.pages.LeftContextMenu;

import java.util.logging.Level;

public class LeftContextMenuActions extends BaseActions {

    LeftContextMenu leftMenu = new LeftContextMenu();

    public LeftContextMenuActions verifyCreateButtonDisplayed() {
        softAssert.assertTrue(waitClickable(leftMenu.createButton).isDisplayed());
        LOGGER.log(Level.INFO, "Create button is display ...");
        return this;
    }

    public ModalWindowCreateGroupActions openCreateGroupModalWindow() {
        waitClickable(leftMenu.createButton).click();
        return new ModalWindowCreateGroupActions();
    }

    public void deleteGroup() {
        waitClickable(leftMenu.deleteButton).click();
        waitClickable(wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//i[@class='fa fa-check-circle-o fa-3x']")))).click();
    }

}