package crawls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.Scanner;

public class zollinger {
    public static String openFile(String fileLocation){

        File inFile = new File (fileLocation);
        Scanner file = null;
        String sourceText = null;
        try
        {
            file = new Scanner(inFile);

            while(file.hasNext()){
                sourceText = sourceText + file.nextLine();
            }//end of while(file.hasNext())

        } catch (Exception e) {

            System.out.printf("File Error: File '%s' not found! " +
                    "Please save the list before trying to open it.", fileLocation);

            System.out.printf("%s successfully pulled into program",fileLocation);
            return sourceText;

        } //end of catch (Exception e)

    }//end openFile(String fileLocation)

    public static String beautify(String input) {

        //define variables
        String testHTML     = null;
        String beautHTML    = null;
        WebDriver driver        = new FirefoxDriver();
        WebElement beautifier   = driver.findElement(By.id("source"));
        WebElement formatButton = driver.findElement(By.id("format"));
        String targetSite   = "https://www.bing.com/search?q=html%20beautifier";

            //define the webdriver file location
        System.setProperty("webdriver.gecko.driver", "\\Scripts\\webdrivers\\geckodriver-v0.27.0.exe");

        //determine if the string is an html doc or filename
        if (input.contains(".txt") || input.contains(".html")){
            testHTML = openFile(input);
        }else{
            testHTML = input;
        }//end if-else(if (input.contains(".txt") || input.contains(".html")))

        //open bing
        driver.get(targetSite);

        //paste raw html
        beautifier.click();
        beautifier.clear();
        beautifier.sendKeys(testHTML);
        formatButton.click();

        //retrieve beautified html
        beautHTML = beautifier.getText();

        System.out.println("successfully beautified HTML");
        return beautHTML;
}
