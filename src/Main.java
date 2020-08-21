import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String fileLocation = "testHTML.txt";
        String baseURL = "https://walmart.com/grocery";
        ArrayList<Array> prodPrice = null;

        //these are the CSS selectors. walmart specify these under data-automation-id tags
        String cssProdContainer = "div.productTile__productTileWrapper___G0H8Q";
        String cssSalePrice     = "div.Price__salePrice___3YEJa";
        String cssPricePerUnit  = "div.productTile__priceMetaInfo___AokKf";
        String cssNameContainer = "div.productTile__productNameContainer___3wOJS";

        Document doc = null;
        File input = new File(fileLocation);

        try {
            doc = Jsoup.parse(input,
                    "UTF-8",
                    baseURL);
            for (Element i : doc.select(cssProdContainer)) {
                String name =
                        i.select(cssProdContainer).text();
                String salePrice =
                        i.select(cssSalePrice).text();
                String pricePerUnit =
                        i.select(cssPricePerUnit).text();
                System.out.printf("name is %s  price is %s  price per unit is %s%n%n", name, salePrice, pricePerUnit);
            }


        } catch (IOException e) {
            System.out.println("parse failed");
        }
        //       System.out.print(doc);


        //for(Element i:
    }
}
