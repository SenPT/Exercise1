package Railway;

import Constant.Constant;
import org.testng.annotations.Test;

public class TC09_NewPassAndConfirmPassDifferent extends BaseTest{
    @Test
    public void TC09(){
        System.out.println("TC09 - User can't change password when \"New Password\" and \"Confirm Password\" are different.");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        ChangePassword changePass = homePage.gotoChangePassword();
        changePass.changePassword(Constant.PASSWORD, Constant.NEWPASSWORD, "doesn't match");
    }
}
