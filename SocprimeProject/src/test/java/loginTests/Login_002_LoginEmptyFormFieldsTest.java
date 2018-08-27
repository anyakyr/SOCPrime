package loginTests;

import org.testng.annotations.Test;
import utility.services.FileReaderService;

import java.util.Map;

import static utility.services.ReportService.assertEquals;
import static utility.services.WebElementService.getElementText;

/**
 * Created by Anya on 27.08.2018.
 */
public class Login_002_LoginEmptyFormFieldsTest extends Login_001_LoginFormTest{
    @Test
    public void test_002() {

        bookingPage.clickOnLoginButton();

        //Verify error messages.
        Map<String, String> error = FileReaderService.getMap("login/loginErrors.txt");

        assertEquals(getElementText(bookingPage.loginError, "Empty Form Fields Error"),
                error.get("errorEmptyFormFields"), "Empty Form Fields Error message");
    }
}
