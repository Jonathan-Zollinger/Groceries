package Store.Rosie;

import Store.Store;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Store.Selector;

import java.util.logging.Logger;

public class Rosie extends Store {

    Logger logger = Logger.getLogger(Rosie.class.getName());
    private static final String homePage = "http://rosieapp.com/shopstore/dicksmarketcenterville";


    //selectors
    Selector shopAsGuest = new Selector("'Shop-as-guest' button", By.xpath("//*[text()='Shop as guest']"));
    Selector welcomeOK = new Selector("Welcome to Rosie 'OK' button",
            By.xpath("//*[text()='Ok']"));
    Selector shopDepartmentsDropdown = new Selector("'Shop departments' dropdown",
            By.xpath("//*[text() = 'Shop departments']"));

    public Rosie(WebDriver driver) {
        super(driver);
    }

    @Override
    public String toString() {
        return "Rosie";
    }


}
