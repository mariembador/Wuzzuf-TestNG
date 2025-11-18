package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class homePage{
    public homePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"css-150a24d\"]/input")
    public WebElement search;
    @FindBy(xpath = "//button[text()=\"Search\"]")
    public WebElement searchButton;
    @FindBy(xpath = "//div[@class=\"css-1gatmva e1v1l3u10\"]//h2[@class=\"css-m604qf\"]//a[@class=\"css-o171kl\"]")
    public List<WebElement> searchResults;

    @FindBy(xpath = "//span[@class=\"css-xkh9ud\"]")
    public WebElement jobsFoundNumber;

    @FindBy(xpath = "//div[@class=\"css-18uqayh\"]")
    public WebElement datePostedFilter;
    @FindBy(xpath = "//aside/div[1]/div[10]/div/div[3]//div")
    public WebElement pastWeekFilter;

    @FindBy(xpath = "//div[@class=\"css-tjo4qw\"]")
    public WebElement updatesMessage;
    @FindBy(xpath = "//button[@class=\"css-1m0yk35 ezfki8j0\"]")
    public WebElement applyButton;
    @FindBy(xpath = "//button[@class=\"css-17magmd ezfki8j0\"]")
    public WebElement saveAndApplyLaterButton;
    @FindBy(xpath = "//h2[@class=\"css-2vkjbx e744ua62\"]")
    public WebElement savedApplicationText;


    @FindBy(xpath = "//div[@class=\"css-1vq7cfz e1j4u6fw0\"]")
    public WebElement profileIcon;

    @FindBy(xpath = "//a[@href=\"/settings/account\"]")
    public WebElement accountSettings;

    @FindBy(xpath = "//button[@class=\"css-14lf7og ezfki8j0\"]")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@class=\"css-1jbawm2\"]//span[@class=\"css-5oy7fs\"]")
    public WebElement confirmDelete;

    @FindBy(xpath = "//div[@class=\"css-1ifqz3c\"]//button[@class=\"css-14lf7og ezfki8j0\"]")
    public WebElement finalDeleteButton;

    @FindBy(xpath = "//h3[@class=\"css-18nekxb\"]")
    public WebElement confirmMessage;

}
