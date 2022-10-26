package tests.US_16;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US16TC01 extends TestBaseRapor {
    page.SpendinGoodPage spendinggoodPage = new page.SpendinGoodPage();

    @Test
    public void spendinggoodManageCustomerTest() {
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
        //kayitli kisilerin isim/ kullanıcı adi/ maili, adresi, harcama miktarı, son siparişleri görülmeli
        SoftAssert softAssert = new SoftAssert();
        //Girilen bölümde isminin görüldüğünü doğrular
        softAssert.assertTrue(spendinggoodPage.kayitliKullaniciIsim.isDisplayed());
        extentTest.info("Girilen bölümde isminin görüldüğünü doğrulandi");
        //Girilen bölümde kullanıcı adının görüldüğünü doğrular
        softAssert.assertTrue(spendinggoodPage.kayitliKullaniciIsim.isDisplayed());
        extentTest.info("Girilen bölümde kullanıcı adının görüldüğünü doğrulandi");
        //Girilen bölümde mail adresinin görüldüğünü doğrular
        softAssert.assertTrue(spendinggoodPage.kayitliKullaniciMail.isDisplayed());
        extentTest.info("Girilen bölümde mail adresinin görüldüğü doğrulandi");
        //Girilen bölümde adres görüldüğünü doğrular
        softAssert.assertTrue(spendinggoodPage.kayitliKullaniciAdres.isDisplayed());
        extentTest.info("Girilen bölümde adres görüldüğü doğrulandi");
        //Girilen bölümde harcama miktarının görüldüğünü doğrular
        softAssert.assertTrue(spendinggoodPage.kayitliKullaniciHarcamaMiktari.isDisplayed());
        extentTest.info("Girilen bölümde harcama miktarının görüldüğü doğrulandi");
        //Girilen bölümde son siparişlerin görüldüğünü doğrular
        softAssert.assertTrue(spendinggoodPage.kayitliKullaniciSonSiparis.isDisplayed());
        extentTest.info("Girilen bölümde son siparişlerin görüldüğü doğrulandi");
        softAssert.assertAll();
        extentTest.pass("spendinggoodManageCustomerTest PASS");
        //Sayfayi kapatir
        Driver.closeDriver();

    }
}
