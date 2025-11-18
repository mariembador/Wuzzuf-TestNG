package Tests;

import Pages.infoPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class infoTest extends testBase{
    @Test(groups = "info", dependsOnGroups = "createAccount")
    public void yourInfo() throws InterruptedException {
        info = new infoPage(driver);
        try {
            soft.assertEquals(info.tellUsAboutYourselfTitle.getText(), "Tell Us About Yourself", "Info title not found");
            reportTest.info("Page has the title Tell Us About Yourself");
            Thread.sleep(500);
            info.birthDay.click();
            randomSelect();
            soft.assertNotNull(info.birthDay.getDomAttribute("value"));
            info.birthMonth.click();
            randomSelect();
            soft.assertNotNull(info.birthMonth.getDomAttribute("value"));
            info.birthYear.click();
            randomSelect();
            soft.assertNotNull(info.birthYear.getDomAttribute("value"));

            info.maleGender.click();
            soft.assertTrue(info.maleGender.isSelected());

            info.nationality.click();
            randomSelect();
            soft.assertNotNull(info.nationality.getDomAttribute("value"));

            info.country.click();
            randomSelect();
            soft.assertNotNull(info.country.getDomAttribute("value"));
            Thread.sleep(1000);

            info.city.click();
            randomSelect();
            soft.assertNotNull(info.city.getDomAttribute("value"));

            if(!driver.findElements(By.xpath("//form/div[2]/div[3]//input[@id=\"react-select-9-input\"]")).isEmpty()){
                info.area.click();
                randomSelect();
                soft.assertNotNull(info.area.getDomAttribute("value"));
            }

            String phoneNumber = fake.phoneNumber().phoneNumber().replaceAll("[^0-9]","");
            info.phone.sendKeys(phoneNumber);
            soft.assertEquals(info.phone.getText(),phoneNumber);

            soft.assertTrue(info.continueButton.isEnabled());
            info.continueButton.click();
            soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/setup/education?sut=reg&login=1");
            reportTest.pass("Users info entered successfully");
        } catch (Exception e) {
            reportTest.fail("Test failed due to:"+e.getMessage());
            throw e;
        }
    }
}
