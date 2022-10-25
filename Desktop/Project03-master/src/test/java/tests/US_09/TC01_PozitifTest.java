package tests.US_09;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class TC01_PozitifTest {
    @Test
    public void US09_TC01_ShippingOpsiyonu_PozitifTest() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        SpendinGoodPage spendinGoodPage = new SpendinGoodPage();

        //kullanici anasayfadaki sign in butonuna tiklar
        spendinGoodPage.signInButton.click();

        //kullanici email girer
        //kullanici sifre girer
        //kullanici sign in butonuna tiklar
        actions.click(spendinGoodPage.emailAdresBox).
                sendKeys(ConfigReader.getProperty("fatihEmail")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("fatihPassword")).
                click(spendinGoodPage.signInButton2).perform();

        //kullanici my account butonuna tiklar
        Thread.sleep(2000);
        spendinGoodPage.anasayfadakiMyAccountButonu.click();

        //kullanici store manager butonuna tiklar
        spendinGoodPage.storeManager.click();
        Thread.sleep(2000);

        //kullanici dashborddan settings butonuna tiklar
         spendinGoodPage.dashboardSettings.click();


        //kullanici settings anabasliginin altindaki seceneklerden shipping buttonuna tiklar
        spendinGoodPage.settingButonunaTikladiktanSonraCikanShippingButonu.click();

        //kullanici processing time kismindan urun islem suresini secer
        Select select = new Select(spendinGoodPage.processingTimeOptions);
        select.selectByValue("3");

        //kullanici save butonuna tiklar
        ReusableMethods.waitFor(5);
        spendinGoodPage.saveButonu.click();


        //Settings saved successfully yazisinin ciktigini test eder
        ReusableMethods.waitFor(5);
        String actualYazi=spendinGoodPage.savedSuccessfullyYazisi.getText();
        Assert.assertEquals(actualYazi, "Settings saved successfully");

    }
}