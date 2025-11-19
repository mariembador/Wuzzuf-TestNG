package Tests;

import Pages.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class testBase {
    protected static WebDriver driver;
    homePage home;
    registerPage register;
    infoPage info;
    educationPage education;
    experiencePage experience;
    expertisePage expertise;
    careerPage career;
    protected static Faker fake = new Faker(new Locale("en"));
    SoftAssert soft = new SoftAssert();
    Random random = new Random();
    protected static Actions action;
    protected static ExtentReports report;
    protected static ExtentTest reportTest;

    @BeforeSuite
    public void openBrowser() throws InterruptedException {
        report = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(new File("reports/report.html"));
        report.attachReporter(spark);
//        ChromeOptions options = new ChromeOptions();
//        options.addExtensions(new File("src/main/resources/AdBlock-—-block-ads-across-the-web-Chrome-Web-Store.crx"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://wuzzuf.net/jobs/egypt");
        action = new Actions(driver);
    }

    @BeforeMethod
    public void setupReport(Method method){
        reportTest = report.createTest(method.getName());
    }

    @AfterSuite
    public void quitBrowser() throws InterruptedException, IOException {
        Thread.sleep(2000);
        report.flush();
        Desktop.getDesktop().open(new File("reports/report.html"));
        soft.assertAll();
        driver.quit();
    }
    public void randomSelect(){
        int randomNumber = random.nextInt(1,15);
        for(int i=0; i<randomNumber; i++){
            action.keyDown(Keys.ARROW_DOWN).perform();
        }
        action.sendKeys(Keys.ENTER).perform();
    }
    public int getRandomNumber(int n){
        return random.nextInt(n);
    }
}
