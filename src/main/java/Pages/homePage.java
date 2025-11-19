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
    @FindBy(xpath = "//button[@class=\"css-c4iikd\"]")
    public WebElement popUpCloseButton;
    @FindBy(xpath = "//div[@class=\"css-150a24d\"]/input")
    public WebElement search;
    @FindBy(xpath = "//button[text()=\"Search\"]")
    public WebElement searchButton;
    @FindBy(xpath = "//h2[@class=\"css-193uk2c\"]//a[@class=\"css-o171kl\"]")
    public List<WebElement> searchResults;

    @FindBy(xpath = "//span[@class=\"css-gsu2vu\"]")
    public WebElement jobsFoundNumber;

    @FindBy(xpath = "//div[@class=\"css-13ujrwv\"]")
    public WebElement datePostedFilter;
    @FindBy(xpath = "//aside/div[1]/div[10]/div/div[3]//div")
    public WebElement pastWeekFilter;

    @FindBy(xpath = "//div[@class=\"css-1cmu9ds\"]")
    public WebElement updatesMessage;
    @FindBy(xpath = "//button[@class=\"css-1sni00m ezfki8j0\"]")
    public WebElement applyButton;
    @FindBy(xpath = "//button[@class=\"css-51gdlk ezfki8j0\"]")
    public WebElement saveAndApplyLaterButton;
    @FindBy(xpath = "//h2[@class=\"css-ncnqkw e744ua62\"]")
    public WebElement savedApplicationText;


    @FindBy(xpath = "//div[@class=\"css-1vq7cfz e1j4u6fw0\"]")
    public WebElement profileIcon;

    @FindBy(xpath = "//a[@href=\"/settings/account\"]")
    public WebElement accountSettings;

    @FindBy(xpath = "//button[@class=\"css-diisyp ezfki8j0\"]")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@class=\"css-1p0ouc3\"]//span[@class=\"css-hx5gx4\"]")
    public WebElement confirmDelete;

    @FindBy(xpath = "//div[@class=\"css-1t8ug1o\"]//button[@class=\"css-diisyp ezfki8j0\"]")
    public WebElement finalDeleteButton;

    @FindBy(xpath = "//h3[@class=\"css-18nekxb\"]")
    public WebElement confirmMessage;
}
