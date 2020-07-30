package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06_RedirectHomePageAfterLogin extends BaseTest {
    @Test
    public  void TC06(){
        System.out.println("TC06 - User is redirected to Home page after logging out ");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        homePage.getTabContact().click();

        loginPage.gotoLogoutPage();

        String actualMes = homePage.getHomePageHeader();
        Assert.assertEquals(actualMes,"Welcome to Safe Railway","Don't match");

        try {
            homePage.getTextLogoutTab();
        }
        catch (NoSuchElementException exception)
        {
            Assert.assertEquals("1","1","");
        }
    }
}
