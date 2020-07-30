package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ChangePassword extends GeneralPage{

    public WebElement gettxtCurrentPassword(){
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@id= 'currentPassword']"));
    }

    public WebElement gettxtNewPassWord(){
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@id= 'newPassword']"));
    }

    public WebElement gettxtConfirmNewPass(){
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@id= 'confirmPassword']"));
    }

    public WebElement getbtnChangePass(){
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@value= 'Change Password']"));
    }

    public ChangePassword changePassword(String currentPass, String newPass, String confirmNewPass)
    {
        this.gettxtCurrentPassword().sendKeys(currentPass);
        this.gettxtNewPassWord().sendKeys(newPass);
        this.gettxtConfirmNewPass().sendKeys(confirmNewPass);

        JavascriptExecutor jse = (JavascriptExecutor) Constant.WEBDRIVER;
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");

        this.getbtnChangePass().click();

        return new ChangePassword();
    }
}
