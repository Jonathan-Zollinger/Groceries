package crawls;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.selenium.By;

public class WalmartGroceryCrawl
{
    public static void main(String[] args)
    {
        //define variables
        String targetSite = "https:/www.walmart.com/grocery/products?aisle=1255027787131_4364938242&&page=1";

        //define the webdriver file location
        System.setProperty("webdriver.gecko.driver", "\\Scripts\\webdrivers\\geckodriver.exe");


        WebDriver driver = new FirefoxDriver();

        driver.get(targetSite);
    }
}
