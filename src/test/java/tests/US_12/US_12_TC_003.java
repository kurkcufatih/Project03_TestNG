package tests.US_12;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_12_TC_003 extends TestBaseRapor {
    SpendinGoodPage spendinGoodPage;

    @Test
    public void tc_003() {
        spendinGoodPage=new SpendinGoodPage();
        extentTest=extentReports.createTest("Fatura adresi ve gonderim adresi gorebilme testi"
                ,"Fatura adrsi ve gonderim adresi gorebilme");
        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        spendinGoodPage.signInButton.click();
        spendinGoodPage.emailAdresBox.sendKeys(ConfigReader.getProperty("bekirEmail"));
        spendinGoodPage.passwordBox.sendKeys(ConfigReader.getProperty("bekirPassword1"));
        spendinGoodPage.signInButton2.click();
        extentTest.info("Login olundu");
        ReusableMethods.waitFor(2);
        spendinGoodPage.myAccountButton.click();
        extentTest.info("My Account'a tiklandi");
        ReusableMethods.jsExecutorScrool(spendinGoodPage.myAccountAddressesButon);
        ReusableMethods.jsExecutorClick(spendinGoodPage.myAccountAddressesButon);
        extentTest.info("ADDRESSES' a tiklandi");
        ReusableMethods.jsExecutorScrool(spendinGoodPage.billingAddressTable);
        Assert.assertTrue(spendinGoodPage.billingAddressTable.isDisplayed());
        Assert.assertTrue(spendinGoodPage.shippingAddressTable.isDisplayed());
        extentTest.pass("Fatura adresini ve gonderim adres listesi goruldu");



    }
}
