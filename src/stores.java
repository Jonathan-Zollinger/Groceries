import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class stores {

    public static void main(String[] args) {
        String url = "https://www.walmart.com/grocery";
        String cssSelector;
        String xPath;

        Boolean isWindows = false;
        if (System.getProperty("os.name").startsWith("Windows")){
            isWindows = true;
        }//end if (System.getProperty("os.name")

        //specify folder and driver locations
        String driverFile = constants.driverFile;
        String storageDirectory = constants.storageDirectory;

        //intialize a headless driver w/ a specified download directory
        WebDriver driver = Walmart.getHeadlessDriverSpecifyDownloadDirectory(driverFile,storageDirectory,null);

        driver.get(url);
        Walmart.closeWalmartOnboardingPrompt(driver);

//        ArrayList<String> selectors = new ArrayList<>();
//        selectors.clear(); //cleans out arraylist
//        selectors.addAll(Arrays.asList("#mobileNavigationBtn",
//        "button.NavigationPanel__item___pzwlC"));
        int count = 5;
        while(count > 0) {
            try {
                driver.findElement(By.cssSelector( "#mobileNavigationBtn")).click();
                break;
            } catch (Exception e) {
                System.out.printf("failed to click mobileNavigationBtn%n" +
                        "will try %d more times%n",count);
                count --;
                try{
                    TimeUnit.SECONDS.sleep(1);}catch (Exception d){System.out.print("sleep failed");}
            }//end catch (Exception e)
        }//end int count = 5; while(count > 0)

        driver.findElement(
                By.cssSelector(
                        "li.NavigationPanel__department___1DF7d:nth-child(4) > button:nth-child(1)"));



    }//end public static void main(String[] args)
}//end public class stores {
