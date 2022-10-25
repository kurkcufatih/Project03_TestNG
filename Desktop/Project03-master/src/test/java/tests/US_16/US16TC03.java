package tests.US_16;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US16TC03 extends TestBaseRapor {
    page.SpendinGoodPage spendinggoodPage = new page.SpendinGoodPage();


    @Test
    public void spendinggoodYeniKisiEklenebilmeli() throws IOException {
        extentTest = extentReports.createTest("Manage customers", "isim/ kullanıcı adi/ maili, adresi, harcama miktarı, son siparişleri görüldugu dogrulandi");
        //Kullanici url e gider
        Driver.getDriver().get(ConfigReader.getProperty("spendinggoodUrl"));
        extentTest.info("Spendinggood sitesine gidildi.");
        //Kullanici sign in e tıklar
        spendinggoodPage.signInButton.click();
        //Email adresini girer
        spendinggoodPage.emailAdresBox.sendKeys(ConfigReader.getProperty("Email"));
        //Password girer
        spendinggoodPage.passwordBox.sendKeys(ConfigReader.getProperty("Password"));
        //Sign in butonuna tiklar
        spendinggoodPage.signInButton2.click();
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici girisi yapildi.");
        //My Account icinde Store Manager bölümüne girer
        spendinggoodPage.myAccountButton.click();
        spendinggoodPage.storeManager.click();
        //Ardından Customers bölümüne girer
        ReusableMethods.waitFor(2);
        ReusableMethods.jsExecutorScrool(spendinggoodPage.customers);
        ReusableMethods.jsExecutorClick(spendinggoodPage.customers);
        extentTest.info("Customers bolumune girildi.");
        //Girilen sayfada yeni kişi eklemek için Add New butonuna tıklar
        spendinggoodPage.addNewButton.click();
        //Username box bölümüne kullanıcı adı girer
        spendinggoodPage.addCustomerUsername.sendKeys("user20");
        //Email bölümüne mail adres girer
        spendinggoodPage.addCustomerMail.sendKeys("customer17@sad.com");
        //First name bölümüne isim girer
        spendinggoodPage.addCustomerFirstname.sendKeys("first15");
        //Last name bölümüne soyisim girer
        spendinggoodPage.addCustomerLastname.sendKeys("last14");
        //Sayfa altındaki Submit butonuna tıklar
        ReusableMethods.jsExecutorScrool(spendinggoodPage.addCustomerSubmitbutton);
        ReusableMethods.waitFor(2);
        ReusableMethods.jsExecutorClick(spendinggoodPage.addCustomerSubmitbutton);
        //“Customer Successfully Saved” yazısının göründüğünü doğrular
        ReusableMethods.jsExecutorScrool(spendinggoodPage.billingPostcodeZip);
        Assert.assertTrue(spendinggoodPage.basariliGirisYazisi.isDisplayed(), "basarili giris yazisi gorunmuyor!");
        extentTest.info("basarili bir sekilde yeni kisi eklendi");
        //Sayfayi kapatir
        Driver.closeDriver();
        extentTest.pass(" PASS");


    }



}
