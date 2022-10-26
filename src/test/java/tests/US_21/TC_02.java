package tests.US_21;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.*;

import java.io.File;
import java.time.Duration;

public class TC_02 extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    SpendinGoodPage spendinggoodPage = new SpendinGoodPage();
    TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
    File source = ts.getScreenshotAs(OutputType.FILE);

    @Test
    public void test02() throws InterruptedException {
        extentTest = extentReports.createTest("Anasayfa", "isim/ kullanıcı adi/ maili, adresi, Store Manager,  " +
                "Reports, Year, last month,this month,last 7 day,custom");
        //1- spendinggood.com  anasayfana git
        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        extentTest.info("Anasayfaya gittiğini dogrulandi");

        //2- Anasayfanin gorundugunu test eder
        Assert.assertTrue(spendinggoodPage.logo.isDisplayed());
        extentTest.info("Anasayfanin gorundugunu dogrulandi");

        //3- sign in botununa tiklar
        spendinggoodPage.signIn.click();
        extentTest.info("sign in butonuna tiklandigi dogrulandi");

        //4- username gecerli email adresi girer
        spendinggoodPage.userNameEmail.sendKeys(ConfigReader.getProperty("mevlutEmail"));
        extentTest.info("Email adresi girildiginin dogrulandi");

        //5- password gecerli sifre girer
        spendinggoodPage.password.sendKeys(ConfigReader.getProperty("mevlutPassword"));
        extentTest.info("Password girildigini dogrulandi");

        //6- sign in botununa tiklar
        spendinggoodPage.signIn2.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(spendinggoodPage.signIn2));
        extentTest.info("sign in butonuna tiklandigi dogrulandi");


        //7- Hesabim butonunu tiklar
        spendinggoodPage.myHesabim.click();
        extentTest.info("hesabim tiklandigi dogrulandi");

        //8- Vendor Store Manager tiklar
        spendinggoodPage.storeManager.click();
        Thread.sleep(3000);
        extentTest.info("Store manager tiklandigi dogrulandi");

        //9- Vendor Reports tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        spendinggoodPage.reports.click();
        extentTest.info("Reports tiklandigi dogrulandi");

        //10- Vendor specific tarih araligini girer
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        spendinggoodPage.dateRange.click();
        actions.sendKeys("2022-10-14 to 2022-11-14").perform();
        extentTest.info("Specific bir Tarih araliginin  girildigini dogrulandi");

        //11- Vendor specific tarih araligini goruntuler
        Assert.assertTrue(spendinggoodPage.dateRange.isDisplayed());
        extentTest.info("Specific tarih araliginin gorundugu dogrulandi");

        //12- closs tiklar
        spendinggoodPage.closs.click();
        extentTest.info("closs tiklandigi dogrulandi");


        extentTest.pass("test02 PASS");

    }


}
