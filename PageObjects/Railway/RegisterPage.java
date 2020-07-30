package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage{

    public WebElement getEmail(){
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@id= 'email']"));
    }

    public WebElement getPassword(){
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@id= 'password']"));
    }

    public WebElement getConfirmPassword(){
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@id= 'confirmPassword']"));
    }

    public WebElement getPID(){
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@id= 'pid']"));
    }

    public WebElement getbtnRegister(){
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@value= 'Register']"));
    }

    public RegisterPage registerPage(String email, String password, String confirmPass, String pID){
        this.getEmail().sendKeys(email);
        this.getPassword().sendKeys(password);
        this.getConfirmPassword().sendKeys(confirmPass);
        this.getPID().sendKeys(pID);

        JavascriptExecutor jse = (JavascriptExecutor) Constant.WEBDRIVER;
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");

        this.getbtnRegister().click();

        return new RegisterPage();
    }
}

