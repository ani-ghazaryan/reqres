package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    private WebDriver webDriver;
    private By searchBar = By.cssSelector(".RNNXgb [type=\"text\"]");

    public SearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ResultPage searchByText(String searchText) {
        webDriver.findElement(searchBar).sendKeys(searchText);
        webDriver.findElement(searchBar).sendKeys(Keys.ENTER);
        return new ResultPage(webDriver);
    }

}
