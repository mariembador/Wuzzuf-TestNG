package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class infoPage {
    public infoPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//p[@class=\"css-qqj41n\"]")
    public WebElement tellUsAboutYourselfTitle;
    @FindBy(xpath = "//input[@id=\"react-select-2-input\"]")
    public WebElement birthDay;
    @FindBy(xpath = "//div[@class=\"row\"]/div[1]//div[@class=\"css-11r7ebr-menu\"]")
    public WebElement dayOptions;
    @FindBy(xpath = "//input[@id=\"react-select-3-input\"]")
    public WebElement birthMonth;
    @FindBy(xpath = "//input[@id=\"react-select-4-input\"]")
    public WebElement birthYear;

    @FindBy(xpath = "//input[@value=\"female\"]")
    public WebElement femaleGender;
    @FindBy(xpath = "//input[@value=\"male\"]/parent::label")
    public WebElement maleGender;

    @FindBy(xpath = "//form/div[1]/div[5]//input[@id=\"react-select-5-input\"]")
    public WebElement nationality;
    @FindBy(xpath = "//form/div[2]/div[1]//input[@id=\"react-select-6-input\"]")
    public WebElement country;
    @FindBy(xpath = "//form/div[2]/div[2]//input[@id=\"react-select-7-input\"]")
    public WebElement city;
    @FindBy(xpath = "//form/div[2]/div[3]//input[@id=\"react-select-9-input\"]")
    public WebElement area;

    @FindBy(xpath = "//input[@name=\"primaryPhone\"]")
    public WebElement phone;

    @FindBy(xpath = "//button[@type=\"button\"]")
    public WebElement continueButton;
}
