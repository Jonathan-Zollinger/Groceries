import GroceryEnums.Brand;
import GroceryEnums.Measure;

import java.util.HashMap;
import java.util.Map;

public class Grocery {
    String product;                         //ie "Petite Sirloin Steak", "Pepperoni Bagels", or "Granny Smith Apple"
    String measure;                         //this is controlled by the Measure enum
    String brand;                           //this is controlled by the Brand enum
    double size;                            //ie if ground meat is $3.99/lbs, then put 1.0 (lbs). 8oz soda is 8.0
    double price;                           //out the door price
    boolean glutenFree;                     //declared gluten free, not lacking gluten containing ingredients
    boolean isPricedByCount;                //if it's not priced by count, it's priced by weight
    Map<String, Double> pricePerMeasure;    //houses the pricing per measure applicable to this grocery object

    public Grocery(){
        pricePerMeasure = new HashMap<>();
    }
    public Grocery(String product, Measure measure, Brand brand, double size, double price, boolean glutenFree,
                   boolean isPricedByCount){
        this.product = product;
        this.measure = measure.toString();
        this.brand = brand.toString();
        this.size = size;
        this.price = price;
        this.glutenFree = glutenFree;
        this.isPricedByCount = isPricedByCount;
        pricePerMeasure = new HashMap<>();
    }
    //methods
    public void calculatePricePerMeasure(){
        //TODO: throw this in a try catch in the event the measure is missing or something
        double gramToOunce = 0.03527396;

        double pricePerOz, pricePerFlOz, pricePerLbs, pricePerGram, pricePerKilogram, pricePerMilliliter, pricePerLiter;

        switch (measure){
            case "fluid ounce":
                pricePerFlOz = price / size;
                pricePerMeasure.put("fluid ounce",pricePerFlOz);
                break;
            case "ounce":
                pricePerOz = price / size;
                pricePerGram = pricePerOz/gramToOunce;
                pricePerMeasure.put("ounce",pricePerOz);
                pricePerMeasure.put("pound",pricePerOz*16);
                pricePerMeasure.put("gram",pricePerGram);
                pricePerMeasure.put("kilogram",pricePerGram*1000);
                break;
            case "pound":
                pricePerLbs = price / size;
                pricePerGram = pricePerLbs/16/gramToOunce;
                pricePerMeasure.put("ounce",pricePerLbs/16);
                pricePerMeasure.put("pound",pricePerLbs);
                pricePerMeasure.put("gram",pricePerGram);
                pricePerMeasure.put("kilogram",pricePerGram*1000);
                break;
            case "milliliter":
                pricePerMilliliter = price / size;
                pricePerMeasure.put("milliliter",pricePerMilliliter);
                pricePerMeasure.put("liter",pricePerMilliliter*1000);
                break;
            case "liter":
                pricePerLiter = price / size;
                pricePerMeasure.put("milliliter",pricePerLiter/1000);
                pricePerMeasure.put("liter",pricePerLiter);
                break;
            case "gram":
                pricePerGram = price / size;
                pricePerOz = pricePerGram * gramToOunce;
                pricePerMeasure.put("gram",pricePerGram);
                pricePerMeasure.put("kilogram",pricePerGram*1000);
                pricePerMeasure.put("ounce",pricePerOz);
                pricePerMeasure.put("pound",pricePerOz*16);
                break;
            case "kilogram":
                pricePerKilogram = price / size;
                pricePerOz = pricePerKilogram/1000 * gramToOunce;
                pricePerMeasure.put("gram",pricePerKilogram/1000);
                pricePerMeasure.put("kilogram",pricePerKilogram);
                pricePerMeasure.put("ounce",pricePerOz);
                pricePerMeasure.put("pound",pricePerOz*16);
                break;
            default:
                throw new IllegalStateException("Unexpected measure: " + measure);
        }

    }


    //setters

    public void setProduct(String product) {
        this.product = product;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure.toString();
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setBrand(Brand brand) {
        this.brand = brand.toString();
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public void setPricedByCount(boolean pricedByCount) {
        isPricedByCount = pricedByCount;
    }

    //getters

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public String getMeasure() {
        return measure;
    }

    public double getSize() {
        return size;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public boolean isPricedByCount() {
        return isPricedByCount;
    }

    public Map<String, Double> getPricePerMeasure() {
        return pricePerMeasure;
    }
}
