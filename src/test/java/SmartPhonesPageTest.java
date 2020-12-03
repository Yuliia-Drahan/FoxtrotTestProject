import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SmartPhonesPageTest {
    private WebDriver driver;
    private SmartPhonesPage smartPhonesPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\IdeaProjects\\FoxtrotTestProject\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.foxtrot.com.ua/ru/shop/mobilnye_telefony_smartfon.html");
        smartPhonesPage = new SmartPhonesPage(driver);
    }

    @Test
    public void checkChockBox(){
        smartPhonesPage.chooseSamsungCheckBox();
        Boolean result = smartPhonesPage.checkCheckBoxIsChecked();
        Assert.assertTrue(result);
    }

    @Test
    public void addItemsToBasket(){
        smartPhonesPage.chooseSamsungCheckBox();
        smartPhonesPage.clickOkButton();
        smartPhonesPage.clickBuyPhone("Смартфон SAMSUNG Galaxy A51 4/64 Gb Dual Sim Black (SM-A515FZKUSEK)");
        smartPhonesPage.clickBuyPhone("Смартфон SAMSUNG Galaxy S10 8/128Gb Duos Black (SM-G973FZKDSEK)");
        smartPhonesPage.clickBuyPhone("Смартфон SAMSUNG Galaxy S20 8/128Gb Cosmic Gray (SM-G980FZADSEK)");
        smartPhonesPage.clickBasketIcon();
        Integer result = smartPhonesPage.checkItemsInBasket();
        Assert.assertEquals(Integer.valueOf(3), result);
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
