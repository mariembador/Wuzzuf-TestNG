package Tests;
import Pages.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class homeTest extends testBase{
    @Test(dependsOnGroups = "career")
    public void search() throws InterruptedException {
        home = new homePage(driver);
        try {
            Thread.sleep(2000);
            home.search.clear();
            soft.assertEquals(home.search.getDomAttribute("value"),"");

            home.search.sendKeys("Software Engineer");
            action.keyDown(Keys.ENTER).perform();
            soft.assertEquals(home.search.getDomAttribute("value"), "Software Engineer");
            reportTest.info("Searched for a software engineer job");

            for(WebElement result : home.searchResults){
                soft.assertTrue(result.getText().contains("Software") || result.getText().contains("Engineer"));
            }
            reportTest.info("Results page displays job listing relevant to software engineer");
            action.moveToElement(home.jobsFoundNumber).perform();
            soft.assertTrue(home.jobsFoundNumber.isDisplayed());
            reportTest.info("Number of search results is displayed");
            reportTest.pass("Job searched successfully");
        } catch (Exception e) {
            reportTest.fail("Test failed due to:"+e.getMessage());
            throw e;
        }
    }
    @Test(dependsOnMethods = "search")
    public void filter() throws InterruptedException {
        try {
            soft.assertEquals(driver.getCurrentUrl(), "https://wuzzuf.net/search/jobs/?a=spbl&q=software%20engineer");
            home.datePostedFilter.click();
            soft.assertTrue(home.datePostedFilter.isDisplayed());
            Thread.sleep(200);

            action.moveToElement(home.pastWeekFilter).perform();
            soft.assertTrue(home.pastWeekFilter.isDisplayed());
            home.pastWeekFilter.click();
            soft.assertTrue(home.pastWeekFilter.isSelected());

            reportTest.info("Search results filtered by date posted");
            System.out.println(home.jobsFoundNumber.getText());
            reportTest.info("Number of jobs posted last week" + home.jobsFoundNumber.getText());
            reportTest.pass("Search results filtered by past week successfully");
        }catch (Exception e){
            reportTest.fail("Test failed due to:"+e.getMessage());
            throw e;
        }

    }
    @Test(dependsOnMethods = "filter")
    public void apply() throws InterruptedException {
        try {
            Thread.sleep(2000);
            soft.assertTrue(home.searchResults.getFirst().isDisplayed());
            int currentTabNumbers = driver.getWindowHandles().size();
            action.moveToElement(home.searchResults.getFirst());
            home.searchResults.getFirst().click();
            ArrayList<String> chromeTabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(chromeTabs.get(1));
            soft.assertTrue(driver.getWindowHandles().size()>currentTabNumbers);
            reportTest.info("First job is opened in a new tab");
            home.updatesMessage.click();
            soft.assertTrue(home.applyButton.isDisplayed());
            home.applyButton.click();
            soft.assertTrue(home.saveAndApplyLaterButton.isDisplayed());
            home.saveAndApplyLaterButton.click();
            reportTest.info("Job saved for later");
            soft.assertEquals(home.savedApplicationText.getText(),"1 Saved Draft Applications");
            reportTest.pass("Job saved successfully");
        }catch (Exception e){
            reportTest.fail("Test failed due to:"+e.getMessage());
            throw e;
        }
    }
    @Test(dependsOnMethods = "apply")
    public void deleteAccount() throws InterruptedException {
        try {
            soft.assertTrue(home.profileIcon.isDisplayed());
            home.profileIcon.click();
            soft.assertTrue(home.accountSettings.isDisplayed());
            home.accountSettings.click();
            soft.assertEquals(driver.getCurrentUrl(), "https://wuzzuf.net/settings/account");
            reportTest.info("User directed to account settings page");
            Thread.sleep(1000);
//            action.scrollToElement(home.deleteButton).perform();
            soft.assertTrue(home.deleteButton.isDisplayed());
            home.deleteButton.click();
            Thread.sleep(1000);

            soft.assertTrue(home.confirmDelete.isDisplayed());
            home.confirmDelete.click();
            soft.assertTrue(home.confirmDelete.isSelected());
            soft.assertTrue(home.finalDeleteButton.isEnabled());
            home.finalDeleteButton.click();
            soft.assertEquals(home.confirmMessage.getText(),"Your account has been deleted successfully.");
            reportTest.info("Success message appeared");
            soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/jobs/egypt");

            reportTest.pass("Account deleted successfully");
        }catch (Exception e){
            reportTest.fail("Test failed due to:"+e.getMessage());
            throw e;
        }
    }
}