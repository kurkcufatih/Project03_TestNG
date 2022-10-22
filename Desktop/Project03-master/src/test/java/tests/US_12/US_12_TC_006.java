package tests.US_12;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_12_TC_006 extends TestBaseRapor {
    SpendinGoodPage spendinGoodPage;
    Actions actions;
    @Test
    public void tc_006_NegativeTest() {
        spendinGoodPage=new SpendinGoodPage();
        actions=new Actions(Driver.getDriver());
        extentTest=extentReports.createTest("Negative test"
                ,"Hesap bilgisi ve eposta adresinin update edilmedigi gorebilme");
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
                .sendKeys(Keys.TAB).sendKeys(Keys.DELETE)
                .sendKeys(Keys.TAB).sendKeys(Keys.DELETE).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info(" Bazi guncelleme bilgileri bos girildi");
        ReusableMethods.waitForVisibility(spendinGoodPage.updateFailedMessage,5);
        Assert.assertTrue(spendinGoodPage.updateFailedMessage.isDisplayed());
        extentTest.pass("Hesap bilgisi ve eposta adresi update edilmedigi goruldu");


    }


}
