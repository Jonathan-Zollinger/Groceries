package crawls;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.PrintWriter;
//import org.selenium.By;

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

        //define html text filename
        String htmlFile = targetSite.substring(targetSite.indexOf("www")+4,targetSite.indexOf(".com")) + "_html.txt";

        //pull html, store to string
        String html = null;
        try
        {
            html = Jsoup.connect(driver.getCurrentUrl()).get().html();
        }catch(Exception e)
        {
            System.out.printf("can't pull html from %s",targetSite);
        }

        //save html source code to text file
        PrintWriter writer = null;
        try
        {
            writer = new PrintWriter(htmlFile);
            writer.print(html);
            writer.flush();
            writer.close();
            System.out.printf("%s successfully written",htmlFile);

        }catch (Exception e)
        {
            System.out.printf("%s not written",htmlFile);
        }

//      comments are older as you scroll down. separate comments with white space


//      it seems the content we're looking for is under  a shoppingContent id, as you can see that in the bottom
//      of the dev tools'

//      the html we're looking for (the "ProductsTile" found within the "ProductsPage__right___2Z56X" or "id="mainSearchContent""
//      is found not found in the source html. closest I've found is finding "styles__scrollableBody___1dEFw" within
//      the second i5 link soon after the <body> tag. we want this in order to automate the selection process.

        WebElement price = driver.findElement(By.cssSelector("#item-13893729 > div > div.productTile__productTileDetails___25AJd > a > span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(price);
        actions.click(price);

         //close the driver
//        driver.quit();

    }
}
