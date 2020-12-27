package Store.Rosie.Dicksmarket;

import Store.Rosie.Rosie;
import Store.Rosie.RosieDepartments;
import Store.Selector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DicksMarket extends Rosie {

    private static final String homePage = "http://rosieapp.com/shopstore/dicksmarketcenterville";


    //selectors

    //selector sub strings


    public DicksMarket(WebDriver driver) {
        super(driver);
        driver.get(homePage);
    }


    //methods

    @Override
    public String toString() {
        return "Dick's Market Home";
    }
}
