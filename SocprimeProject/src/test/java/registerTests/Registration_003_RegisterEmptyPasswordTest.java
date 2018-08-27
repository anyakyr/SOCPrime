package registerTests;

import businessobjects.User;
import org.testng.annotations.Test;
import utility.services.FileReaderService;

import java.util.Map;

import static utility.services.ReportService.assertEquals;
import static utility.services.WaiterService.waitForTextVisible;
import static utility.services.WebElementService.getElementText;


/**
 * Created by Anya on 27.08.2018.
 */
public class Registration_003_RegisterEmptyPasswordTest extends Registration_001_RegistrationClientFormTest{
    @Test
    public void test_003(){

        User user = new User("properties/user/invalidClientLogin.properties");

        bookingPage.enterRegEmailToInput(user.getEmail());
        bookingPage.clickOnStartButton();

        //Verify error messages.
        Map<String, String> error = FileReaderService.getMap("registration/registrationErrors.txt");
        waitForTextVisible(error.get("errorEmptyPassword"), bookingPage.emptyPasswordError, driver);
        assertEquals(getElementText(bookingPage.emptyPasswordError, "Password Error"),
                error.get("errorEmptyPassword"), "Incorrect Password Error message");
    }
}
