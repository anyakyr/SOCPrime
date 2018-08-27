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
public class Registration_004_RegisterPasswordLengthTest extends Registration_001_RegistrationClientFormTest{
    @Test
    public void test_004(){

        User user = new User("properties/user/invalidClientLogin.properties");

        bookingPage.enterRegEmailToInput(user.getEmail());
        bookingPage.enterCreatePassword(user.getPassword());
        bookingPage.clickOnStartButton();

        //Verify error messages.
        Map<String, String> error = FileReaderService.getMap("registration/registrationErrors.txt");
        waitForTextVisible(error.get("errorPasswordLength"), bookingPage.passwordError, driver);
        assertEquals(getElementText(bookingPage.passwordError, "Password Error"),
                error.get("errorPasswordLength"), "Incorrect Password Error message");
    }
}
