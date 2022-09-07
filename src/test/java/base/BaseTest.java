package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.SearchPage;

public class BaseTest {

    private WebDriver webDriver;
    protected SearchPage searchPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com");
        searchPage = new SearchPage(webDriver);
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }

}
