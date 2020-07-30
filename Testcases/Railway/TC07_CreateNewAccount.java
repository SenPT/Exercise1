package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_CreateNewAccount extends BaseTest{

    @Test
    public void TC07(){
        System.out.println("TC07 - User can create new account");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage register = homePage.gotoRegister();

        String actualMes = register.registerPage(Constant.NEW_USERNAME, Constant.PASSWORD, Constant.PASSWORD, Constant.PID).getRegisterSucess();
        Assert.assertEquals(actualMes,"Registration Confirmed! You can now log in to the site.","Account is not registered sucessfully");

    }
}
