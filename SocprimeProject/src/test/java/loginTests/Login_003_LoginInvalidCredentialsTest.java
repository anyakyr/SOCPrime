package loginTests;

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
public class Login_003_LoginInvalidCredentialsTest extends Login_001_LoginFormTest{
    @Test
    public void test_003() {

        User user = new User("properties/user/invalidClientLogin.properties");

        bookingPage.enterUsernameToInput(user.getEmail());
        bookingPage.enterPasswordToInput(user.getPassword());
        bookingPage.clickOnLoginButton();

        //Verify error messages.
        Map<String, String> error = FileReaderService.getMap("login/loginErrors.txt");
        waitForTextVisible(error.get("errorIncorrectData"), bookingPage.loginError, driver);
        assertEquals(getElementText(bookingPage.loginError, "Invalid Credentials Error"),
                error.get("errorIncorrectData"), "Incorrect Credentials Error message");

    }
}