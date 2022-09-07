package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ResultPage;

import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest {

    @Test
    public void testSuccessfulSearch() {
        String searchText = "купить кофемашину bork c804";
        String resultText = "mvideo.ru";

        ResultPage resultPage = searchPage.searchByText(searchText);
        int resultsCount = resultPage.getResultsCount();
        assertTrue(resultsCount > 10, "There are not enough results");

        boolean resultExists = resultPage.checkGivenLinkIsInResults(resultText);
        assertTrue(resultExists, "mvideo.ru is missing from search results");
    }

}
