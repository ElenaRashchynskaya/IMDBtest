package imdb.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GooglePage extends CommonPage {

    public static class TermsAndPrivacy {

        private static SelenideElement termsAndPrivacy() {
            return $("#CXQnmb").shouldBe(Condition.visible);
        }

        public static SelenideElement acceptAllButton = termsAndPrivacy().$("#L2AGLb");
    }

    public static class SearchForm {

        private static SelenideElement searchForm() {
            return $("form[role='search']").shouldBe(Condition.visible);
        }

        public static SelenideElement searchInput() {
            return searchForm().$("textarea");
        }
    }

    public static class ResultTable {

        private static SelenideElement searchTable() {
            return $("#search").shouldBe(Condition.visible);
        }

        public static ElementsCollection elementContainsText(String text) {
            return searchTable().$$x(".//cite[contains(text(), '" + text + "')]");
        }
    }
}
