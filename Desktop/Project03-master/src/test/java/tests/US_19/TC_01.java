package tests.US_19;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
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
        extentTest = extentReports.createTest("Isim, e-posta tanımlanmalı", "Vendor takipçilerin isim ve epostlarını görebilmeli");
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
        ReusableMethods.jsExecutorClick(spendingPage.follewers);
        extentTest.info("Follewers butonuna tıklandı");

        ReusableMethods.jsExecutorScrool(spendingPage.home);
        String actualResultStr=spendingPage.follewersTable.getText();
        Assert.assertEquals(actualResultStr,"No data in the table");
        extentTest.fail("Takipçi adı görülemedi");

        Assert.assertEquals(actualResultStr,"No data in the table");
        extentTest.fail("Takipçi email i görülemedi");


    }
}
