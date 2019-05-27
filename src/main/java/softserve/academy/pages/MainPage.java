package softserve.academy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

abstract class MainPage extends BasePage {

    @FindBy(className = "img-circle")
    public WebElement photo;
    @FindBy (xpath="//*[@id='logo']//img")
    public WebElement logo;
    @FindBy(xpath = "//p[@class='groupLocation']")
    public WebElement location;
    @FindBy(xpath = "//p[@class='groupName']")
    public WebElement groupName;
    @FindBy(xpath = "//button[@name='edit']")
    public WebElement cogwheel;
    @FindBy (xpath="//div[contains(concat('',@class,''),'small-group-view')]")
    public List<WebElement> groups;
    @FindBy(xpath = "//button[@class='myGroups']")
    public WebElement myGroupsBtn;
    @FindBy(xpath = "//label[@for='endedGroups']")
    public WebElement finishedGroupsFilter;
    @FindBy(xpath = "//label[@for='currentGroups']")
    public WebElement currentGroupsFilter;
    @FindBy(xpath = "//label[@for='futureGroups']")
    public WebElement plannedGroupsFilter;
    WebElement groupButton; //create new instance of group button before click

    //Returns True if the group with defined name is present in the List of all visible groups
    public boolean groupIsPresent(CharSequence definedGroupName){

        boolean isPresent=false;
        for (WebElement groupBtn:groups) {
            if(groupBtn.getText().contains(definedGroupName)) {
                isPresent=true;
                break;
            }
        }return isPresent;
    }

    //Returns WebElement groupButton with defined name from the List of all visible groups
    public WebElement getGroupButton(CharSequence definedGroupName){
        for (WebElement groupBtn:groups) {
            if(groupBtn.getText().contains(definedGroupName)) {
                groupButton=groupBtn;
                break;
            }
        }return groupButton;
    }

    //Returns True if all groups in the List of all visible groups have defined location
    public boolean groupsHaveLocation(  CharSequence definedLocation){

        boolean isPresent=true;
        for (WebElement groupBtn:groups){
            groupBtn.click();//Selects each group
            //Verifies display group location in the central top area:
            if(!location.getText().contains(definedLocation)){//in case one group does not have defined location
                isPresent=false;
                break;
            }
        }return isPresent;
    }

    //Returns WebElement groupButton of first group from the List of all visible groups or NULL if no available groups
    public WebElement getFirstGroupButton(){
        if (!groups.isEmpty()){
            return groups.get(0);
        } else {
            return null;
        }
    }

}