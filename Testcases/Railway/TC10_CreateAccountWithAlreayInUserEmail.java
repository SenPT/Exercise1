package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10_CreateAccountWithAlreayInUserEmail extends BaseTest {
    @Test
    public void TC10(){
        System.out.println("TC10 - User can't create account with an already in-use email");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage register = homePage.gotoRegister();
        String actualMes =  register.registerPage(Constant.USERNAME, Constant.PASSWORD, Constant.PASSWORD, Constant.PID).getMessageRegister();

        Assert.assertEquals(actualMes,"This email address is already in use.","Don't match");
    }
}
