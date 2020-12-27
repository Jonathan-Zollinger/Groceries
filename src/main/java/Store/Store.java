package Store;

import org.apache.logging.log4j.Logger;
import org.apache.logging.slf4j.SLF4JLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.*;
import org.apache.logging.log4j.LogManager;
import org.seleniumhq.jetty9.util.log.Log;


public abstract class Store{

    //logs
                                //element, toString
    String waitingLog       = "Waiting for the %s to be clickable on the %s page";
                                //timeWaited, element, toString
    String clickedLog       = "after %1.3f seconds, clicked the %s on the %s page";
                                //timeWaited, element, toString
    String clearedFieldLog  = "after %1.3f seconds, cleared the %s field on the %s page";
                                //timeWaited, String sent, element, toString
    String sentKeysLog      = "after %1.3 seconds, sent the keys '%s' to the %s field on the %s page";
    //general variables
    WebDriver driver;
    WebDriverWait wait;
    //Logger log = LogManager.getLogger(String.format("%s class",this.getClass().getName()));

    //abstract values
    String homePage = "google.com";

    //selectors

    //selector methods

    //constructors
    public Store(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
//        log = new Logger.getLogger()
    }

    //methods
    public void click(Selector selector){
        Date date = new Date();
        long start = date.getTime();
        //log planned click
        System.out.println(String.format(waitingLog,selector.getName(),toString()));
        //wait for element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(selector.getBy()));
        //click the dang thing
        driver.findElement(selector.getBy()).click();
        //log click
        double waitTime = date.getTime() - start;
        System.out.println(String.format(clickedLog,waitTime,selector.getName(),toString()));
    }//end click method

    public void sendKeys(Selector selector,String stringToSend){
        Date date = new Date();
        long start = date.getTime();
        //log planned click
        System.out.println(String.format(waitingLog,selector.getName(),toString()));
        //wait for element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(selector.getBy()));
        //clear the field
        driver.findElement(selector.getBy()).sendKeys(stringToSend);
        //log click
        double waitTime = date.getTime() - start;
        System.out.println(String.format(sentKeysLog,waitTime,stringToSend,selector.getName(),toString()));
    }

    public void clearField(Selector selector){
        Date date = new Date();
        long start = date.getTime();
        //log planned click
        System.out.println(String.format(waitingLog,selector.getName(),toString()));
        //wait for element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(selector.getBy()));
        //clear the field
        driver.findElement(selector.getBy()).clear();
        //log click
        double waitTime = date.getTime() - start;
        System.out.println(String.format(clearedFieldLog,waitTime,selector.getName(),toString()));

    }//end clearField method


    //abstract methods
    public abstract String toString();

}//end store class

