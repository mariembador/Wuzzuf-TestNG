package Tests;

import Pages.experiencePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class experienceTest extends testBase{
    @Test(groups = "experience", dependsOnGroups = "education")
    public void yourExperience() throws InterruptedException {
        experience = new experiencePage(driver);
        try {
            soft.assertEquals(experience.tellUsAboutYourExperienceTitle.getText(), "Tell Us About Your Experience", "Experience title not found");
            reportTest.info("Page has title tell us about your experience");
            Thread.sleep(200);
            experience.experienceYears.click();
            randomSelect();
            soft.assertNotNull(experience.experienceYears.getDomAttribute("value"));
            Thread.sleep(2000);

            if(!experience.experienceValue.getText().equals("No experience")){
                String jobTitle = fake.job().title();
                experience.jobTitle.sendKeys(jobTitle);
                soft.assertEquals(experience.jobTitle.getText(),jobTitle);

                String company = fake.company().name();
                experience.companyName.sendKeys(company);
                soft.assertEquals(experience.companyName.getText(),company);
                Thread.sleep(1000);

                experience.jobCategory.click();
                randomSelect();
                soft.assertNotNull(experience.jobCategory.getDomAttribute("value"));

                WebElement experienceType = experience.experienceType.get(getRandomNumber(experience.experienceType.size()));
                experienceType.click();
                soft.assertTrue(experienceType.isSelected());

                experience.startMonth.click();
                randomSelect();
                soft.assertNotNull(experience.startMonth.getDomAttribute("value"));
                Thread.sleep(1000);
                int yearNumber = random.nextInt(1900,2025);
                String year = Integer.toString(yearNumber);
                experience.startYear.sendKeys(year);
                action.keyDown(Keys.ENTER).perform();
                soft.assertEquals(experience.startYear.getText(),year);
                Thread.sleep(1000);

                experience.endMonth.click();
                randomSelect();
                soft.assertNotNull(experience.endMonth.getDomAttribute("value"));
                Thread.sleep(1000);

                experience.endYear.sendKeys(Integer.toString(yearNumber+2));
                action.keyDown(Keys.ENTER).perform();
                soft.assertEquals(experience.endYear.getText(),Integer.toString(yearNumber+2));

                soft.assertTrue(experience.saveButton.isEnabled());
                experience.saveButton.click();
                Thread.sleep(3000);
            }
            soft.assertTrue(experience.continueButton.isEnabled());
            experience.continueButton.click();
            soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/setup/expertise?sut=reg&login=1");
            reportTest.pass("Experience data entered successfully");
        }catch (Exception e){
            reportTest.fail("Test failed due to:"+e.getMessage());
            throw e;
        }
    }
}
