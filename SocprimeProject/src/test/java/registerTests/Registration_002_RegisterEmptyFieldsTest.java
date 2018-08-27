package registerTests;

import org.testng.annotations.Test;
import utility.services.FileReaderService;

import java.util.Map;

import static utility.services.ReportService.assertEquals;
import static utility.services.WebElementService.getElementText;

/**
 * Created by Anya on 27.08.2018.
 */
public class Registration_002_RegisterEmptyFieldsTest extends Registration_001_RegistrationClientFormTest {
    @Test
    public void test_002(){

        bookingPage.clickOnStartButton();

        //Verify error messages.
        Map<String, String> error = FileReaderService.getMap("registration/registrationErrors.txt");
        assertEquals(getElementText(bookingPage.registerError, "Empty Form Fields Error"),
                error.get("errorEmptyFormFields"), "Empty Form Fields Error message");
    }
}
