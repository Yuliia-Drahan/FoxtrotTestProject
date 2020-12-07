import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.font.TrueTypeFont;;import java.util.concurrent.TimeUnit;

public class BasketPageTest {
    private WebDriver driver;
    private BasketPage basketPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\FoxtrotTestProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        SmartPhonesPage smartPhonesPage = new SmartPhonesPage(driver);
        driver.get("https://www.foxtrot.com.ua/ru/shop/mobilnye_telefony_smartfon.html");
        smartPhonesPage.clickBuyPhone("Смартфон SAMSUNG Galaxy A51 4/64 Gb Dual Sim Black (SM-A515FZKUSEK)");
        smartPhonesPage.clickBuyPhone("Смартфон APPLE iPhone 11 64GB Black (MWLT2RM/A)");
        smartPhonesPage.clickBuyPhone("Смартфон XIAOMI Redmi Note 9 4/128 Gb Dual Sim Forest Green");
        driver.get("https://www.foxtrot.com.ua/ru/cart/checkout");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='js-checkout-result-mobile']")));
        basketPage = new BasketPage(driver);
    }

    @Test
    public void getHeading() {
        String heading = basketPage.getHeadingText();
        Assert.assertEquals("Оформление заказа", heading);
    }

    @Test
    public void comparePrices() {
        Integer priceSamsung = basketPage.getIntegerPriceOfPhone("7599");
        Integer priceIphone = basketPage.getIntegerPriceOfPhone("22999");
        Integer priceXiomi = basketPage.getIntegerPriceOfPhone("5499");
        Integer finalPrice = basketPage.getFinalPrice();
        Integer sum = priceIphone + priceSamsung + priceXiomi;
        Assert.assertTrue(sum == finalPrice);


    }

}

