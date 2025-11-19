package Tests;

import Pages.careerPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class careerTest extends testBase{
    @Test(groups = "career", dependsOnGroups = "expertise")
    public void yourCareer() throws InterruptedException {
        career = new careerPage(driver);
        try {
            soft.assertEquals(career.tellUsAboutYourCareerTitle.getText(), "Tell Us About Your Career Interests", "Career title not found");
            reportTest.info("Page has title Tell Us About Your Career Interests");
            Thread.sleep(500);
            WebElement careerLevel = career.careerLevels.get(getRandomNumber(career.careerLevels.size()));
            careerLevel.click();
            soft.assertTrue(careerLevel.isSelected());

            WebElement jobType = career.jobType.get(getRandomNumber(career.jobType.size()));
            jobType.click();
            soft.assertTrue(jobType.isSelected());

            WebElement workplace = career.workplace.get(getRandomNumber(career.workplace.size()));
            workplace.click();
            soft.assertTrue(workplace.isSelected());

            career.job.click();
            randomSelect();
            soft.assertNotNull(career.job.getDomAttribute("value"));

            String salary = Integer.toString(random.nextInt()*10);
            career.minSalary.sendKeys(salary);
            soft.assertEquals(career.minSalary.getText(),salary);

            soft.assertTrue(career.getStartedButton.isEnabled());
            career.getStartedButton.click();
            reportTest.info("Get started button clicked successfully");
            soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/search/jobs/?q=&a=expmty");
            reportTest.pass("Accounted created successfully");
        } catch (Exception e) {
            reportTest.fail("Test failed due to:"+e.getMessage());
            throw e;
        }

    }
}
