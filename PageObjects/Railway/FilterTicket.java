package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FilterTicket {
    public WebElement getDepartDate(){
        return Constant.WEBDRIVER.findElement(By.xpath("//select[@name = 'FilterDpStation']"));
    }

    public WebElement getArriveAt(){
        return Constant.WEBDRIVER.findElement(By.xpath("//select[@name = 'FilterArStation']"));
    }

    public WebElement getDepartDateFilter(){
        return Constant.WEBDRIVER.findElement( By.xpath("//input[@name = 'FilterDpDate']"));
    }

    public WebElement getStatus(){
        return Constant.WEBDRIVER.findElement(By.xpath("//select[@name = 'FilterStatus']"));
    }

    public WebElement getApplyFilter(){
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@value= 'Apply filter']"));
    }

    public WebElement getResultFilter(){
        return Constant.WEBDRIVER.findElement(By.xpath("//div//strong//span"));
    }

    public FilterTicket filterTicket(String depart, String arrive, String departDate, String status)
    {
        this.getDepartDate().sendKeys(depart);
        this.getArriveAt().sendKeys(arrive);
        this.getDepartDateFilter().sendKeys(departDate);
        this.getStatus().sendKeys(status);
        this.getApplyFilter().click();

        return new FilterTicket();
    }
}
