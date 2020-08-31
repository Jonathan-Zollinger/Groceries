import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Walmart {
    public static void main(String[] args) {
        //define variables

        //because this program will either run on linux of windows, I don't need to plan for anything unix based.
        String cssSelector = null;
        String xPath = null;
        String url = null;

        Boolean isWindows = false;
        if (System.getProperty("os.name").startsWith("Windows")){
            isWindows = true;
        }//end if (System.getProperty("os.name")

        //specify folder and driver locations
        String driverFile = null;
        String storageDirectory = null;
        if (isWindows){
            storageDirectory = "C:\\Scripts\\Price_Tracker";
            driverFile = "geckodriver-v0.27.0-win64.exe";
        }else{//is linux
            storageDirectory = "/Price_Tracker";
            driverFile = "geckodriver-v0.27.0-linux64";
        }

        url = "https://www.walmart.com/grocery";

        //start driver
        WebDriver driver = getHeadlessDriverWithSpecDownload(driverFile,storageDirectory,null);

        //navigate to walmart.com/grocery
        driver.get(url);

        closeWalmartOnboardingPrompt(driver);

        //change the store selection
        driver.findElement(By.cssSelector(".button-link")).click();
        String storeZip = "84010";

        //enter zip code
        xPath = "/html/body/div[1]/div[2]/div[1]/section[2]/div/div[1]/div/div[1]/div/form/div/input";
        driver.findElement(By.xpath(xPath)).clear();
        driver.findElement(By.xpath(xPath)).sendKeys(storeZip);

        //cycle through clicks as commented below
        ArrayList<String> selectors = new ArrayList<>();
        selectors.addAll(Arrays.asList(
                //click search
                ".LocationFlyout__searchBtn___2m4qm",
                //click first radio button
                "Label.RadioTile__tileContent___1bBd4",
                //select "continue" button
                ".LocationFlyout__footer___2d62o",
                //click the "I really wanna continue" button
                ".LocationFlyout__flyoutContainer___GSXOF > button:nth-child(2)")
        );

        for(int i = 0; i < selectors.size(); i++){
            /*because the webpage may respond slower than our program, loop through a
                couple times if the driver action fails */
            int count = 2;
            while(count > 0) {
                try {
                    driver.findElement(
                            By.cssSelector(selectors.get(i)))
                            .click();
                    break;
                } catch (Exception e) {
                    System.out.printf("driver failed to click selector \"%s\" %n" +
                            "will try %d more times%n",selectors.get(i),count);
                    count --;
                    //wait 1/2 second till looping through
                    try{TimeUnit.MILLISECONDS.sleep(500);}catch (Exception d){System.out.print("sleep failed");}
                }//end catch (Exception e)
            }//end int count = 5; while(count > 0)
        }//end for(int i = 0; i < selectors.size(); i++)

        closeWalmartOnboardingPrompt(driver);
        //cycle through clicks as commented below
//        selectors.clear(); //cleans out arraylist
//        selectors.addAll(Arrays.asList(
//                "#mobileNavigationBtn",
//                ""));
//        driver.close();
        System.out.printf("driver has finished processing script. user can manipulate browser window%n");
    }

    public static WebDriver getHeadlessDriverWithSpecDownload(
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

    }//end public static WebDriver getHeadlessDriverWithSpecDownload(String downloadFilepath, String mimeType)
    public static void closeWalmartOnboardingPrompt(WebDriver driver){
        //if the "new to walmart" onboarding prompt come up, close it. loop through 5x to give the browser enough time.
        int count = 5;
        while(count > 0) {
            try {
                driver.findElement(By.className("OnboardingModal__closeBtn___2xhJM")).click();
                System.out.printf("driver closed onboarding prompt%n");
                break;
            } catch (Exception e) {
                System.out.printf("driver failed to click onboarding prompt, or onboarding prompt not present%n" +
                        "will try %d more times%n",count);
                count --;
                try{TimeUnit.SECONDS.sleep(1);}catch (Exception d){System.out.print("sleep failed");}
            }//end catch (Exception e)
        }//end int count = 5; while(count > 0)

    }//end public static void closeWalmartOnboardingPrompt(WebDriver driver)
}
