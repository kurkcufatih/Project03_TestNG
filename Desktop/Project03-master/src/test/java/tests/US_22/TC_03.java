package tests.US_22;;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
import java.io.File;
import java.io.IOException;

public class TC_03 extends TestBaseRapor {
    SpendinGoodPage spendinggoodPage = new SpendinGoodPage();
    TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
    File source = ts.getScreenshotAs(OutputType.FILE);

    @Test
    public void test03() throws InterruptedException, IOException {
        extentTest = extentReports.createTest("Anasayfa, tumunu gor link,ekran goruntusu ");
        // spendinggood.com  anasayfana gider
        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        extentTest.info("Spendinggood.com anasayfana gittiğini dogrulandi");

        // Anasayfanin gorundugunu test eder
        Assert.assertTrue(spendinggoodPage.logo.isDisplayed());
        extentTest.info("Anasayfanin gorundugunu dogrulandi");

        //  Fiyatlari  Düşükten yükseğe gore siralanabilmeli linkinin gorunurlugunu test eder
        String actual = Driver.getDriver().getPageSource();
        String expected = " Fiyat gore sirala dusukten yuksege ";
        Assert.assertFalse(actual.contains(expected));
        extentTest.info("İndirimli Ürünler siralanabilmeli linkin gorunmedigini dogrulandi");

        // Ekran goruntusu alir
        ReusableMethods.getScreenshot("İndirimli Ürünler  Linki");
        extentTest.info("Fiyat gore sirala dusukten yuksege linkinin gorulmedigi fotografi alinir");

        extentTest.fail("test03 FAILLED");

    }
}
