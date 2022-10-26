package tests.US_12;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_12_TC_002 extends TestBaseRapor {
    SpendinGoodPage spendinGoodPage;

    @Test
    public void tc_002() {
        spendinGoodPage=new SpendinGoodPage();
        extentTest=extentReports.createTest("indirimli urunler listesini gorebilme testi"
                ,"Tanimlanmis indirimli urunler listesini gorebilme");
        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        spendinGoodPage.signInButton.click();
        spendinGoodPage.emailAdresBox.sendKeys(ConfigReader.getProperty("bekirEmail"));
        spendinGoodPage.passwordBox.sendKeys(ConfigReader.getProperty("bekirPassword1"));
        spendinGoodPage.signInButton2.click();
        extentTest.info("login olundu");
        ReusableMethods.waitFor(2);
        spendinGoodPage.myAccountButton.click();
        extentTest.info("My Account'a tiklandi");
        ReusableMethods.jsExecutorScrool(spendinGoodPage.myAccountDownloadButon);
        ReusableMethods.jsExecutorClick(spendinGoodPage.myAccountDownloadButon);
        extentTest.info("DOWNLOADS' a tiklandi");
        ReusableMethods.jsExecutorScrool(spendinGoodPage.productHead);
        Assert.assertTrue(spendinGoodPage.productHead.isDisplayed());
        extentTest.pass("Tanimlanmis indirimli urunlerin listesi goruldu");


    }
}
