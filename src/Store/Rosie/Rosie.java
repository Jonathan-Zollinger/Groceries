package Store.Rosie;

import Store.Store;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Store.Selector;

public class Rosie extends Store {

    //selectors
    Selector shopAsGuest = new Selector("'Shop-as-guest' button", By.xpath("//*[text()='Shop as guest']"));

    public Rosie(WebDriver driver, String homePage) {
        super(driver, homePage);
    }

    @Override
    public String toString() {
        return "Rosie";
    }


}
