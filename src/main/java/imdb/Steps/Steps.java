package imdb.Steps;

import imdb.Pages.GooglePage;
import imdb.Pages.ImdbBornPage;
import imdb.Pages.ImdbMainPage;
import io.qameta.allure.Allure;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class Steps {

    GooglePage googlePage = new GooglePage();

    public Steps open(PageName pageName){
        googlePage.navigate(pageName.path);
        return this;
    }

    public Steps acceptGoogleCookies(){
        GooglePage.TermsAndPrivacy.acceptAllButton.click();
        return this;
    }

    public Steps googleSearch(String search){
        GooglePage.SearchForm.searchInput().setValue(search).sendKeys(Keys.ENTER);
        return this;
    }

    public Steps selectFirstGoogleResult(String text){
        GooglePage.ResultTable.elementContainsText(text).get(0).click();
        return this;
    }

    public Steps acceptImdbCookies(){
        ImdbMainPage.ImdbTermsAndPrivacy.acceptButton.click();
        return this;
    }

    public Steps openImdbMenu(){
        ImdbMainPage.Header.menu.click();
        return this;
    }

    public Steps selectImdbMenuItem(String menuItem){
        ImdbMainPage.Menu.menuItem(menuItem).click();
        return this;
    }

    public String getActiveFilterText(){
        return ImdbBornPage.Filter.activeFilter.getText();
    }

    public String getTodayDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
        return LocalDate.now().format(formatter);
    }

    public List<String> getCelebrities(){
        return new LinkedList<>(ImdbBornPage.ListOfCelebrities.celebritiesNames.texts());
    }

    public void printOutFirstFiveCelebrities(){
        List<String> firstFiveElements = getCelebrities().subList(0, Math.min(5, getCelebrities().size()));
        Allure.attachment("First Five Celebrities", String.join("\n", firstFiveElements));
    }

    public enum PageName{
        Google("https://www.google.com/");

        public final String path;

        PageName(String path) {
            this.path = path;
        }
    }
}
