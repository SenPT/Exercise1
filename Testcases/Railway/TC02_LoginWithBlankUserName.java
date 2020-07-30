package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_LoginWithBlankUserName extends BaseTest{
    @Test
    public void TC02(){
        System.out.println("TC02 - User can't login with blank \"Username\" textbox");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMesg = loginPage.login("", Constant.PASSWORD).getBlankUserNameMsg();

        Assert.assertEquals(actualMesg,"There was a problem with your login and/or errors exist in your form.","Message appears don't match");

    }
}
