package Archive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Walmart {
    public static void main(String[] args) {
        //define variables
            //because this program will either run on linux of windows, I don't need to plan for anything unix based.
        String css = null;
        String xpath = null;
        //arraylist dedicated to quick succession of clicks. Arrays within Arraylist are <By selector,String action>
        ArrayList<Array> selectors = new ArrayList<>();


        String storageDirectory =  constants.storageDirectory;
        String driverFile = constants.driverFile;

        //start driver
        WebDriver driver = getHeadlessDriverSpecifyDownloadDirectory(driverFile,storageDirectory,null);

        //open walmart.com/grocery, change store to first store in zip code, close onboarding prompt
        changeWalmartStore(driver,"20001");

        //this is the hamburger icon that opens the department navigation panel
        WebElement deptNavBtn = driver.findElement(By.cssSelector("#mobileNavigationBtn"));

        deptNavBtn.click();

        //cycle through clicks as commented below
        selectors.clear(); //cleans out arraylist
        By.cssSelector("button[aria-label=\"Fruits & Vegetables\"]");

        System.out.printf("driver has finished processing script. user can manipulate browser window%n");
    }// end public static void main(String[] args)

    public static WebDriver getHeadlessDriverSpecifyDownloadDirectory(
            String driverPath, String downloadFilepath,String mimeType) {

        if (mimeType == null){
            mimeType = "application/x-gzip";
        }
        System.setProperty("webdriver.gecko.driver", driverPath);
        FirefoxProfile profile = new FirefoxProfile();

        //set Firefox profile preferences
            /* it seems like you could get away without changing the browser.download.folderList preference to "2", but
            without it we can't change the browser.download.dir preference. */
        profile.setPreference("browser.download.folderList", 2);//uses last download directory as destination directory
        profile.setPreference("browser.download.dir",downloadFilepath); //if path = invalid, goes to downloads folder

        /* the second argument in these preferences is what's called a "mimetype" of a filetype.
        I find the easiest way to figure the proper mimetype for your use is to follow Florent B's suggestion
        and look at the network panel under the developer tools under a manual run through. https://bit.ly/2FEYB0p */
        profile.setPreference("browser.helperApps.neverAsk.openFile",mimeType);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",mimeType);

        //set Firefox options
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false); //run headless version of firefox

        //include profile in options
        options.setProfile(profile); //include all the profile settings in this option set

        //initiate new instance of firefox
        return new FirefoxDriver(options); //call the driver w/ our specified options (and profile).

    }//end public static WebDriver getHeadlessDriverSpecifyDownloadDirectory(String downloadFilepath, String mimeType)

    public static void closeWalmartOnboardingPrompt(WebDriver driver){
        //define the selection
        final By onboardBtn = By.className("OnboardingModal__closeBtn___2xhJM");

        waitAndClick(driver, onboardBtn, "onboarding button");

    }//end public static void closeWalmartOnboardingPrompt(WebDriver driver)

    public static void waitAndClick(WebDriver driver, By clicker, String actionName){
        try {
            //wait for the element to be clickable
            new WebDriverWait(driver, 4)
                    .until(ExpectedConditions
                            .elementToBeClickable(clicker));
            //now click the element
            driver.findElement(clicker).click();
            System.out.printf("driver clicked the %s%n",actionName);
        }catch (Exception e){
            System.out.printf("driver failed to click the %s%n",actionName);
        }//end try/catch for WebDriverWait->clicker to be clickable
    }//end public static void waitAndClick(WebDriver driver, By clicker, String actionName)

    public static void clickThroughLinkText(WebDriver driver, ArrayList<String> selectors){
        for(int i = 0; i < selectors.size(); i++){
            /*because the webpage may respond slower than our program, loop through a
                couple times if the driver action fails */
            int count = 2;
            while(count > 0) {
                try {
                    driver.findElement(
                            By.linkText(selectors.get(i)))
                            .click();
                    System.out.printf("driver clicked \"%s\"%n",selectors.get(i));
                    break;
                } catch (Exception e) {
                    System.out.printf("driver failed to click selector \"%s\", " +
                            "will try %dx more%n",selectors.get(i),count-1);
                    count --;
                    //wait 1/2 second till looping through
                    try{TimeUnit.MILLISECONDS.sleep(500);}catch (Exception d){System.out.print("sleep failed");}
                }//end catch (Exception e)
            }//end int count = 5; while(count > 0)
        }//end for(int i = 0; i < selectors.size(); i++)
    }//end public static void clickThroughCssArrayList(WebDriver driver, ArrayList<String> list)

    public static void clickThroughByList(WebDriver driver, ArrayList<Array> selectors){
        for(int i = 0; i < selectors.size(); i++){

        }//end for(int i = 0; i < selectors.size(); i++)
    }//end public static void clickThroughCssArrayList(WebDriver driver, ArrayList<String> list)

    public static void changeWalmartStore(WebDriver driver, String zipCode) {
        //define variables
        String url = "https://www.walmart.com/grocery";

        driver.get(url);

        closeWalmartOnboardingPrompt(driver);

        //click "change[store]"
        driver.findElement(By.cssSelector(".button-link")).click();

        //enter zip code
        String xPath = "/html/body/div[1]/div[2]/div[1]/section[2]/div/div[1]/div/div[1]/div/form/div/input";
        driver.findElement(By.xpath(xPath)).clear();
        driver.findElement(By.xpath(xPath)).sendKeys(zipCode);

        //cycle through clicks as commented below
        
        selectList.addAll(Arrays.asList(
                //click search
                Array
                        .cssSelector(".LocationFlyout__searchBtn___2m4qm"),
                //click first radio button
                By.cssSelector("Label.RadioTile__tileContent___1bBd4"),
                //select "continue" button
                By.cssSelector(".LocationFlyout__footer___2d62o"),
                //click the "I really wanna continue" button
                By.cssSelector(".LocationFlyout__flyoutContainer___GSXOF > button:nth-child(2)"
                )));//end selectors.addAll()

        closeWalmartOnboardingPrompt(driver);

    }

//    public void clickDeptBurger(Webdriver driver){
//
//    }
}//end public class Walmart
