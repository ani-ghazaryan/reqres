package pages;

import org.asynchttpclient.webdav.WebDavResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ResultPage {

    private WebDriver webDriver;
    private By searchResultsOnBar = By.cssSelector("#appbar #result-stats");
    private By searchResultsByUrls = By.cssSelector(".MjjYud a[href^=\"https://\"] [role=\"text\"]");

    public ResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public int getResultsCount() {
        String text = webDriver.findElement(searchResultsOnBar).getText();
        int i = text.indexOf('(');
        String finalText = text.substring(0, i - 1).replaceAll(" ", "").replaceAll("[^0-9]", "");
        return Integer.parseInt(finalText);
    }

    public boolean checkGivenLinkIsInResults(String neededText){
        List<WebElement> elements = webDriver.findElements(searchResultsByUrls);

        for (WebElement webElement : elements) {
            if (webElement.getText().contains(neededText)) {
                return true;
            }
        }
        return false;
    }

}
