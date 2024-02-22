package imdb.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ImdbBornPage extends CommonPage{

    public static class Filter {

        private static SelenideElement filter() {
            return $(".ipc-chip-list__scroller").shouldBe(Condition.visible);
        }

        public static SelenideElement activeFilter = filter().$("button>span");
    }

    public static class ListOfCelebrities {

        private static SelenideElement listOfCelebrities() {
            return $("ul.ipc-metadata-list").shouldBe(Condition.visible);
        }

        public static ElementsCollection celebritiesNames = listOfCelebrities().$$("h3.ipc-title__text");
    }
}
