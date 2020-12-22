package Store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Store {

    //values
    String waitingLog = "Waiting for the %s to be clickable on the %s page"; //element, toString
    String clickedLog = "Clicked the %s on the %s page"; //element, toString
    public WebDriver driver;
    List<Selector> selectors;

    //abstract values
    String homePage = "google.com";

    //selectors

    //selector methods

    //constructors
    public Store(WebDriver driver,String homePage) {
        this.homePage = homePage;
        this.driver = driver;
        driver.get(homePage);
        selectors = new ArrayList<Selector>();
    }

    //methods
    public void Click(Selector selector){
        print(String.format(waitingLog,selector.getName(),toString()),true);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(selector.getName())));
        driver.findElement(selector.getBy()).click();
        print(String.format(clickedLog,selector.getName(),toString()),true);
    }

    private void print(String string, boolean isPrintLine){
        if (isPrintLine){
            System.out.println(string);
        }else {
            System.out.print(string);
        }
    }//end print

    //abstract methods
    public String toString(){
        return "Store";
    }


//    public abstract void setHomePage(String homePage){
//        this.homePage = homePage;
//    }
}//end store

