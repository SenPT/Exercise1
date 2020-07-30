package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{

    public WebElement getTxtUserName()
    {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='username']"));
    }

    public WebElement getTxtPassword()
    {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='password']"));
    }

    public WebElement getBtnLogin() { return Constant.WEBDRIVER.findElement(By.xpath("//input[@value='Login']")); }

    public WebElement getlblLoginErrorMsg()
    {
        return Constant.WEBDRIVER.findElement(By.xpath("//p[@class = 'message error LoginForm']"));
    }

    public WebElement getlblHeaderLoginPage()
    {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']/h1"));
    }

    public HomePage login(String username, String password)
    {
        this.getTxtUserName().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();

        return new HomePage();
    }
}
