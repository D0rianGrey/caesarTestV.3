package softserve.academy.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import softserve.academy.pages.adminPanel.AdminPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static softserve.academy.models.Utils.BASE_URL;
import static softserve.academy.models.Utils.getDriver;

public class AdminPanelActions extends BaseActions {
    private static String ADMIN_POSTFIX = "admin";
    AdminPanel adminPanel = new AdminPanel();
    WebElement addButton;
    List<WebElement> actualTable;
    WebElement actualRow;
    List<WebElement> actualCells;
    List<String> groupNames = new ArrayList<>();

    public AdminPanelActions openAdminPanel() {
        getDriver().get(BASE_URL + ADMIN_POSTFIX);
        waitVisible(adminPanel.header);
        LOGGER.log(Level.INFO, "Wait for opening Admin Panel...");
        return this;
    }

    public AdminPanelActions openUserTab() {
        waitClickable(adminPanel.usersTab).click();
        return this;
    }

    public AdminPanelActions openGroupTab() {
        waitClickable(adminPanel.groupsTab).click();
        return this;
    }

    public AdminPanelActions openStudentTab() {
        waitClickable(adminPanel.studentsTab).click();
        return this;
    }

    //*************************************************************************************************************

    public AdminModalActions openCreateModal() {
        if (moveTo(adminPanel.addUser).isDisplayed()) {
            addButton = adminPanel.addUser;
        } else if (moveTo(adminPanel.addGroup).isDisplayed()) {
            addButton = adminPanel.addGroup;
        } else if (moveTo(adminPanel.addStudent).isDisplayed()) {
            addButton = adminPanel.addStudent;
        }
        addButton.click();
        return chooseModalBy(addButton.getText());
    }

    public AdminModalActions openEditModal(String rowName) {
        adminPanel.edit = getDriver().findElement
                (By.xpath(".//*[text()='" + rowName + "']/following-sibling::td[last()]/button[@class='btn btn-info edit']"));
        moveTo(adminPanel.edit).click();
        return chooseModalBy(rowName);
    }

    private AdminModalActions chooseModalBy(String elementText) {
        waitVisible(adminPanel.modalWindow);
        String ID = getDriver().findElement(By.xpath(".//*[text()='" + elementText + "']/ancestor::div[@id]")).getAttribute("id");

        return new AdminModalActions(ID);
    }

    //************************************************************************************************************
    public AdminPanelActions deleteRowByName(String rowName){
        adminPanel.delete=getDriver().findElement
                (By.xpath(".//tr/td[text()='"+rowName+"']//..//td/button[@class='btn btn-danger delete']"));
        moveTo(adminPanel.delete).click();
        return this;
    };

    //************************************************************************************************************

    //Table Work private

    private List<WebElement> returnTableByTabName(String tabName){
        actualTable=null;
        actualTable = getDriver().findElements
                (By.xpath("//*[@id='"+tabName+"']/div/table/tbody/tr"));
        return  adminPanel.table;
    }

    private WebElement returnActualRowByTabNameAndRowText(String tabName, CharSequence rowText) {
        actualRow=null;
        returnTableByTabName(tabName);
        for (WebElement row : actualTable) {
            if (row.getText().contains(rowText)) {
                actualRow = row;
                break;
            }
        }
        return actualRow;
    }

    private boolean findRowByTabNameAndRowText(String tabName, CharSequence rowText) {
        returnTableByTabName(tabName);
        boolean isPresent=false;
        for (WebElement row : actualTable) {
            if (row.getText().contains(rowText)) {
                isPresent=true;
                break;
            }
        }return isPresent;
    }

    private WebElement returnCellByTabRowCellNames(String tabName, CharSequence rowName, CharSequence cellName) {
        adminPanel.rowCell=null;
        returnActualRowByTabNameAndRowText(tabName, rowName);
        adminPanel.rowCells=adminPanel.tableRow.findElements(By.tagName("td"));
        for (WebElement cell : adminPanel.rowCells) {
            if (cell.getText().contains(cellName)) {
                adminPanel.rowCell=cell;
                break;
            }
        }return adminPanel.rowCell;
    }


    /*@AlonaMath*/
    public List<String> returnCellTextByTabRowNames(String tabName, CharSequence rowName, int cellNumber) {
        List<WebElement> fields = new ArrayList<>();

        returnTableByTabName(tabName);

        for (WebElement row : actualTable) {
            if (row.getText().contains(rowName)) {
                fields = row.findElements(By.tagName("td"));
                groupNames.add(fields.get(cellNumber).getText());
            }
        }return groupNames;
    }

    private boolean findCellByTabRowCellNames(String tabName, CharSequence rowName, CharSequence cellName) {
        returnActualRowByTabNameAndRowText(tabName, rowName);
        adminPanel.rowCells=adminPanel.tableRow.findElements(By.tagName("td"));
        boolean isPresent=false;
        for (WebElement cell : adminPanel.rowCells) {
            if (cell.getText().contains(cellName)) {
                isPresent=true;
                break;
            }
        }return isPresent;
    }

    private boolean findCellByTextInActualRow(String text) {
        actualCells=actualRow.findElements(By.tagName("td"));
        boolean isPresent=false;
        for (WebElement cell : actualCells) {
            if (cell.getText().contains(text)) {
                isPresent=true;
                break;
            }
        }return isPresent;
    }
    //************************************************************************************************************
    // Assertions

    public AdminPanelActions verifyOpenedTab(String tabName) {
        String tHead = getDriver().findElement(By.xpath("//*[@id='" + tabName + "']/div/table/thead")).getText();
        CharSequence uniqueField = "";
        switch (tabName) {
            case "users":
                uniqueField = "login";
                break;
            case "groups":
                uniqueField = "direction";
                break;
            case "students":
                uniqueField = "entryScore";
        }
        softAssert.assertTrue(tHead.contains(uniqueField), tabName+" is not opened");
        return this;
    }

    public verifyCell verifyRowWithNamePresentInTab(String name, String tabName) {
        returnActualRowByTabNameAndRowText(tabName, name);
        softAssert.assertNotNull(actualRow, "cannot find "+name+" in "+tabName);
        return new verifyCell();
    }
    //This method is invoked only after the previous  assertRowWithNamePresentInTab:
    public class verifyCell extends BaseActions {
        public verifyCell verifyCellWithTextPresentInRow(String text) {
            softAssert.assertTrue(findCellByTextInActualRow(text));
            return this;
        }

    }

    //*****************************************************************************************************************
    //UTILS

    public AdminPanelActions refresh() {
        getDriver().get(BASE_URL + ADMIN_POSTFIX);
        return this;
    }

    public AdminPanelActions pause(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }


}

