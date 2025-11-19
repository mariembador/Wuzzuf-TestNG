package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class educationPage {
    public educationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[@class=\"css-qqj41n\"]")
    public WebElement tellUsAboutYourEducationTitle;

    @FindBy(xpath = "//div[@name=\"currentEducationLevel\"]/div")
    public List<WebElement> educationLevel;

    @FindBy(xpath = "//input[@class=\"css-1a96k50 ek82ord0\"]")
    public WebElement fieldOfStudy;

    @FindBy(xpath = "(//div[@class=\"css-1dnjvql\"]//input)[1]")
    public WebElement university;

    @FindBy(xpath = "(//div[@class=\"css-1dnjvql\"]//input)[2]")
    public WebElement graduationYear;

    @FindBy(xpath = "(//div[@class=\"css-1dnjvql\"]//input)[3]")
    public WebElement grade;

    @FindBy(xpath = "//input[@name=\"school\"]")
    public WebElement schoolName;

    @FindBy(xpath = "(//div[@class=\"css-1dnjvql\"]//input)[1]")
    public WebElement certificate;

    @FindBy(xpath = "(//div[@class=\"css-1dnjvql\"]//input)[2]")
    public WebElement language;

    @FindBy(xpath = "(//div[@class=\"css-1dnjvql\"]//input)[3]")
    public WebElement schoolGraduationYear;

    @FindBy(xpath = "(//div[@class=\"css-1dnjvql\"]//input)[4]")
    public WebElement schoolGrade;

    @FindBy(xpath = "//button[@class=\"css-1bmbjz3 ezfki8j0\"]")
    public WebElement continueButton;
}
