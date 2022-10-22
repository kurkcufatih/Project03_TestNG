package tests.US_22;

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

public class TC_02 extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    SpendinGoodPage spendinggoodPage = new SpendinGoodPage();
    TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
    File source = ts.getScreenshotAs(OutputType.FILE);

    @Test
    public void test02() throws InterruptedException, IOException {
        extentTest = extentReports.createTest("Anasayfa, tumunu gor link,ekran goruntusu ");
        // spendinggood.com  anasayfana git
        Driver.getDriver().get(ConfigReader.getProperty("spendingUrl"));
        extentTest.info("Spendinggood.com anasayfana gittiğini dogrulandi");

        // Anasayfanin gorundugunu test et
        Assert.assertTrue(spendinggoodPage.logo.isDisplayed());
        extentTest.info("Anasayfanin gorundugunu dogrulandi");

        // Tumunu gor linkinin gorunurlugunu test et
        String actual = Driver.getDriver().getPageSource();
        String expected = "Tumunu gor linki";
        Assert.assertFalse(actual.contains(expected));
        extentTest.info("Tumunu gor linkin gorunmedigini dogrulandi");

        // Ekran goruntusu al
        ReusableMethods.getScreenshot("Tumunu Gor Linki");
        extentTest.info("Tumunu gor linkinin gorulmedigi fotografi alinir");
        extentTest.fail("test02 FAILLED");

    }
}
