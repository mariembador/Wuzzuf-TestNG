package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class experiencePage {
    public experiencePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class=\"css-qqj41n\"]")
    public WebElement tellUsAboutYourExperienceTitle;

    @FindBy(xpath = "//div[@class=\"css-1c8xh7v e1uslken1\"]")
    public WebElement experienceYears;
    @FindBy(xpath = "//div[@class=\" css-1yygljd-singleValue\"]")
    public WebElement experienceValue;

    @FindBy(xpath = "//input[@name=\"jobTitle\"]")
    public WebElement jobTitle;

    @FindBy(xpath = "//input[@name=\"companyName\"]")
    public WebElement companyName;

    @FindBy(xpath = "(//input[@aria-autocomplete='list'])[2]")
    public WebElement jobCategory;

    @FindBy(xpath = "//div[@class=\"css-1bt6nx3\"]/div")
    public List<WebElement> experienceType;
//    public List<WebElement> experienceType;

    @FindBy(xpath = "(//input[@aria-autocomplete='list'])[3]")
    public WebElement startMonth;

    @FindBy(xpath = "(//input[@aria-autocomplete='list'])[4]")
    public WebElement startYear;

    @FindBy(xpath = "(//input[@aria-autocomplete='list'])[5]")
    public WebElement endMonth;

    @FindBy(xpath = "(//input[@aria-autocomplete='list'])[6]")
    public WebElement endYear;

    @FindBy(xpath = "//button[@name=\"Save_Work_Experience\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@class=\"css-1bmbjz3 ezfki8j0\"]")
    public WebElement continueButton;
}
