package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_LoginWithInvalidPassword extends BaseTest{
    @Test
    public void TC03(){
        System.out.println("TC03 - User cannot log into Railway with invalid password ");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMesg = loginPage.login(Constant.USERNAME, "invalid password").getBlankUserNameMsg();

        Assert.assertEquals(actualMesg,"Invalid username or password. Please try again.","Message appears don't match");
    }
}
