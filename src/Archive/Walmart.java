//package Archive;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.concurrent.TimeUnit;
//
//public class Walmart {
//    public static void main(String[] args) {
//        //define variables
//            //because this program will either run on linux of windows, I don't need to plan for anything unix based.
//        String css = null;
//        String xpath = null;
//        //arraylist dedicated to quick succession of clicks. Arrays within Arraylist are <By selector,String action>
//        ArrayList<Array> selectors = new ArrayList<>();
//
//
//        String storageDirectory =  constants.storageDirectory;
//        String driverFile = constants.driverFile;
//
//        //start driver
//        WebDriver driver = getHeadlessDriverSpecifyDownloadDirectory(driverFile,storageDirectory,null);
//
//        //open walmart.com/grocery, change store to first store in zip code, close onboarding prompt
//        changeWalmartStore(driver,"20001");
//
//        //this is the hamburger icon that opens the department navigation panel
//        WebElement deptNavBtn = driver.findElement(By.cssSelector("#mobileNavigationBtn"));
//
//        deptNavBtn.click();
//
//        //cycle through clicks as commented below
//        selectors.clear(); //cleans out arraylist
//        By.cssSelector("button[aria-label=\"Fruits & Vegetables\"]");
//
//        System.out.printf("driver has finished processing script. user can manipulate browser window%n");
//    }// end public static void main(String[] args)
//
//
//    public static void changeWalmartStore(WebDriver driver, String zipCode) {
//        //define variables
//        String url = "https://www.walmart.com/grocery";
//
//        driver.get(url);
//
//        closeWalmartOnboardingPrompt(driver);
//
//        //click "change[store]"
//        driver.findElement(By.cssSelector(".button-link")).click();
//
//        //enter zip code
//        String xPath = "/html/body/div[1]/div[2]/div[1]/section[2]/div/div[1]/div/div[1]/div/form/div/input";
//        driver.findElement(By.xpath(xPath)).clear();
//        driver.findElement(By.xpath(xPath)).sendKeys(zipCode);
//
//        //cycle through clicks as commented below
//
//        selectList.addAll(Arrays.asList(
//                //click search
//                Array
//                        .cssSelector(".LocationFlyout__searchBtn___2m4qm"),
//                //click first radio button
//                By.cssSelector("Label.RadioTile__tileContent___1bBd4"),
//                //select "continue" button
//                By.cssSelector(".LocationFlyout__footer___2d62o"),
//                //click the "I really wanna continue" button
//                By.cssSelector(".LocationFlyout__flyoutContainer___GSXOF > button:nth-child(2)"
//                )));//end selectors.addAll()
//
//        closeWalmartOnboardingPrompt(driver);
//
//    }
//
////    public void clickDeptBurger(Webdriver driver){
////
////    }
//}//end public class Walmart
