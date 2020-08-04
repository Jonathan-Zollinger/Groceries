package crawls;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.PrintWriter;
import org.openqa.selenium.safari.SafariDriver;

import java.io.PrintWriter;

public class WalmartGroceryCrawl
{
    public static void main(String[] args)
    {
        //define variables
        String targetSite = "https:/www.walmart.com/grocery/products?aisle=1255027787131_4364938242&&page=1";

        //define the webdriver file location
        System.setProperty("webdriver.gecko.driver", "\\Scripts\\webdrivers\\geckodriver-v0.27.0.exe");

        //create an instance of FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        //open the website that is specified as the targetSite
        driver.get(targetSite);


        String testHTML = driver.getPageSource();
        String testHTMLFileName = "testHTML.txt";


        //save html to a file
        PrintWriter writer = null;
        try
        {
            writer = new PrintWriter(testHTMLFileName);
            writer.print(testHTML);
            writer.flush();
            writer.close();
            System.out.printf("%s successfully saved to file",testHTMLFileName);

        }catch (Exception e) {
        }

        //close the driver
        driver.quit();

    }
}
