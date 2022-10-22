package tests.US_12;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_12_TC_005 extends TestBaseRapor {
    SpendinGoodPage spendinGoodPage;
    Actions actions;
    @Test
    public void tc_005_01() {
        spendinGoodPage=new SpendinGoodPage();
        actions=new Actions(Driver.getDriver());
        extentTest=extentReports.createTest("Hesap bilgisi ve eposta adresini update edilme testi"
                ,"Hesap bilgisi ve eposta adresini update edildigini gorebilme");
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
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinGoodPage.updateAccountFirstNameTextBox.clear();
        actions.click(spendinGoodPage.updateAccountFirstNameTextBox)
                .sendKeys(ConfigReader.getProperty("bekirFirstname1"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("bekirLastname1"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("bekirDisplayname1"))
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("bekirPassword1"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("bekirPassword2"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("bekirPassword2"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("Guncelleme bilgileri girildi");
        ReusableMethods.waitForVisibility(spendinGoodPage.updateSuccessfulMessage,5);
        Assert.assertTrue(spendinGoodPage.updateSuccessfulMessage.isDisplayed());
        extentTest.pass("Hesap bilgisi ve eposta adresi update edildigi goruldu");
        Driver.closeDriver();//  TODO projeye eklerken driver.close kaldirmayi unutma
    }

    //@Ignore   // TODO proje sunumunda aktif hale getir.
    @Test
    public void tc_005_02() {
        spendinGoodPage=new SpendinGoodPage();
        actions=new Actions(Driver.getDriver());
        extentTest=extentReports.createTest("Hesap bilgisi ve eposta adresini update edilme testi"
                ,"Hesap bilgisi ve eposta adresini update edildigini gorebilme");
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
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinGoodPage.updateAccountFirstNameTextBox.clear();
        actions.click(spendinGoodPage.updateAccountFirstNameTextBox)
                .sendKeys(ConfigReader.getProperty("bekirFirstname2"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("bekirLastname2"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("bekirDisplayname2"))
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("bekirPassword2"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("bekirPassword1"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("bekirPassword1"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("Guncelleme bilgileri girildi");
        ReusableMethods.waitForVisibility(spendinGoodPage.updateSuccessfulMessage,5);
        Assert.assertTrue(spendinGoodPage.updateSuccessfulMessage.isDisplayed());
        extentTest.pass("Hesap bilgisi ve eposta adresi update edildigi goruuldu");

    }

}
