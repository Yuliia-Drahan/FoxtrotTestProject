import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartPhonesPage {

    private WebDriver driver;

    public SmartPhonesPage(WebDriver driver){
        this.driver = driver;
    }

    private By heading = By.xpath("//div[contains(@class, 'page__title')]/h1");
    private String phone = "//div[@data-product-title='%s']";
    private By basketIcon = By.xpath("//div[@class='header-basket']");
    private By basketTooltip = By.xpath("//div[@id='cartTooltip']");
    private By checkOutButton = By.xpath("//a[text()='Оформить заказ']");
    private By basketItems = By.xpath("//div[@class='header-tooltip__cards-item__body']");
    private By closeBasket = By.xpath("//i[@id='cartTooltipClose']");
    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public SmartPhonesPage clickBuyPhone(String phoneName){
        driver.findElement(By.xpath(String.format(phone, phoneName))).click();
//        driver.findElement(closeBasket).click();
        return this;
    }

    public SmartPhonesPage clickBasketIcon(){
        driver.findElement(basketIcon).click();
        return this;
    }

    public BasketPage clickCheckOutButton(){
        driver.findElement(checkOutButton).click();
        return new BasketPage(driver);
    }

    public Boolean checkBTooltipIsHere(){
        Boolean displayed = driver.findElement(basketTooltip).isDisplayed();
        return displayed;
    }

    public Integer checkItemsInBasket(){
        List<WebElement> elements = driver.findElements(basketItems);
        Integer numberOfItems = elements.size();
        return numberOfItems;
    }

}
