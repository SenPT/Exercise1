package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_RedirectLoginPageAfterLogin extends BaseTest {
    @Test
    public void TC04() {
        System.out.println("TC04 - User is redirected to Book ticket page after logging in");
        HomePage homePage = new HomePage();

        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        homePage.getTabBookTicket();

        String actualMes = loginPage.getlblHeaderLoginPage().getText();
        Assert.assertEquals(actualMes, "Login Page", "User is not directed to Login page");

        //verify form bookticket is displayed
        if (homePage.getFormBookTicket().isDisplayed() == true) {
            Assert.assertEquals("1","1");
        } else {
            Assert.assertEquals("1","2");
        }
    }
}
