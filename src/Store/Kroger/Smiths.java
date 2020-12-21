package Store.Kroger;

import Store.Store;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class Smiths extends Store {
    //values
    private static final String homePage = "https://www.smithsfoodanddrug.com/";

    //selectors
    HashMap<By,String> selectors = new HashMap<>();
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
    public Smiths changeLocation(int zipCode){
        //click the drop down
        this.Click(changeStoreSelector);
        driver.findElement(changeStoreSelector).click();
        //clear the field
        driver.findElement(changeStoreZipEntry).click();
        driver.findElement(changeStoreZipEntry).clear();
        //enter the new zip
        driver.findElement(changeStoreZipEntry).sendKeys(String.valueOf(zipCode));
        return this;
    }

}
