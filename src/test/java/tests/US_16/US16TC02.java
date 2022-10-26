package tests.US_16;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;

public class US16TC02 extends TestBaseRapor {

    page.SpendinGoodPage spendinggoodPage = new page.SpendinGoodPage();

    @Test
    public void spendinggoodManageCustomerTest() throws IOException {
        extentTest = extentReports.createTest("Manage customers", "isim/ kullanıcı adi/ maili, adresi, harcama miktarı, son siparişleri görüldugu dogrulandi");
        //Kullanici url e gidebilmeli
        Driver.getDriver().get(ConfigReader.getProperty("spendinggoodUrl"));
        extentTest.info("Kullanici url e gidebildi.");
        //Kullanici  sign in e tıklayabilmeli
        spendinggoodPage.signInButton.click();
        extentTest.info("Kullanici  sign in e tıklayabildi.");
        //Email adresini girebilmeli
        spendinggoodPage.emailAdresBox.sendKeys(ConfigReader.getProperty("cihadEmail"));
        extentTest.info("Email adresini girebildi.");
        //Password girebilmeli
        spendinggoodPage.passwordBox.sendKeys(ConfigReader.getProperty("cihadPassword"));
        extentTest.info("Password girebildi.");
        //Sign in butonuna tıklayabilmeli
        spendinggoodPage.signInButton2.click();
        ReusableMethods.waitFor(3);
        extentTest.info("Sign in butonuna tıklayabildi.");
        //My Account içinde Store Manager bölümüne girer
        spendinggoodPage.myAccountButton.click();
        spendinggoodPage.storeManager.click();
        ReusableMethods.waitFor(1);
        extentTest.info("My Account içinde Store Manager bölümüne gidebildi");
        //Ardından Customers bölümüne girer
        ReusableMethods.jsExecutorScrool(spendinggoodPage.customers);
        ReusableMethods.jsExecutorClick(spendinggoodPage.customers);
        extentTest.info("Customers bölümüne gidebildi");
        //Açılan sayfada PDF butonuna tıklar
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
        spendinggoodPage.pdfDownloadButton.click();
        extentTest.info("PDF butonuna tıklayabildi");
        //PDF dosyasını indirir
        String path = "C:\\Users\\USER\\Downloads";

        SoftAssert softAssert = new SoftAssert();
        String pdf = "Store Manager - Spending Good.pdf";
        ReusableMethods.waitFor(4);
        boolean isDownloaded = pdfDownloaded(path, pdf);
        if (isDownloaded) {
            extentTest.info("PDF dosyasi indirildi");
        } else {
            extentTest.info("PDF dosyasi indirilemedi");
        }


        //Excel butonuna tiklar
        ReusableMethods.jsExecutorScrool(spendinggoodPage.excelDownloadButton);
        spendinggoodPage.excelDownloadButton.click();
        extentTest.info("excel butonuna tıklayabildi");
        //Excel dosyasını indirir
        String excel = "Store Manager - Spending Good.xlsx";
        ReusableMethods.waitFor(4);

        isDownloaded = excelDownloaded(path, excel);
        if (isDownloaded) {
            extentTest.info("excel dosyasi indirildi");
        } else {
            extentTest.info("excel dosyasi indirilemedi");
        }
        softAssert.assertAll();

        //CSV butonuna tiklar
        ReusableMethods.jsExecutorScrool(spendinggoodPage.csvDownloadButton);
        spendinggoodPage.csvDownloadButton.click();
        extentTest.info("csv butonuna tıklayabildi");
        //CSV dosyasını indirir
        String csv = "Store Manager - Spending Good.csv";
        ReusableMethods.waitFor(4);

        isDownloaded = csvDownloaded(path, csv);
        if (isDownloaded) {
            extentTest.info("csv dosyasi indirildi");
        } else {
            extentTest.info("csv dosyasi indirilemedi");
        }

        softAssert.assertTrue(isDownloaded, "CSV dosyasi indirilemedi!");
        extentTest.info("CSV dosyası indirildi");
        softAssert.assertAll();
        //Sayfayi kapatir
        Driver.closeDriver();
    }


    public static boolean pdfDownloaded(String downloadPathPDF, String fileName) {
        File file = new File(downloadPathPDF);
        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean excelDownloaded(String downloadPathExcel, String fileName) {
        File file = new File(downloadPathExcel);
        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean csvDownloaded(String downloadPathCSV, String fileName) {
        File file = new File(downloadPathCSV);
        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }
}
