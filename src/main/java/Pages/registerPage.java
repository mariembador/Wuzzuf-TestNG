package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerPage {
    public registerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class=\"css-1ith43a eswc9qo0\"]")
    public WebElement getStartedButton;

    @FindBy(xpath = "//input[@id=\"firstname\"]")
    public WebElement firstName;
    @FindBy(xpath = "//input[@id=\"lastname\"]")
    public WebElement lastName;
    @FindBy(xpath = "//input[@id=\"email\"]")
    public WebElement email;
    @FindBy(xpath = "//input[@name=\"password\"]")
    public WebElement password;
    @FindBy(xpath = "//input[@class=\"css-1itq9hi ek82ord0\"]")
    public WebElement jobTitle;
    @FindBy(xpath = "//button[@class=\"css-12g3p01 ezfki8j0\"]")
    public WebElement createAccountButton;

    @FindBy(xpath = "//a[@btntype=\"secondary\"]")
    public WebElement singUpManuallyButton;

    @FindBy(xpath = "//span[@aria-live=\"polite\"]")
    public WebElement dropdown;
}
