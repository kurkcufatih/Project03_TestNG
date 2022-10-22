package tests.US_21;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.SpendinGoodPage;
import utilities.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TC_01 extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    SpendinGoodPage spendinggoodPage = new SpendinGoodPage();
    TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
    File source = ts.getScreenshotAs(OutputType.FILE);

    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("Anasayfa", "isim/ kullanıcı adi/ maili, adresi, Store Manager,  " +
                "Reports, Year, last month,this month,last 7 day,custom");
        //1- spendinggood.com  anasayfana git
        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        extentTest.info("Anasayfaya gittiğini dogrulandi");

        //2- Anasayfanin gorundugunu test eder
        Assert.assertTrue(spendinggoodPage.logo.isDisplayed());
        extentTest.info("Anasayfanin gorundugunu dogrulandi");

        //3- sign in botununa tikla
        spendinggoodPage.signIn.click();
        extentTest.info("sign in butonuna tiklandigi dogrulandi");

        //4- username gecerli email adresi gir
        spendinggoodPage.userNameEmail.sendKeys(ConfigReader.getProperty("mevlutEmail"));
        extentTest.info("Email adresi girildiginin dogrulandi");

        //5- password gecerli sifre gir
        spendinggoodPage.password.sendKeys(ConfigReader.getProperty("mevlutPassword"));
        extentTest.info("Password girildigini dogrulandi");

        //6- sign in botununa tik
        spendinggoodPage.signIn2.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(spendinggoodPage.signIn2));
        extentTest.info("sign in butonuna tiklandigi dogrulandi");


        //7- Hesabim butonunu tikla
        spendinggoodPage.myHesabim.click();
        extentTest.info("hesabim tiklandigi dogrulandi");

        //8- Vendor Store Manager tikla
        spendinggoodPage.storeManager.click();
        Thread.sleep(3000);
        extentTest.info("Store manager tiklandigi dogrulandi");

        //9- Vendor Reports tikla
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        spendinggoodPage.reports.click();
        extentTest.info("Reports tiklandigi dogrulandi");

        //10- Vendor yil (year) tikla
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        spendinggoodPage.year.click();
        extentTest.info("Year tiklandigi dogrulandi");

        //11- Vendor yil(Year) goruntule
        Assert.assertTrue(spendinggoodPage.year.isDisplayed());
        extentTest.info("Yillik raparlar gorundugunu dogrulandi");

        //12- Vendor Last month tikla
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        spendinggoodPage.lastMonth.click();
        extentTest.info("Last month  tiklandigi dogrulandi");

        //13- Vendor en son ay (Last Month) görüntüle
        Assert.assertTrue(spendinggoodPage.lastMonth.isDisplayed());
        extentTest.info("Last month  gorundugunu dogrulandi");

        //14- Vendor This Month tikla
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        spendinggoodPage.thisMonth.click();
        extentTest.info("This Month  tiklandigi dogrulandi");

        //15- Vendor  mevcut ay (This Month) görüntüle
        Assert.assertTrue(spendinggoodPage.thisMonth.isDisplayed());
        extentTest.info("This Month  gorundugunu dogrulandi");

        //16- Vendor  last 7 days tikla
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        spendinggoodPage.last7Days.click();

        //17- Vendor  son 7 gün raporunu(Last 7 Days) görüntüle
        Assert.assertTrue(spendinggoodPage.last7Days.isDisplayed());
        extentTest.info("Last 7 Days tiklandigi dogrulandi");

        //18- Vendor specific tarih araligini gir
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        spendinggoodPage.dateRange.click();
        actions.sendKeys("2022-10-14 to 2022-11-14").perform();
        extentTest.info("Specific bir Tarih araliginin  girildigini dogrulandi");

        //29- Vendor specific tarih araligini goruntule
        Assert.assertTrue(spendinggoodPage.dateRange.isDisplayed());
        extentTest.info("Specific tarih araliginin gorundugu dogrulandi");

        //20- closs tikla
        spendinggoodPage.closs.click();
        extentTest.info("closs tiklandigi dogrulandi");


        extentTest.pass("test01 PASS");

    }


}
