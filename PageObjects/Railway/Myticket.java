package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Myticket extends GeneralPage{

    public void cancelTicket(String departFrom, String arriveAt){
        Constant.WEBDRIVER.findElement(By.xpath("//td[text()='"+ departFrom +"']//following-sibling::td[text()='"+ arriveAt + "']//following-sibling::td//input")).click();
    }
}
