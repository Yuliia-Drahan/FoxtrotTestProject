import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.PriorityQueue;

public class BasketPage {
    private WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }
//    private WebDriverWait wait = (new WebDriverWait(driver,5));

    private By heading = By.xpath("//div[@class='checkout__title-main']/span[text()='Оформление заказа']");
    private String priceOfItem = "//div[@class='checkout-tovar__price-main' and @data-price='%s']";
    private By finalPrice = By.xpath("//li[@class='checkout-results__list-item checkout-results__list-item_lg final-price']");
    private By finalOrderList = By.xpath("//div[@id='js-checkout-result-mobile']");


    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public Integer getIntegerPriceOfPhone(String phonePrice){
        String price = driver.findElement(By.xpath(String.format(priceOfItem,phonePrice))).getText();
        int intPrice = Integer.parseInt(price);
        return intPrice;
    }

    public Integer getFinalPrice(){
//      wait.until(ExpectedConditions.presenceOfElementLocated(finalOrderList));
        String finalNumber = driver.findElement(finalPrice).getText();
        int finalIntPrice = Integer.parseInt(finalNumber);
        return finalIntPrice;
    }
}
