package utilities;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;  //iki yerden ulasmak icin class levelde atadik
    //test class'larindan class ismiyle ulasmak icin static yaptik

    static {
        String path="configuration.properties";
        try {

            FileInputStream fis=new FileInputStream(path);//dosyayi akisa aldik
            properties=new Properties();
            properties.load(fis);//akisa aldigimiz dosyayi properties'e yukledik
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getProperty(String key) { //Test classindan gonderdigimiz key'i Properties
        return properties.getProperty(key);//class'i sayesinde configuration.properties text'inden
        //aldigi valueyu donderir
    }
}