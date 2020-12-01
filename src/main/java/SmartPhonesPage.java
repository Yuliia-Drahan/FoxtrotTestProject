import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SmartPhonesPage {

    private WebDriver driver;

    public SmartPhonesPage(WebDriver driver){
        this.driver = driver;
    }

    private By heading = By.xpath("//div[contains(@class, 'page__title')]/h1");

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }
}
