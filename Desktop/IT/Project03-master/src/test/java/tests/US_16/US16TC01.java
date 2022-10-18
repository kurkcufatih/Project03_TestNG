package tests.US_16;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US16TC01 extends TestBaseRapor {
    SpendinGoodPage spendinggoodPage = new SpendinGoodPage();

    @Test
    public void spendinggoodManageCustomerTest() {
        // https://spendinggood.com/store-manager/customers/
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
        // kayitli kisilerin isim/ kullanıcı adi/ maili, adresi, harcama miktarı, son siparişleri görülmeli
        Assert.assertTrue(spendinggoodPage.kayitliKullaniciIsim.isDisplayed(), "kayitliKullaniciIsim is not Displayed!");
        extentTest.info("Ilgili sayfada isim goruldugu dogrulandi.");
        Assert.assertTrue(spendinggoodPage.kayitliKullaniciKullaniciAdi.isDisplayed(), "kayitliKullaniciKullaniciAdi is not Displayed!");
        extentTest.info("Ilgili sayfada kullanıcı adi goruldugu dogrulandi.");
        Assert.assertTrue(spendinggoodPage.kayitliKullaniciMail.isDisplayed(), "kayitliKullaniciMail is not Displayed!");
        extentTest.info("Ilgili sayfada mail goruldugu dogrulandi.");
        Assert.assertTrue(spendinggoodPage.kayitliKullaniciAdres.isDisplayed(), "kayitliKullaniciAdres is not Displayed!");
        extentTest.info("Ilgili sayfada adres goruldugu dogrulandi.");
        Assert.assertTrue(spendinggoodPage.kayitliKullaniciHarcamaMiktari.isDisplayed(), "kayitliKullaniciHarcamaMiktari is not Displayed!");
        extentTest.info("Ilgili sayfada harcama miktari goruldugu dogrulandi.");
        Assert.assertTrue(spendinggoodPage.kayitliKullaniciSonSiparis.isDisplayed(), "kayitliKullaniciSonSiparis is not Displayed!");
        extentTest.info("Ilgili sayfada son siparis goruldugu dogrulandi.");

        extentTest.pass("spendinggoodManageCustomerTest PASS");
    }


}
