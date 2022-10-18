package tests.US_16;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.File;
import java.io.IOException;

public class US16TC02 extends TestBaseRapor {

    SpendinGoodPage spendinggoodPage = new SpendinGoodPage();

    String excelDosyaYolu = "src/resources/allure2you BRD 2022-10-12.xlsx" ;
    String pdfDosyaYolu = "src/resources/Store Manager - Spending Good-1.pdf" ;
    String csvDosyaYolu = "src/resources/Store Manager - Spending Good.csv" ;

    @Test
    public void spendinggoodExcelPdfCsvDownloadTest() throws IOException {
        extentTest = extentReports.createTest("Manage customers", "isim/ kullanıcı adi/ maili, adresi, harcama miktarı, son siparişleri görüldugu dogrulandi");
        Driver.getDriver().get(ConfigReader.getProperty("spendinggoodUrl"));
        extentTest.info("Spendinggood sitesine gidildi.");

        // Manage customers;
        spendinggoodPage.signInButton.click();
        spendinggoodPage.emailAdresBox.sendKeys(ConfigReader.getProperty("email"));
        spendinggoodPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        spendinggoodPage.signInButton2.click();
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici girisi yapildi.");
        spendinggoodPage.myAccountButton.click();
        spendinggoodPage.storeManager.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.jsExecutorScrool(spendinggoodPage.customers);
        ReusableMethods.jsExecutorClick(spendinggoodPage.customers);
        extentTest.info("Customers bolumune girildi.");

        // Kisilerin tum bilgileri pdf, excel ve csa olarak indirilebilmeli
        Actions actions =new Actions(Driver.getDriver());

        //actions.moveToElement(spendinggoodPage.pdfDownloadButton).perform();
        ReusableMethods.jsExecutorScrool(spendinggoodPage.pdfDownloadButton);
        spendinggoodPage.pdfDownloadButton.click();
        ReusableMethods.waitFor(4);
        File file = new File(excelDosyaYolu);

        String dosya= file.getName();
        Assert.assertFalse(dosya.isEmpty(),"dosya indirilemedi.........");
        extentTest.info("pdf is download");

        ReusableMethods.waitFor(4);
        ReusableMethods.jsExecutorScrool(spendinggoodPage.excelDownloadButton);
        actions.click(spendinggoodPage.excelDownloadButton).perform();
        ReusableMethods.waitFor(4);
        file =new File(excelDosyaYolu);

        dosya = file.getName();
        Assert.assertFalse(dosya.isEmpty(),"dosya indirilemedi.........");
        extentTest.info("excel is download");

        ReusableMethods.jsExecutorScrool(spendinggoodPage.csvDownloadButton);
        spendinggoodPage.csvDownloadButton.click();
        ReusableMethods.waitFor(4);
        file =new File(csvDosyaYolu);

        dosya = file.getName();
        Assert.assertFalse(dosya.isEmpty(),"dosya indirilemedi.........");
        extentTest.info("csv is download");

        extentTest.pass(" PASS");


    }
}
