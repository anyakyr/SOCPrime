package loginTests;

import org.testng.annotations.Test;
import utility.BaseTest;
import utility.Constants;

import static utility.services.ManageUrlService.getDirectlyURL;
import static utility.services.ReportService.assertTrue;
import static utility.services.WebElementService.elementIsDisplayed;

/**
 * Created by Anya on 27.08.2018.
 */
public class Login_001_LoginFormTest extends BaseTest {
    @Test
    public void test_001(){

        //Go to landing page.
        getDirectlyURL(Constants.URL,driver);

        //Click on login link.
        bookingPage.clickOnLogintoAccButton();

        //Verify that page has all necessary components.
        assertTrue(elementIsDisplayed(bookingPage.emailInput,"Username TextField"),
                "Username TextField is NOT displayed");
        assertTrue(elementIsDisplayed(bookingPage.passwordInput,"Password TextField"),
                "Password TextField is NOT displayed");
        assertTrue(elementIsDisplayed(bookingPage.loginButton,"Login Button"),
                "Login Button is NOT displayed");
    }
}
