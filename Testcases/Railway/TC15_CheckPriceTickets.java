package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15_CheckPriceTickets extends BaseTest {
    @Test
    public void TC15()
    {
        System.out.println("TC15 - \"Ticket price\" page displays with ticket details after clicking on \"check price\" link in \"Train timetable\" page");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Timetable timetb = homePage.gotoTimeTable();
        timetb.checkPrice("Đà Nẵng","Sài Gòn");

        //Verify ticket page is loaded
        String acutalMes1 = timetb.getlblTicketPageTitle().getText();
        Assert.assertEquals(acutalMes1,"Ticket Price","Don't match");

        String actualMes2 = timetb.getlblPriceTableTitle().getText();
        Assert.assertEquals(actualMes2,"Ticket price from Đà Nẵng to Sài Gòn","Don't match");

        //Verify ticket price table
        timetb.verifyTicketPriceTable(Constant.HS,Constant.SS,Constant.SSC,Constant.HB,Constant.SB,Constant.SBC);

    }
}
