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

    @FindBy(xpath = "//p[@class=\"css-15yw7ce\"]")
    public WebElement tellUsAboutYourEducationTitle;

    @FindBy(xpath = "//div[@name=\"currentEducationLevel\"]/div")
    public List<WebElement> educationLevel;

    @FindBy(xpath = "//input[@class=\"css-1a96k50 ek82ord0\"]")
    public WebElement fieldOfStudy;

    @FindBy(xpath = "//input[@id=\"react-select-14-input\"]")
    public WebElement university;

    @FindBy(xpath = "//input[@id=\"react-select-15-input\"]")
    public WebElement graduationYear;

    @FindBy(xpath = "//input[@id=\"react-select-16-input\"]")
    public WebElement grade;

    @FindBy(xpath = "//input[@name=\"school\"]")
    public WebElement schoolName;

    @FindBy(xpath = "//input[@id=\"react-select-17-input\"]")
    public WebElement certificate;

    @FindBy(xpath = "//input[@id=\"react-select-18-input\"]")
    public WebElement language;

    @FindBy(xpath = "//input[@id=\"react-select-19-input\"]")
    public WebElement schoolGraduationYear;

    @FindBy(xpath = "//input[@id=\"react-select-20-input\"]")
    public WebElement schoolGrade;

    @FindBy(xpath = "//button[@class=\"css-2dg8nw ezfki8j0\"]")
    public WebElement continueButton;
}
