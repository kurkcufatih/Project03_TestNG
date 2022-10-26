package tests.US_12;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.*;

public class US_12_TC_001 extends TestBaseRapor {
    SpendinGoodPage spendinGoodPage;
    Actions actions=new Actions(Driver.getDriver());
    @Test
    public void tc_001() {
        extentTest=extentReports.createTest("siparis listesini gorebilme testi"
                ,"siparis edilen urunler listesini gorebilme");
        spendinGoodPage=new SpendinGoodPage();
        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        extentTest.info("Spendinggood Sitesine Gidildi");
        spendinGoodPage.signInButton.click();
        extentTest.info("Sign in butonuna tiklandi");
        spendinGoodPage.emailAdresBox.sendKeys(ConfigReader.getProperty("bekirEmail"));
        extentTest.info("Username olarak gecerli bir email adresi girildi");
        spendinGoodPage.passwordBox.sendKeys(ConfigReader.getProperty("bekirPassword1"));
        extentTest.info("Gecerli bir password girildi");
        spendinGoodPage.signInButton2.click();
        extentTest.info("SIGN IN butonuna tiklandi");
        ReusableMethods.waitFor(2);
        spendinGoodPage.myAccountButton.click();
        extentTest.info("My Account'a tiklandi");
        ReusableMethods.jsExecutorScrool(spendinGoodPage.myAccountOrdersButon);
        ReusableMethods.jsExecutorClick(spendinGoodPage.myAccountOrdersButon);
        extentTest.info(" ORDERS' a tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(spendinGoodPage.myAccountOrdersViewButon.isDisplayed());
        extentTest.pass("siparis edilen urunlerin listesi goruldu");

    }
}
