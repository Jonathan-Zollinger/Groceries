package Harvester;

import java.lang.*;
import java.util.Properties;

public class Store {

    //fields
    private static String storageDump;
    private static String driverFile;
    static {
        if (System.getProperty("os.name").startsWith("Windows")){
            storageDump = "C:\\Scripts\\Price_Tracker";
            driverFile = "geckodriver-v0.27.0-win64.exe";
        }else{//is linux
            storageDump = "/Price_Tracker";
            driverFile = "geckodriver-v0.27.0-linux64";
        }// end if(System.getProperty("os.name").startsWith("Windows")
    }
    //abstract fields
    private String homeURL;

    //constructors
    public Store(){
        homeURL = "zollyLobby.com";
    }

    //methods

    public void setHomeURL(String homeURL) {
        this.homeURL = homeURL;
    }

    public String getHomeURL() {
        return homeURL;
    }
}
