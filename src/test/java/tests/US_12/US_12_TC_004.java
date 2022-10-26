package tests.US_12;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_12_TC_004 extends TestBaseRapor {
    SpendinGoodPage spendinGoodPage;

    @Test
    public void tc_004() {
        spendinGoodPage=new SpendinGoodPage();
        extentTest=extentReports.createTest("Hesap bilgisi ve eposta adresini gorebilme testi"
                ,"Hesap bilgisi ve eposta adresini gorebilme");
        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        spendinGoodPage.signInButton.click();
        spendinGoodPage.emailAdresBox.sendKeys(ConfigReader.getProperty("bekirEmail"));
        spendinGoodPage.passwordBox.sendKeys(ConfigReader.getProperty("bekirPassword1"));
        spendinGoodPage.signInButton2.click();
        extentTest.info("Login olundu");
        ReusableMethods.waitFor(3);
        spendinGoodPage.myAccountButton.click();
        extentTest.info("My Account'a tiklandi");
        ReusableMethods.jsExecutorScrool(spendinGoodPage.myAccountAccountDetailsButon);
        ReusableMethods.jsExecutorClick(spendinGoodPage.myAccountAccountDetailsButon);
        extentTest.info("ACCOUNT DETAILS' e tiklandi");
        ReusableMethods.jsExecutorScrool(spendinGoodPage.updateAccountDetails);
        Assert.assertTrue(spendinGoodPage.updateAccountDetails.isDisplayed());
        extentTest.pass("Hesap bilgisi ve eposta adresi goruldu");


    }
}
