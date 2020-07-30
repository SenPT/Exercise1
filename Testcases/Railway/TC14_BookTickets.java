package Railway;

import Constant.Constant;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14_BookTickets extends BaseTest {

    @Test(dataProvider = "dpticket")
    public void TC14(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount)
    {
        System.out.println("TC14 - User can book many tickets at a time");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        BookTicket bookTicket = homePage.gotoBookTicket();
        bookTicket.bookTicket(departDate, departFrom,arriveAt, seatType, ticketAmount);

        String actualMes = bookTicket.getMesBookTicket();
        Assert.assertEquals(actualMes,"Ticket booked successfully!","Don't match");

        //Verify table after book ticket
        bookTicket.verifyBookTicket(departFrom, arriveAt,seatType,departDate,Constant.BOOKDATE,Constant.EXPIREDDAY,ticketAmount,Constant.TICKETPRICE);

        Myticket myticket = homePage.gotoMyticket();
        myticket.cancelTicket("Huế","Sài Gòn");

        new WebDriverWait(Constant.WEBDRIVER, 15).until(ExpectedConditions.alertIsPresent());
        Constant.WEBDRIVER.switchTo().alert().accept();
    }
}
