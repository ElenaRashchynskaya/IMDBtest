package imdb.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ImdbMainPage extends CommonPage {

    public static class ImdbTermsAndPrivacy {

        private static SelenideElement termsAndPrivacy() {
            return $("[data-testid='consent-banner']").shouldBe(Condition.visible);
        }

        public static SelenideElement acceptButton = termsAndPrivacy().$("button[data-testid='accept-button']");
    }

    public static class Header {

        private static SelenideElement header() {
            return $("#imdbHeader").shouldBe(Condition.visible);
        }

        public static SelenideElement menu = header().$("#imdbHeader-navDrawerOpen");
    }

    public static class Menu {

        private static SelenideElement menu() {
            return $(".hamburger__drawer .drawer__panelContent").shouldBe(Condition.visible);
        }

        public static SelenideElement menuItem(String text) {
            return menu().$x(".//a[@role='menuitem']/span[contains(text(), '" + text + "')]");
        }
    }
}
