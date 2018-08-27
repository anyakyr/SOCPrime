package registerTests;

import businessobjects.User;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import static utility.services.WaiterService.waitPageLoader;
import static utility.services.WebElementService.elementIsDisplayed;


/**
 * Created by Anya on 27.08.2018.
 */
public class Registration_005_RegisterClientTest extends Registration_001_RegistrationClientFormTest{
    @Test
    public void test_005() {

        User user = new User("properties/user/regClientlogin.properties");

        bookingPage.enterRanEmail();
        bookingPage.enterCreatePassword(user.getPassword());
        bookingPage.clickOnStartButton();

        waitPageLoader(driver);
        assertTrue(elementIsDisplayed(clientPage.accButton,"Acc Button"),
                "Acc Button is NOT displayed");
    }
}
