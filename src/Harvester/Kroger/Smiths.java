package Harvester.Kroger;

import Harvester.Store;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Smiths extends Store {

    //fields
    private static final String homeURL = "https://www.smithsfoodanddrug.com/";
    private static final By changeStoreSelector =
            By.xpath("//div[@id='root']//button[@data-testid='CurrentModality-button']");
    private static final By changeStoreZipEntry =
            By.xpath("//div[@id='root']//input[@autocomplete='postal-code']");
    private static final By changeStoreSearchSelector =
            By.xpath("//div[@id='root']//div[@aria-label='How do you want to shop today?'");

    @Override
    public void setHomeURL(String homeURL) {
        super.setHomeURL(homeURL);
    }
    public void setHomeURL() {
        super.setHomeURL(homeURL);
    }

    //constructors
    public Smiths(){

    }

    //methods
    private Smiths ChangeLocation(WebDriver driver,String zipCode){
        //click the drop down
        driver.findElement(changeStoreSelector).click();
        //clear the field
        driver.findElement(changeStoreZipEntry).click();
        driver.findElement(changeStoreZipEntry).clear();
        //enter the new zip
        driver.findElement(changeStoreZipEntry).sendKeys(zipCode);
        return this;
    }

}
