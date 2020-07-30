package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BookTicket extends GeneralPage {

    public WebElement getDepartDate() {
        return Constant.WEBDRIVER.findElement(By.xpath("//select[@name = 'Date']"));
    }

    public WebElement getDepartFrom() {
        return Constant.WEBDRIVER.findElement(By.xpath("//select[@name = 'DepartStation']"));
    }

    public WebElement getArriveAt() {
        return Constant.WEBDRIVER.findElement(By.xpath("//select[@name = 'ArriveStation']"));
    }

    public WebElement getSeatType() {
        return Constant.WEBDRIVER.findElement(By.xpath("//select[@name = 'SeatType']"));
    }

    public WebElement getTicketAmount() {
        return Constant.WEBDRIVER.findElement(By.xpath("//select[@name = 'TicketAmount']"));
    }

    public WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@value = 'Book ticket']"));
    }

    public WebElement getlblMesBookTicket() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id = 'content']/h1"));
    }

    public String getMesBookTicket() {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'content']/h1")));
        return this.getlblMesBookTicket().getText();
    }

    public BookTicket bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {

        JavascriptExecutor jse = (JavascriptExecutor) Constant.WEBDRIVER;
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");

        this.getDepartDate().sendKeys(departDate);
        this.getDepartFrom().sendKeys(departFrom);
        this.getArriveAt().sendKeys(arriveAt);
        this.getSeatType().sendKeys(seatType);
        this.getTicketAmount().sendKeys(ticketAmount);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.getBtnBookTicket().click();

        return new BookTicket();
    }

    public void verifyBookTicket(String departFrom, String arrivAt, String seatType, String departDate, String bookDate, String expiredDate, String ticketAmount, String price) {
        List<WebElement> TRCollection = Constant.WEBDRIVER.findElements(By.xpath("//table[@class = 'MyTable WideTable']//tr[@class='OddRow']//td"));
        //add expected result to list
        List<String> expectedResult = new ArrayList<String>() {
            {
                add(departFrom);
                add(arrivAt);
                add(seatType);
                add(departDate);
                add(bookDate);
                add(expiredDate);
                add(ticketAmount);
                add(price);
            }
        };

        //Compare expected result and actual result
        for (int i = 0; i < expectedResult.size(); i++) {
            String actualResult = TRCollection.get(i).getText();
                if (actualResult.equals(expectedResult.get(i))) {
                    Assert.assertEquals("1","1");
                } else {
                    Assert.assertEquals("1","2");
                }
        }
    }
}
