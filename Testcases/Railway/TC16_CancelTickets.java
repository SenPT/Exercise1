package Railway;

import Constant.Constant;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16_CancelTickets extends BaseTest {

    @Test(dataProvider = "dpticket")
    public void TC16(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount)
    {
        System.out.println("TC16 - User can cancel a ticket");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        BookTicket bookTicket = homePage.gotoBookTicket();
        bookTicket.bookTicket(departDate,departFrom,arriveAt, seatType, ticketAmount);

        Myticket myticket = homePage.gotoMyticket();
        myticket.cancelTicket(departFrom,arriveAt);

        new WebDriverWait(Constant.WEBDRIVER, 15).until(ExpectedConditions.alertIsPresent());
        Constant.WEBDRIVER.switchTo().alert().accept();

        FilterTicket filter = new FilterTicket();
        filter.filterTicket(departFrom, arriveAt, departDate,Constant.STATUS);

        String actualMess =  filter.getResultFilter().getText();

        Assert.assertEquals(actualMess,"No result found!", "Don't match");
    }
}
