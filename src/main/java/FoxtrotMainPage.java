import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FoxtrotMainPage {
    private WebDriver driver;
    private FoxtrotMainPage foxtrotMainPage;

    public FoxtrotMainPage(WebDriver driver){
        this.driver = driver;
    }

    private By phoneMenu = By.xpath("//li[@data-category='32014']/span[@class='icon dropdown-arrow']");
    private By phoneList = By.xpath("//a[@href=\"/ru/shop/mobilnye_telefony_smartfon.html\"]");
    private By phomeListMenu = By.xpath("//li[@class='catalog__category-item jslink']");

    public FoxtrotMainPage expandPhoneMenu(){
        driver.findElement(phoneMenu).click();
        return this;
    }

    public Boolean checkPhoneMenuDisplayed(){
        Boolean displayed = driver.findElement(phomeListMenu).isDisplayed();
        return displayed;
    }

    public SmartPhonesPage clickSmartPhones(){
        driver.findElement(phoneList).click();
        return new SmartPhonesPage(driver);
    }

}
