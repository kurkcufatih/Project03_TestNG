package tests.US_20;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_02 extends TestBaseRapor {
    @Test
    public void testCase02() {
        extentTest = extentReports.createTest("Kullanici bilgisi, yazmış olduğu comment görülmeli", "Kullanici bilgisi, yazmış olduğu comment görülmeli");
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
        ReusableMethods.jsExecutorClick(spendingPage.reviews);
        extentTest.info("Reviews butonuna tıklandı");

        spendingPage.productReviews.click();
        extentTest.info("Product reviews butonuna tıklandı");

        Assert.assertTrue(spendingPage.productReviewsRating.isDisplayed());
        extentTest.pass("Kullanicinin verdigi rate dogrulandi");

        Assert.assertTrue(spendingPage.productReviewsDate.isDisplayed());
        extentTest.pass("Kullanicinin yazmis oldugu comment tarihi dogrulandi");



    }
}
