import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {
    private WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//div[@class='checkout__title-main']/span[text()='Оформление заказа']");


    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }
}
