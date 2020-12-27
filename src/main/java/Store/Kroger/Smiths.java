package Store.Kroger;

import Store.Store;
import Store.Selector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Smiths extends Store {
    //values
    private static final String homePage = "https://www.smithsfoodanddrug.com/";



    //selectors
    Selector changeStore = new Selector(
            "Change Store Button",By.xpath("//div[@id='root']//button[@data-testid='CurrentModality-button']"));
    Selector storeZipEntry = new Selector(
            "Zip Code Entry Field", By.xpath("//input[@autocomplete='postal-code']"));
    Selector zipSearchButton = new Selector(
            "Zip Code Search Button", By.xpath(
                    "//*[class='kds-Button kds-Button--primaryInverse kds-Button--compact kds-Button--hasIconOnly kds-SolitarySearch-button']"));

    //*[@id="root"]/div/div[3]/div[5]/div/div/form/div[1]/div[2]/label/div/button

//        smithsSelectors.put("change Store Search Selector",
//                By.xpath("//div[@id='root']//div[@aria-label='How do you want to shop today?'"));
//    }

    //selector methods


    //constructors
    public Smiths(WebDriver driver){
        super(driver);
    }


    //methods
    public Smiths changeLocation(int zipCode){
        //click the drop down
        this.click(changeStore);
        //clear the field
        this.click(storeZipEntry);
        this.clearField(storeZipEntry);
        //enter the new zip
        this.sendKeys(storeZipEntry,String.valueOf(zipCode));
        return this;
    }

    @Override
    public String toString() {
        return "Smiths";
    }
}
