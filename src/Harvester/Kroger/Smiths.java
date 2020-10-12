package Harvester.Kroger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Smiths {

    //fields
    private String homeURL = "https://www.smithsfoodanddrug.com/";
    private By changeStoreSelector = By.xpath("//div[@id='root']//button[@data-testid='CurrentModality-button']");
    private By changeStoreZipEntry = By.xpath("//div[@id='root']//input[@autocomplete='postal-code']");
    private By changeStoreSearchSelector = By.xpath("//div[@id='root']//div[@aria-label='How do you want to shop today?'");

    //constructors
    public Smiths(){


    }

    //methods
    private void ChangeLocation(WebDriver driver,String zipCode){
        //click the drop down
        driver.findElement(changeStoreSelector).click();
        //clear the field
        driver.findElement(changeStoreZipEntry).click();
        driver.findElement(changeStoreZipEntry).clear();
        //enter the new zip
        driver.findElement(changeStoreZipEntry).sendKeys(zipCode);
    }

}
