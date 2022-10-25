package tests.US_18;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_03 extends TestBaseRapor {
    @Test
    public void testCase03() {
        extentTest = extentReports.createTest("Ne kadar urun alindigi belli edilmeli", "Vendor olarak Ne kadar urun alindigi belli edilmeli");
        SpendinGoodPage spendingPage=new SpendinGoodPage();

        spendingPage.girisYap("oguzEmail","oguzPassword");
        extentTest.info("Spendinggood sitesine gidildi, vendor olarak giris yapıldı");

        ReusableMethods.waitFor(3);
        spendingPage.myAccount.click();
        extentTest.info("My Account butonuna tıklandı");

        ReusableMethods.jsExecutorScrool(spendingPage.dashboard);
        ReusableMethods.waitFor(1);
        spendingPage.storeManager.click();
        extentTest.info("Store Manager butonuna tıklandı");

        ReusableMethods.jsExecutorScrool(spendingPage.home);
        ReusableMethods.jsExecutorClick(spendingPage.refundButton);
        extentTest.info("Refunds butonuna tıklandı");

        ReusableMethods.jsExecutorScrool(spendingPage.home);
        Assert.assertTrue(spendingPage.orderIdAmount.isDisplayed());
        extentTest.pass("Order id altında amount oldugu dogrulandi");


    }
}
