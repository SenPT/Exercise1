package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    protected WebElement getTablLogin(){
        return Constant.WEBDRIVER.findElement(By.xpath("//a[@href = '/Account/Login.cshtml']"));
    }

    protected WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(By.xpath("//a[@href= '/Account/Logout']"));
    }

    protected WebElement getlblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@class='account']/strong"));
    }

    protected WebElement getllblBlankUsernameMsg(){
        return Constant.WEBDRIVER.findElement(By.xpath("//p[@class = 'message error LoginForm']"));
    }

    protected WebElement getMsgPID(){
        return Constant.WEBDRIVER.findElement(By.xpath("//li[@class = 'pid-number']/label[@class = 'validation-error']"));
    }

    protected WebElement getTabRegister(){
        return Constant.WEBDRIVER.findElement(By.xpath("//a[@href= '/Account/Register.cshtml']"));
    }

    protected WebElement getlblregisterMessage(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id = 'content']//p[@class = 'message error']"));
    }

    protected WebElement getTabChangePassword(){
        return Constant.WEBDRIVER.findElement(By.xpath("//a[@href = '/Account/ChangePassword.cshtml']"));
    }

    protected WebElement getlblMesPassRegister(){
        return Constant.WEBDRIVER.findElement(By.xpath("//li[@class = 'password']//label[@class= 'validation-error']"));
    }

    protected  WebElement getTabBookTicket()
    {
        return Constant.WEBDRIVER.findElement(By.xpath("//a[@href='/Page/BookTicketPage.cshtml']"));
    }

    protected WebElement gettabTimeTable()
    {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//a[@href= 'TrainTimeListPage.cshtml']"));
    }

    protected WebElement gettabMyTicket()
    {
        return Constant.WEBDRIVER.findElement(By.xpath("//a[@href = '/Page/ManageTicket.cshtml']"));
    }

    protected WebElement getlblRegisterSucess(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id = 'content']"));
    }

    protected WebElement getFormBookTicket(){
        return Constant.WEBDRIVER.findElement(By.xpath("//form[@method = 'post']"));
    }

    protected WebElement getTabContact(){
        return Constant.WEBDRIVER.findElement(By.xpath("//a[@href='/Page/Contact.cshtml']"));
    }

    protected WebElement getlblHomeHeader(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//h1"));
    }

    protected WebElement getlblTextLogout(){
        return Constant.WEBDRIVER.findElement(By.xpath("//a[@href= '/Account/Logout']//span"));
    }
    //Methods
    public String getRegisterSucess(){
        return this.getlblRegisterSucess().getText();
    }
    public String getWelcomeMessage(){
        return this.getlblWelcomeMessage().getText();
    }
    public String getMessageRegister(){
        return this.getlblregisterMessage().getText();
    }
    public String getMesPassRgister(){
        return this.getlblMesPassRegister().getText();
    }
    public String getTextLogoutTab() {return  this.getlblTextLogout().getText();}

    public String getBlankUserNameMsg(){
        return this.getllblBlankUsernameMsg().getText();
    }
    public String getMsgPid(){
        return this.getMsgPID().getText();
    }
    public String getHomePageHeader(){ return  this.getlblHomeHeader().getText();}

    public BookTicket gotoBookTicket(){
        this.getTabBookTicket().click();
        return new BookTicket();
    }

    public LoginPage gotoLoginPage()
    {
        this.getTablLogin().click();
        return new LoginPage();
    }

    public LoginPage gotoLogoutPage()
    {
        this.getTabLogout().click();
        return new LoginPage();
    }

    public RegisterPage gotoRegister()
    {
        this.getTabRegister().click();
        return new RegisterPage();
    }

    public ChangePassword gotoChangePassword()
    {
        this.getTabChangePassword().click();
        return new ChangePassword();
    }

    public Timetable gotoTimeTable(){
        this.gettabTimeTable().click();
        return new Timetable();
    }

    public Myticket gotoMyticket()
    {
        this.gettabMyTicket().click();
        return new Myticket();
    }
}
