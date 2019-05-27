package softserve.academy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AboutPage extends MainPage {
    @FindBy(id = "main-section")
    public WebElement mainSection;
    @FindBy(xpath = "//*[@id='content-section']/div/div[4]/p")
    public WebElement groupStageTitle;
    @FindBy(xpath = "//*[@id='content-section']/div/div[2]")
    public WebElement contentHeaderGroupName;
    @FindBy(xpath = "//*[@id='left-side-bar']/div/div[1]")
    public WebElement developmentAndReasearch;
    @FindBy(xpath = "//*[@id='left-side-bar']/div/div[2]")
    public WebElement qualityAssurance;
    @FindBy(xpath = "//*[@id='left-side-bar']/div/div[3]")
    public WebElement managementAndMentoring;
    @FindBy(xpath = "//*[@id='left-side-bar']/div/div[4]")
    public WebElement additionalThanks;

    @FindBy(xpath = "//*[@id='main-section']/div/div[1]")
    public WebElement teamDoloto;
    @FindBy(xpath = "//*[@id='main-section']/div/div[2]")
    public WebElement floppyDrive8;
    @FindBy(xpath = "//*[@id='main-section']/div/div[3]")
    public WebElement fixMachine;

    public AboutPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
}
