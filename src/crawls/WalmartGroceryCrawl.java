package crawls;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

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
        Document jSoupDoc = Jsoup.parse(testHTML);

        String testHTMLFileName = "testHTML.txt";
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
