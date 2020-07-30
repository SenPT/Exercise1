package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testBookTickets extends BaseTest{

    @Test(dataProvider = "dpticket")
    public void TC000001(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount)
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

    }
}
