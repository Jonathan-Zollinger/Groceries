package Store.Rosie.Dicksmarket;

import Store.Rosie.Rosie;
import Store.Selector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DicksMarket extends Rosie {

    private static final String homePage = "http://rosieapp.com/shopstore/dicksmarketcenterville";


    //selectors

    //selector sub strings
    String header = "//rosie-header";

    public DicksMarket(WebDriver driver) {
        super(driver);
        driver.get(homePage);
    }


    //methods
    public DicksMarket clickDepartmentsDropdown(){
        return this;
    }
}
