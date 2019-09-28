package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ClearTripHomePage;
import pages.PageFactory;

public class SignInTest extends BaseTestClass {

    PageFactory pageFactory = new PageFactory();

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        try {
            //Login without credentials
            pageFactory.getClearTripHomePageObj().login(driver, "", "");
            String errors = ClearTripHomePage.loginErrorDiv.getText();
            Assert.assertTrue(errors.contains("There were errors in your submission"));
            Assert.assertTrue(errors.contains("Your username is a required field"));
            Assert.assertTrue(errors.contains("Your account password is a required field"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage()); //We can log the exception message instead printing
            Assert.fail("TC-Failed -" + e.getMessage());
        }
    }
}
