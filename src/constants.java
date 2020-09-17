import org.openqa.selenium.By;

import java.lang.*;
import java.util.Properties;

public class constants {
    public static String driverFile;
    public static String storageDirectory;
    static {
        if (System.getProperty("os.name").startsWith("Windows")){
            storageDirectory = "C:\\Scripts\\Price_Tracker";
            driverFile = "geckodriver-v0.27.0-win64.exe";
        }else{//is linux
            storageDirectory = "/Price_Tracker";
            driverFile = "geckodriver-v0.27.0-linux64";
        }// end if(System.getProperty("os.name").startsWith("Windows")
    }// end static

}//end public class constants

