package Store.Kroger;

import Store.Store;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Smiths extends Store {
    //values
    private static final String homePage = "https://www.smithsfoodanddrug.com/";

    //selector Strings
    private static final By changeStoreSelector =
            By.xpath("//div[@id='root']//button[@data-testid='CurrentModality-button']");
    private static final By changeStoreZipEntry =
            By.xpath("//div[@id='root']//input[@autocomplete='postal-code']");
    private static final By changeStoreSearchSelector =
            By.xpath("//div[@id='root']//div[@aria-label='How do you want to shop today?'");
    //selector methods


    //constructors
    public Smiths(WebDriver driver){
        super(driver, homePage);
    }

    //methods


}
