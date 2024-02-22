package imdb.Tests;

import com.codeborne.selenide.Selenide;
import imdb.Steps.Steps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BornTodayTest {
    @Test(groups = "smoke")
    public void Assert_at_least_5_celebrities_have_a_birsday_today() {
        Steps s = new Steps();
        s.open(Steps.PageName.Google)
                .acceptGoogleCookies()
                .googleSearch("imdb")
                .selectFirstGoogleResult("www.imdb.com")
                .acceptImdbCookies()
                .openImdbMenu()
                .selectImdbMenuItem("Born Today")
                .printOutFirstFiveCelebrities();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(s.getActiveFilterText().contains(s.getTodayDate()), "Filter isn't contains today date");
        sa.assertTrue(s.getCelebrities().size()>4, "Should be at least 5 celebrities");
        sa.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}

