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
    SpendinGoodPage spendinggoodPage = new SpendinGoodPage();


    @Test
    public void spendinggoodYeniKisiEklenebilmeli() throws IOException {
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

        // Yeni kisi eklenebilmeli; kullanici adi, mail isim, soyisim
        spendinggoodPage.addNewButton.click();
        spendinggoodPage.addCustomerUsername.sendKeys("user5");
        spendinggoodPage.addCustomerMail.sendKeys("customer5@sad.com");
        spendinggoodPage.addCustomerFirstname.sendKeys("first5");
        spendinggoodPage.addCustomerLastname.sendKeys("last5");
        ReusableMethods.jsExecutorScrool(spendinggoodPage.addCustomerSubmitbutton);
        ReusableMethods.jsExecutorClick(spendinggoodPage.addCustomerSubmitbutton);

        Assert.assertTrue(spendinggoodPage.basariliGirisYazisi.isDisplayed(), "basarili giris yazisi gorunmuyor!");

        extentTest.info("basarili bir sekilde yeni kisi eklendi");

        extentTest.pass(" PASS");


    }

}
