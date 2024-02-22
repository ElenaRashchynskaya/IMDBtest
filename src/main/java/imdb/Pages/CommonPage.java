package imdb.Pages;
import static com.codeborne.selenide.Selenide.open;

public abstract class CommonPage {

    public void navigate(String pageName){
        open(pageName);
    }
}
