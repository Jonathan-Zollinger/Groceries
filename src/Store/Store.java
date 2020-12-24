package Store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.*;


public abstract class Store {

    //logs
    String waitingLog       = "Waiting for the %s to be clickable on the %s page"; //element, toString
    String clickedLog       = "Clicked the %s on the %s page"; //element, toString
    String clearedFieldLog  = "Cleared the %s field on the %s page";//element, toString
    String sentKeysLog      = "Sent keys '%s' to the %s field on the %s page"; //String sent, element, toString
    //general variables
    public WebDriver driver;
    WebDriverWait wait;
    Logger log;

    //abstract values
    String homePage = "google.com";

    //selectors

    //selector methods

    //constructors
    public Store(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        log = new Logger.getLogger()
    }

    //methods
    public void click(Selector selector){
        //log planned click
        System.out.println(String.format(waitingLog,selector.getName(),toString()));
        //wait for element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(selector.getBy()));
        //click the dang thing
        driver.findElement(selector.getBy()).click();
        //log click
        System.out.println(String.format(clickedLog,selector.getName(),toString()));
    }//end click method

    public void sendKeys(Selector selector,String stringToSend){
        //log planned click
        System.out.println(String.format(waitingLog,selector.getName(),toString()));
        //wait for element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(selector.getBy()));
        //clear the field
        driver.findElement(selector.getBy()).sendKeys(stringToSend);
        //log click
        System.out.println(String.format(sentKeysLog,stringToSend,selector.getName(),toString()));
    }

    public void clearField(Selector selector){
        //log planned click
        System.out.println(String.format(waitingLog,selector.getName(),toString()));
        //wait for element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(selector.getBy()));
        //clear the field
        driver.findElement(selector.getBy()).clear();
        //log click
        System.out.println(String.format(clearedFieldLog,selector.getName(),toString()));
    }//end clearField method


    //abstract methods
    public abstract String toString();

}//end store class

