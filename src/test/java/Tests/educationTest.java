package Tests;

import Pages.educationPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class educationTest extends testBase{
    @Test(groups = "education", dependsOnGroups = "info")
    public void yourEducation() throws InterruptedException {
        education = new educationPage(driver);
        try {
            soft.assertEquals(education.tellUsAboutYourEducationTitle.getText(), "Tell Us About Your Education", "Education title not found");
            reportTest.info("Page has title tell us about your education");
            Thread.sleep(500);
            int i = getRandomNumber(education.educationLevel.size());
            education.educationLevel.get(i).click();
            soft.assertTrue(education.educationLevel.get(i).isSelected());
            if(i==3){
                String schoolName = fake.name().firstName();
                education.schoolName.sendKeys(schoolName);
                soft.assertEquals(education.schoolName.getText(),schoolName);
                education.certificate.click();
                randomSelect();
                soft.assertNotNull(education.certificate.getDomAttribute("value"));

                education.language.click();
                randomSelect();
                soft.assertNotNull(education.language.getDomAttribute("value"));

                education.schoolGraduationYear.click();
                randomSelect();
                soft.assertNotNull(education.schoolGraduationYear.getDomAttribute("value"));

                education.schoolGrade.click();
                randomSelect();
                soft.assertNotNull(education.schoolGrade.getDomAttribute("value"));
            }else {
                String field = fake.job().field();
                education.fieldOfStudy.sendKeys(field);
                soft.assertEquals(education.fieldOfStudy.getText(),field);

                String university = fake.university().name();
                education.university.sendKeys(university);
                action.keyDown(Keys.ENTER).perform();
                soft.assertEquals(education.university.getText(),university);

                education.graduationYear.click();
                randomSelect();
                soft.assertNotNull(education.graduationYear.getDomAttribute("value"));

                education.grade.click();
                randomSelect();
                soft.assertNotNull(education.grade.getDomAttribute("value"));
            }
            soft.assertTrue(education.continueButton.isEnabled());
            education.continueButton.click();
            soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/setup/experience?sut=reg&login=1");
            reportTest.pass("Education data entered successfully");
        } catch (Exception e) {
            reportTest.fail("Test failed due to:"+e.getMessage());
            throw e;
        }
    }
}
