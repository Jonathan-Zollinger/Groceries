package Store.Rosie;

import Store.Store;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Store.Selector;
import java.util.logging.Logger;



public class Rosie extends Store{

    WebDriver driver;

    //constructors
    public Rosie(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //values
    Logger logger = Logger.getLogger(Rosie.class.getName());
    private static final String homePage = "http://rosieapp.com/shopstore/dicksmarketcenterville";

    //selector sub strings
    String header = "//rosie-header";

    //selectors
    protected Selector shopAsGuest = new Selector("'Shop-as-guest' button",
            By.xpath("//*[text()='Shop as guest']"));
    protected Selector welcomeOK = new Selector("Welcome to Rosie 'OK' button",
            By.xpath("//*[text()='Ok']"));
    protected Selector shopDepartmentsDropdown = new Selector("'Shop departments' dropdown",
            By.xpath(String.format("%s//*[text() = 'Shop departments']",header)));

    //selector methods
    private Selector getDepartmentSelector(RosieDepartments department){
        return new Selector(String.format("%s Department from 'Shop departments' dropdown",department),
                By.xpath(String.format("%s//*[text()='%s']",header,department)));
    }

    //methods
    public Rosie clickWelcomeOK(){
        click(welcomeOK);
        return this;
    }
    public Rosie clickDepartmentsDropdown(){
        click(shopDepartmentsDropdown);
        return this;
    }
    public RosieGF clickGFDeptFromDropdown(){
        click(getDepartmentSelector(RosieDepartments.GlutenFree));
        return new RosieGF(driver);
    }


    @Override
    public String toString() {
        return String.valueOf(this.getClass());
    }


}

