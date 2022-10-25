package tests.US_18;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_01 extends TestBaseRapor {
    @Test
    public void testCase01() {
        extentTest = extentReports.createTest("RequestID geri isteme istegi", "Vendor olarak RequestID geri isteme istegi olusturulabilmeli");
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
        ReusableMethods.waitFor(1);
        ReusableMethods.jsExecutorClick(spendingPage.orders);
        extentTest.info("Orders butonuna tıklandı");

        ReusableMethods.jsExecutorScrool(spendingPage.home);
        ReusableMethods.waitFor(1);
        Assert.assertFalse(spendingPage.ordersListViewDetails.isEmpty());
        extentTest.pass("Orders sayfasında orderların gorundugu dogrulandi");
        ReusableMethods.waitFor(1);

        ReusableMethods.jsExecutorScrool(spendingPage.refundRequest);
        ReusableMethods.jsExecutorClick(spendingPage.refundRequest);
        extentTest.info("Refund request butonuna tıklandı");
        ReusableMethods.waitFor(1);

        Select select = new Select(spendingPage.refundRequestDropDown);
        ReusableMethods.waitFor(1);
        select.selectByIndex(0);
        extentTest.info("Full refund secenegi secildi");

        spendingPage.refundRequestReasonTextBox.sendKeys("Magazamizdan kaynakl bir sorundan dolayı urununuz gonderilememektedir.");
        extentTest.info("Reason kısmına açıklama girildi");

        //spendingPage.refundRequestSubmitButton.click();
        extentTest.pass("Submit butonuna tıklandı");


    }
}
