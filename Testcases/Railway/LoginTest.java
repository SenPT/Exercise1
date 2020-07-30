package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void TC01(){
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage= homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome "+ Constant.USERNAME;

        Assert.assertEquals(actualMsg,expectedMsg, "Welcome message is not displayed as expected");

    }

    @Test
    public void TC02(){
        System.out.println("TC02 - User can't login with blank \"Username\" textbox");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMesg = loginPage.login("",Constant.PASSWORD).getBlankUserNameMsg();

        Assert.assertEquals(actualMesg,"There was a problem with your login and/or errors exist in your form.","Message appears don't match");

    }
    @Test
    public void TC03(){
        System.out.println("TC03 - User cannot log into Railway with invalid password ");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMesg = loginPage.login(Constant.USERNAME, "invalid password").getBlankUserNameMsg();

        Assert.assertEquals(actualMesg,"Invalid username or password. Please try again.","Message appears don't match");
    }

    @Test
    public void TC04(){
        System.out.println("TC04 - User is redirected to Book ticket page after logging in");
        HomePage homePage = new HomePage();
        homePage.open();

        homePage.getTabBookTicket().click();
        LoginPage loginPage = new LoginPage();

        //verify navigate to LoginPage
        String actualMes = loginPage.getlblHeaderLoginPage().getText();
        Assert.assertEquals(actualMes,"Login Page","User is not directed to Login page");

        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        //verify form bookticket is displayed
        if(Constant.WEBDRIVER.findElement(By.xpath("//form[@method = 'post']")).isDisplayed() == true)
        {
            Assert.assertEquals("1","1");
        }
        else
        {
            Assert.assertEquals("1","2");
        }


    }
    @Test
    public  void TC06(){
        System.out.println("TC06 - User is redirected to Home page after logging out ");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

       loginPage.login(Constant.USERNAME, Constant.PASSWORD);

       Constant.WEBDRIVER.findElement(By.xpath("//a[@href='/Page/Contact.cshtml']")).click();

       loginPage.gotoLogoutPage();

       String actualMes = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//h1")).getText();
       Assert.assertEquals(actualMes,"Welcome to Safe Railway","Don't match");

       try {
           Constant.WEBDRIVER.findElement(By.xpath("//a[@href= '/Account/Logout']//span")).getText();
       }
       catch (NoSuchElementException exception)
       {
           Assert.assertEquals("1","1","");
       }
    }

    @Test
    public void TC07(){
        System.out.println("TC07 - User can create new account");
        HomePage homePage = new HomePage();
        homePage.open();

       RegisterPage register = homePage.gotoRegister();

      String actualMes = register.registerPage(Constant.NEW_USERNAME, Constant.PASSWORD, Constant.PASSWORD, Constant.PID).getRegisterSucess();
      Assert.assertEquals(actualMes,"Registration Confirmed! You can now log in to the site.","Account is not registered sucessfully");

    }

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

    @Test
    public void TC10(){
        System.out.println("TC10 - User can't create account with an already in-use email");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage register = homePage.gotoRegister();
       String actualMes =  register.registerPage(Constant.USERNAME, Constant.PASSWORD, Constant.PASSWORD, Constant.PID).getMessageRegister();

        Assert.assertEquals(actualMes,"This email address is already in use.","Don't match");
    }

    @Test
    public void TC11(){
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage register = homePage.gotoRegister();
        RegisterPage reg = new RegisterPage();
        String actualmes1 = register.registerPage("abcn1@mailinator.com","","","").getMessageRegister();
        String actualMes2 = register.getMesPassRgister();
        String actualMes3 = register.getMsgPid();

        Assert.assertEquals(actualmes1,"There're errors in the form. Please correct the errors and try again.","not match");
        Assert.assertEquals(actualMes2,"Invalid password length","not match");
        Assert.assertEquals(actualMes3,"Invalid ID length","not match");
    }

    @Test
    public void TC14()
    {
        System.out.println("TC14 - User can book many tickets at a time");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        BookTicket bookTicket = homePage.gotoBookTicket();
        bookTicket.bookTicket(Constant.DEPARTDATE, Constant.DEPARTFROM,Constant.ARRIVEAT, Constant.SEATTYPE, Constant.TICKETAMOUNT);

        String actualMes = bookTicket.getMesBookTicket();
        Assert.assertEquals(actualMes,"Ticket booked successfully!","Don't match");

        //Verify table after book ticket
        bookTicket.verifyBookTicket(Constant.DEPARTFROM, Constant.ARRIVEAT,Constant.SEATTYPE,Constant.DEPARTDATE,Constant.BOOKDATE,Constant.EXPIREDDAY, Constant.TICKETAMOUNT,Constant.TICKETPRICE);

        Myticket myticket = homePage.gotoMyticket();
        myticket.cancelTicket("Huế","Sài Gòn");

        new WebDriverWait(Constant.WEBDRIVER, 15).until(ExpectedConditions.alertIsPresent());
        Constant.WEBDRIVER.switchTo().alert().accept();
        }

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
    @Test
    public void TC16()
    {
        System.out.println("TC16 - User can cancel a ticket");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        BookTicket bookTicket = homePage.gotoBookTicket();
        bookTicket.bookTicket(Constant.DEPARTDATE,Constant.DEPARTFROM,Constant.ARRIVEAT, Constant.SEATTYPE, Constant.TICKETAMOUNT);

        Myticket myticket = homePage.gotoMyticket();
        myticket.cancelTicket(Constant.DEPARTFROM,Constant.ARRIVEAT);

        new WebDriverWait(Constant.WEBDRIVER, 15).until(ExpectedConditions.alertIsPresent());
        Constant.WEBDRIVER.switchTo().alert().accept();

        FilterTicket filter = new FilterTicket();
        filter.filterTicket(Constant.DEPARTFROM, Constant.ARRIVEAT, Constant.DEPARTDATE,Constant.STATUS);

       String actualMess =  filter.getResultFilter().getText();

       Assert.assertEquals(actualMess,"No result found!", "Don't match");
    }
}

