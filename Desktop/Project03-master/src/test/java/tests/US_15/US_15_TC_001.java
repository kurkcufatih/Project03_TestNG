package tests.US_15;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_15_TC_001 extends TestBaseRapor {
    SpendinGoodPage spendinGoodPage=new SpendinGoodPage();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();

    @Test
    public void tc_001() {
        spendinGoodPage=new SpendinGoodPage();
        extentTest=extentReports.createTest("Kupon basina kullanim limiti eklenebilme testi"
                ,"Kupon basina kullanim limit eklendigine gorebilme");
        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        spendinGoodPage.signInButton.click();
        spendinGoodPage.emailAdresBox.sendKeys(ConfigReader.getProperty("bekirEmail"));
        spendinGoodPage.passwordBox.sendKeys(ConfigReader.getProperty("bekirPassword1"));
        //todo US_12_TC_005\tc_005_02 ignore edildiyse bekirPassword2'yi kullan
        spendinGoodPage.signInButton2.click();
        extentTest.info("login olundu");
        ReusableMethods.waitFor(2);
        spendinGoodPage.myAccountButton.click();
        extentTest.info("My Account'a tiklandi");
        ReusableMethods.jsExecutorScrool(spendinGoodPage.storeManager);
        spendinGoodPage.storeManager.click();
        extentTest.info("Store Manager'a tiklandi");
        ReusableMethods.jsExecutorScrool(spendinGoodPage.couponButton);
        ReusableMethods.jsExecutorClick(spendinGoodPage.couponButton);
        extentTest.info("Coupons'a tiklandi");
        ReusableMethods.jsExecutorScrool(spendinGoodPage.couponAddNewButton);
        ReusableMethods.jsExecutorClick(spendinGoodPage.couponAddNewButton);
        extentTest.info("Add New'a tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.click(spendinGoodPage.codeText).sendKeys(faker.idNumber().valid())
                .sendKeys(Keys.TAB).sendKeys("Electronics").sendKeys(Keys.TAB)
                        .sendKeys(Keys.TAB).sendKeys("100").sendKeys(Keys.TAB)
                        .sendKeys("2022-12-31").sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                        .sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
        extentTest.info("Gerekli kupon bilgileri girildi");
        ReusableMethods.jsExecutorScrool(spendinGoodPage.couponLimitButon);
        ReusableMethods.jsExecutorClick(spendinGoodPage.couponLimitButon);
        extentTest.info("Limit'e tiklandi");
        spendinGoodPage.usageLimitPerCouponTextBox.sendKeys("2");
        extentTest.info("Usage limit per coupon'a bir sayi degeri girildi");
        spendinGoodPage.couponSubmitButon.click();
        extentTest.info("Submit butonuna basildi");
        ReusableMethods.waitForVisibility(spendinGoodPage.couponSuccessfullyPublishedMessage,3);
        Assert.assertTrue(spendinGoodPage.couponSuccessfullyPublishedMessage.isDisplayed());
        extentTest.pass("Kupon basina kullanim limiti eklendigi goruldu");


    }
}
