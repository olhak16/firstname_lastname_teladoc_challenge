package teladoc.pages;


import org.jsoup.Connection;
import org.openqa.selenium.support.PageFactory;
import teladoc.utils.Driver;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
