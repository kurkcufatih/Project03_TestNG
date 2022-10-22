package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Driver {

    private Driver() {//baska classtan obje ureterek getDriver'a ulasilmasini engellemek icin
    }                 //parametresiz constructor ile private yaptik

    //diger classlardan class ismiyle cagiracagimiz icin static hepsinin ulasmasi icinde public yaptik
    static WebDriver driver;

    public static WebDriver getDriver(){  //driver methodu olusturalim hep bununla driverimizi cagiracagiz
        WebDriverManager.chromedriver().setup();

        // Driver.getDriver methodu her calistigibda
        // driver=new ChromeDriver(); komutundan oturu yeni bir driver olusturuyor
        // Biz Driver Class'ini ilk calistirdigimizda new atamasi olsun
        // sonraki calistirmalarda atama olmasin istiyoruz
        // bunun icin driver=new ChromeDriver(); satiri if blogu icine alacagiz
        if(driver==null) {  //eger chromeDriver'imiz acik degilse acacak yoksa acmayacak
            driver=new ChromeDriver();  // sayfa aciksa obje 2. defa olusmaz
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){  //driver'imiz aciksa kapatacak
            driver.quit();
            driver=null;    //baska testte driver'in acilmasi icin null egeri atadik 16.satir
        }
    }
}