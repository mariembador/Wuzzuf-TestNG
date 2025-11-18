package Tests;

import Pages.registerPage;
import org.testng.annotations.Test;

public class registerTest extends testBase{
    @Test(groups = "createAccount")
    public void createAccount() throws InterruptedException {
        register = new registerPage(driver);
        try {
            soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/jobs/egypt");

            String fname = fake.name().firstName();
            String lname = fake.name().lastName();
            String email = fake.internet().emailAddress();
            String password = fake.internet().password();
            String jobTitle = fake.job().title();

            soft.assertTrue(register.getStartedButton.isDisplayed());
            register.getStartedButton.click();
            soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/register");
            reportTest.info("Clicked on the Get Started Button");
            Thread.sleep(1000);
            reportTest.info("Filling out the registration form");
            register.firstName.sendKeys(fname);
            soft.assertEquals(register.firstName.getDomAttribute("value"),fname);
            register.lastName.sendKeys(lname);
            soft.assertEquals(register.lastName.getDomAttribute("value"),lname);
            register.email.sendKeys(email);
            soft.assertEquals(register.email.getDomAttribute("value"),email);
            register.password.sendKeys(password);
            soft.assertEquals(register.password.getDomAttribute("value"),password);
            register.jobTitle.sendKeys(jobTitle);
            soft.assertEquals(register.jobTitle.getDomAttribute("value"),jobTitle);
            Thread.sleep(1000);

            reportTest.info("Submitting the registration form");
            soft.assertTrue(register.createAccountButton.isEnabled());
            register.createAccountButton.click();
            soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/create-profile?ref=signup-successful&sut=reg&login=1");
            Thread.sleep(3000);

            reportTest.info("Clicking on 'Sign up manually' button");
            soft.assertTrue(register.singUpManuallyButton.isDisplayed());
            register.singUpManuallyButton.click();
            soft.assertEquals(driver.getCurrentUrl(),"https://wuzzuf.net/setup/general-info?ref=signup-successful&sut=reg&login=1");
            reportTest.pass("Signup form completed successfully");
        }catch (Exception e){
            reportTest.fail("Test failed due to: " + e.getMessage());
            throw e;
        }

    }

}
