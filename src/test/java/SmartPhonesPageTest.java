import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SmartPhonesPageTest {
    private WebDriver driver;
    private SmartPhonesPage smartPhonesPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\IdeaProjects\\FoxtrotTestProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.foxtrot.com.ua/ru/shop/mobilnye_telefony_smartfon.html");
        smartPhonesPage = new SmartPhonesPage(driver);
    }

//    WebDriverWait wait = (new WebDriverWait(driver,5));
//    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));


    @Test
    public void addItemsToBasket() {
        smartPhonesPage.clickBuyPhone("Смартфон SAMSUNG Galaxy A51 4/64 Gb Dual Sim Black (SM-A515FZKUSEK)");
        smartPhonesPage.clickBuyPhone("Смартфон APPLE iPhone 11 64GB Black (MWLT2RM/A)");
        smartPhonesPage.clickBuyPhone("Смартфон XIAOMI Redmi Note 9 4/128 Gb Dual Sim Forest Green");
        smartPhonesPage.clickBasketIcon();
        Integer result = smartPhonesPage.checkItemsInBasket();
        Assert.assertTrue(result == 3);
    }

    @Test
    public void goToCheckOut(){
        smartPhonesPage.clickBuyPhone("Смартфон SAMSUNG Galaxy A51 4/64 Gb Dual Sim Black (SM-A515FZKUSEK)");
        smartPhonesPage.clickBuyPhone("Смартфон APPLE iPhone 11 64GB Black (MWLT2RM/A)");
        smartPhonesPage.clickBuyPhone("Смартфон XIAOMI Redmi Note 9 4/128 Gb Dual Sim Forest Green");
        smartPhonesPage.clickBasketIcon();
        BasketPage basketPage = smartPhonesPage.clickCheckOutButton();
        String heading = basketPage.getHeadingText();
        Assert.assertEquals("Оформление заказа", heading);
    }

    @After
    public void tearDown(){
       driver.quit();
    }


}
