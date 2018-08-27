package registerTests;

import org.testng.annotations.Test;
import utility.BaseTest;
import utility.Constants;

import static utility.services.ManageUrlService.getDirectlyURL;
import static utility.services.ReportService.assertTrue;
import static utility.services.WebElementService.elementIsDisplayed;

/**
 * Created by Anya on 27.08.2018.
 */
public class Registration_001_RegistrationClientFormTest extends BaseTest {
    @Test
    public void test_001() {

        //Go to landing page.
        getDirectlyURL(Constants.URL, driver);

        //Click on Register link.
        bookingPage.clickOnRegisterButton();

        //Verify that page has all necessary components.
        assertTrue(elementIsDisplayed(bookingPage.regEmailInput, "Email TextField"),
                "Email TextField is NOT displayed");
        assertTrue(elementIsDisplayed(bookingPage.createPassword, "Password TextField"),
                "Password TextField is NOT displayed");
        assertTrue(elementIsDisplayed(bookingPage.startButton, "Start Button"),
                "Start Button is NOT displayed");

    }
}
