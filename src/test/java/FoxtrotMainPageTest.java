import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class FoxtrotMainPageTest {

    private WebDriver driver;
    private FoxtrotMainPage foxtrotMainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\IdeaProjects\\FoxtrotTestProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.foxtrot.com.ua/");
        foxtrotMainPage = new FoxtrotMainPage(driver);
    }

    @Test
    public void openMenuBarTest(){
      foxtrotMainPage.expandPhoneMenu();
        Boolean result = foxtrotMainPage.checkPhoneMenuDisplayed();
       Assert.assertTrue(result);
    }

    @Test
    public void openListOfSmartPhones(){
        foxtrotMainPage.expandPhoneMenu();
        SmartPhonesPage smartPhonesPage = foxtrotMainPage.clickSmartPhones();
        String heading = smartPhonesPage.getHeadingText();
        Assert.assertEquals("Смартфоны", heading);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
