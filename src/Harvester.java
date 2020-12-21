import Store.Kroger.Smiths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Harvester {
    private static String driverPath;
    private static String downloadFilepath;

    public static void main(String[] args) {
        setDriverPath();
        Smiths smiths = new Smiths(getDriver(driverPath, false));
        smiths.changeLocation(84010);
    }

    public static WebDriver getDriver(String driverPath,boolean isHeadless) {

        System.setProperty("webdriver.gecko.driver", driverPath);
        FirefoxProfile profile = new FirefoxProfile();

        //set Firefox profile preferences
        /* it seems like you could get away without changing the browser.download.folderList preference to "2",
        but without it we can't change the browser.download.dir preference. */
        profile.setPreference("browser.download.folderList", 2);//uses last download directory as destination

        //set Firefox options
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false); //true == headless version of firefox

        //include profile in options
        options.setProfile(profile); //include all the profile settings in this option set

        //initiate new instance of firefox
        return new FirefoxDriver(options); //call the driver w/ our specified options (and profile).

    }//end public static WebDriver getHeadlessDriverSpecifyDownloadDirectory(String downloadFilepath, String mimeType)


    public static WebDriver getDownloadingDriver(String driverPath,boolean isHeadless,String downloadFilepath,
            String mimeType) {

        System.setProperty("webdriver.gecko.driver", driverPath);
        FirefoxProfile profile = new FirefoxProfile();

        //set Firefox profile preferences
        /* it seems like you could get away without changing the browser.download.folderList preference to "2",
        butwithout it we can't change the browser.download.dir preference. */
        profile.setPreference("browser.download.folderList", 2);//uses last download directory as destination
        profile.setPreference("browser.download.dir",downloadFilepath); //if path = invalid, goes to dwnlds folder

        /* the second argument in these preferences is what's called a "mimetype" of a filetype.
        I find the easiest way to figure the proper mimetype for your use is to follow Florent B's suggestion
        and look at the network panel under the developer tools under a manual run through.https://bit.ly/2FEYB0p */
        profile.setPreference("browser.helperApps.neverAsk.openFile",mimeType);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",mimeType);

        //set Firefox options
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(isHeadless); //run headless version of firefox

        //include profile in options
        options.setProfile(profile); //include all the profile settings in this option set

        //initiate new instance of firefox
        return new FirefoxDriver(options); //call the driver w/ our specified options (and profile).

    }//end getDownloadingDriver()


    private static void setDriverPath() {
        //assume that this is a linux machine, overwrite if it's a windows machine
        driverPath = "geckodriver-v0.27.0-linux64";
        if (System.getProperty("os.name").startsWith("Windows")) {
            //if this is a windows machine, overwrite the linux designation
            driverPath = "geckodriver-v0.27.0-win64.exe";
        }
    }//end setDriverPath()
}//end Harvester Class




