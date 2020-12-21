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
    String homePage = "google.com";

    //selectors

    //selector methods

    //constructors
    public Store(WebDriver driver,String homePage) {
        this.homePage = homePage;
        driver.get(homePage);
    }

    //methods
    public void Click(WebDriver driver, By by, String item){
        print(String.format(waitingLog,item,toString()),true);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
        print(String.format(clickedLog,item,toString()),true);
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

