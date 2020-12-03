import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SmartPhonesPage {

    private WebDriver driver;

    public SmartPhonesPage(WebDriver driver){
        this.driver = driver;
    }

    private By heading = By.xpath("//div[contains(@class, 'page__title')]/h1");
    private By okButton = By.xpath("//input[@class='listing__sidebar-range-submit button']");
    private By samsungCheckBox = By.xpath("//input[@data-property-title='SAMSUNG']");
    private By samsungCheckBoxChecked = By.xpath("//input[@data-property-title='SAMSUNG']/following-sibling::label");
    private String samsungPhone = "//div[@data-product-title='%s']";
    private By basketIcon = By.xpath("//i[@class='header-basket__icon icon-shop js-toggle-tooltip tooltip-link_open']");
    private By basketTooltip = By.xpath("//div[@id='cartTooltip']");
    private By checkOutButton = By.xpath("//a[text()='Оформить заказ']");
    private By basketItems = By.xpath("//div[@class='header-tooltip__cards-item analytics-data main-product ']");

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public SmartPhonesPage chooseSamsungCheckBox(){
        driver.findElement(samsungCheckBox).click();
        return this;
    }

    public Boolean checkCheckBoxIsChecked(){
        Boolean checked = driver.findElement(samsungCheckBoxChecked).isSelected();
        return checked;
    }

    public SmartPhonesPage clickOkButton(){
        driver.findElement(okButton).click();
        return this;
    }

    public SmartPhonesPage clickBuyPhone(String phoneName){
        driver.findElement(By.xpath(String.format(samsungPhone, phoneName)));
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
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='header-tooltip__cards-item analytics-data main-product ']"));
        Integer numberOfItems = elements.size();
        return numberOfItems;

    }

}
