package Tests;

import Pages.expertisePage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class expertiseTest extends testBase{
    @Test(groups = "expertise", dependsOnGroups = "experience")
    public void yourExpertise() throws InterruptedException {
        expertise = new expertisePage(driver);
        try{
            soft.assertEquals(expertise.tellUsAboutYourExpertiseTitle.getText(), "Tell Us About Your Expertise", "Expertise title not found");
            reportTest.info("Page has title tell us about your expertise");
            Thread.sleep(1000);
            expertise.language.click();
            randomSelect();
            soft.assertNotNull(expertise.language.getDomAttribute("value"));
            Thread.sleep(200);
            expertise.proficiency.click();
            randomSelect();
            soft.assertNotNull(expertise.proficiency.getDomAttribute("value"));

            soft.assertTrue(expertise.addButton.isEnabled());
            expertise.addButton.click();

            for(int i=0; i<2; i++){
                expertise.skills.sendKeys(fake.job().keySkills());
                action.keyDown(Keys.ENTER).perform();
                Thread.sleep(500);
            }
            soft.assertNotNull(expertise.skills.getDomAttribute("value"));
            Thread.sleep(500);

            soft.assertTrue(expertise.continueButton.isEnabled());
            action.keyDown(Keys.ESCAPE).perform();
            expertise.continueButton.click();
            soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/setup/career-interests?sut=reg&login=1");
            reportTest.pass("Expertise data entered successfully");
        } catch (Exception e) {
            reportTest.fail("Test failed due to:"+e.getMessage());
            throw e;
        }

    }
}
