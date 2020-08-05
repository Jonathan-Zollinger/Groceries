package crawls;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WalmartGroceryCrawl
{
    public static void main(String[] args){
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

        //close the driver
        driver.quit();

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


    }//end public static void main(String[] args)

    public static String openFile(String fileLocation) {

        File inFile = new File(fileLocation);
        Scanner file = null;
        String sourceText = null;
        try {
            file = new Scanner(inFile);

            while (file.hasNext()) {
                sourceText = sourceText + file.nextLine();
            }//end of while(file.hasNext())

        } catch (Exception e) {

            System.out.printf("File Error: File '%s' not found! " +
                    "Please save the list before trying to open it.", fileLocation);

            System.out.printf("%s successfully pulled into program", fileLocation);

        } //end of catch (Exception e)
        return sourceText;
    }//end openFile(String fileLocation)

    //this method beautifies html code
    public static String beautifyHTML(String input) {

        //define variables
        String testHTML = null;
        String beautHTML = null;
        WebDriver driver = new FirefoxDriver();
        WebElement beautifier = driver.findElement(By.id("source"));
        WebElement formatButton = driver.findElement(By.id("format"));
        String targetSite = "https://www.bing.com/search?q=html%20beautifier";

        //define the webdriver file location
        System.setProperty("webdriver.gecko.driver", "\\Scripts\\webdrivers\\geckodriver-v0.27.0.exe");

        //determine if the string is an html doc or filename
        if (input.contains(".txt") || input.contains(".html")) {
            testHTML = openFile(input);
        } else {
            testHTML = input;
        }//end if-else(if (input.contains(".txt") || input.contains(".html")))

        //open bing
        driver.get("www.google.com");

        //paste raw html
        beautifier.click();
        beautifier.clear();
        beautifier.sendKeys(testHTML);
        formatButton.click();

        //retrieve beautified html
        beautHTML = beautifier.getText();

        System.out.println("successfully beautified HTML");
        return beautHTML;
    }//end public static String beautify(String input)

    public static ArrayList<String> prodPrice(String filelocation,String baseURL) throws IOException {
        ArrayList<String> prodPrice = null;
        File input = new File(filelocation);

        Document doc = Jsoup.parse(input, "UTF-8", baseURL);
        //for(Element i:

        return prodPrice;
    }//end public static ArrayList<String> prodPrice(String filelocation)
}
