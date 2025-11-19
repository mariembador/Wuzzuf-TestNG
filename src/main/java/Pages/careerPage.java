package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class careerPage {
    public careerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[@class=\"css-qqj41n\"]")
    public WebElement tellUsAboutYourCareerTitle;

    @FindBy(xpath = "//div[@name=\"careerLevel\"]")
    public WebElement careerLevel;

    @FindBy(xpath = "//div[@name=\"careerLevel\"]/div")
    public List<WebElement> careerLevels;

    @FindBy(xpath = "//form/div[2]/div/button")
    public List<WebElement> jobType;

    @FindBy(xpath = "//form/div[3]/div/button")
    public List<WebElement> workplace;

    @FindBy(xpath = "(//input[@aria-autocomplete='list'])[1]")
    public WebElement job;

    @FindBy(xpath = "//input[@name=\"minimumSalary\"]")
    public WebElement minSalary;

    @FindBy(xpath = "//button[@class=\"css-i3qizm ezfki8j0\"]")
    public WebElement getStartedButton;
}
