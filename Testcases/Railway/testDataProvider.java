package Railway;

import Constant.Constant;
import org.testng.annotations.Test;

public class testDataProvider extends BaseTest{

    @Test(dataProvider = "dp")
    public void TC0001(String username, String password)
    {
        System.out.println("TC14 - User can book many tickets at a time");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(username, password);

    }
}
