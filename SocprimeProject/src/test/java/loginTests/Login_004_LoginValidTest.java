package loginTests;

import businessobjects.User;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static utility.services.WaiterService.waitPageLoader;
import static utility.services.WebElementService.elementIsDisplayed;

/**
 * Created by Anya on 27.08.2018.
 */
public class Login_004_LoginValidTest extends Login_001_LoginFormTest{
    @Test
    public void test_004() {

        User user = new User("properties/user/clientlogin.properties");

        bookingPage.enterUsernameToInput(user.getEmail());
        bookingPage.enterPasswordToInput(user.getPassword());
        bookingPage.clickOnLoginButton();

        waitPageLoader(driver);
        assertTrue(elementIsDisplayed(clientPage.accButton,"Acc Button"),
               "Acc Button is NOT displayed");
    }
}
