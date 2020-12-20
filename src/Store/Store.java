package Store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.*;

public abstract class Store {

    //values
    String waitingLog = "Waiting for %s to be clickable on the %s page"; //element, toString
    String clickedLog = "Clicked %s on the %s page"; //element, toString

    //abstract values
    String homeURL = "google.com";

    //selectors

    //selector methods

    //constructors
    public Store(WebDriver driver) {
        driver.get(homeURL);
    }

    //methods
    public void Click(WebDriver driver, By by, String item){
        print(String.format(waitingLog,item,toString()),true);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
        print(String.format(clickedLog,item,toString()),true);
    }
    public void waitAndClick(WebDriver driver, By by, String action) {
    //wait for the element to be clickable
    new WebDriverWait(driver, 4)
            .until(ExpectedConditions
                    .elementToBeClickable(by));
    //now click the element
    driver.findElement(by).click();
    System.out.printf("driver clicked the %s%n", action);

    }//end public static void waitAndClick(WebDriver driver, By by, String action)
    private void print(String string, boolean isPrintLine){
        if (isPrintLine){
            System.out.println(string);
        }else {
            System.out.print(string);
        }
    }//end print

    //abstract methods
    String toString(){
        return "Store";
    }
}//end store

