package Store;

import org.openqa.selenium.By;

public class Selector {
    //values
    By by;
    String name;

    public Selector(){

    }
    public Selector(String name,By by){
        this.by     = by;
        this.name   = name;
    }

    public void setBy(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
