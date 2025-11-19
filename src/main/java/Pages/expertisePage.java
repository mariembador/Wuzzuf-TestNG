package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class expertisePage {
    public expertisePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//p[@class=\"css-qqj41n\"]")
    public WebElement tellUsAboutYourExpertiseTitle;

    @FindBy(xpath = "(//input[@aria-autocomplete='list'])[1]")
    public WebElement language;
    @FindBy(xpath = "//form[@id=\"expertise-form\"]/div[1]/div[2]/div/div[1]/div/div[2]/span/*")
    public List<WebElement> languageOptions;
    @FindBy(xpath = "(//input[@aria-autocomplete='list'])[2]")
    public WebElement proficiency;

    @FindBy(xpath = "//button[@class=\"css-1qcc2iu ezfki8j0\"]")
    public WebElement addButton;

    @FindBy(xpath = "(//input[@aria-autocomplete='list'])[3]")
    public WebElement skills;

    @FindBy(xpath = "//button[@class=\"css-1bmbjz3 ezfki8j0\"]")
    public WebElement continueButton;
}
