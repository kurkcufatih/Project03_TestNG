package tests.US_21;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;

public class US_21 {

    Actions actions = new Actions(Driver.getDriver());
    //  SpenddinggoodPage spenddinggoodPage = new SpenddinggoodPage();
    TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
    File source = ts.getScreenshotAs(OutputType.FILE);

    @Test
    public void test01() throws InterruptedException {


        // spendinggood.com  anasayfana gider
        Driver.getDriver().get(ConfigReader.getProperty("spendingUrl"));

        // Anasayfanin gorundugunu test eder
        //   Assert.assertTrue(spenddinggoodPage.logo.isDisplayed());

        // sign in botununa tiklar
        //  spenddinggoodPage.signIn.click();

        //username email adresi girer
        //  spenddinggoodPage.userNameEmail.sendKeys(ConfigReader.getProperty("spdUserName"));

        // password sifre girer
        //  spenddinggoodPage.password.sendKeys(ConfigReader.getProperty("paswordM"));
        Thread.sleep(3000);

        // sign in botununa tiklar
        // spenddinggoodPage.signIn2.click();
        Thread.sleep(3000);
        // hesabimi tiklandi
        // spenddinggoodPage.myHesabim.click();

        // storeManager tiklar
        //  spenddinggoodPage.storeManager.click();
        Thread.sleep(3000);

        // Reports tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        // spenddinggoodPage.reports.click();

        // Tarih araliginin gorunuyor oldugunu test eder
        // Assert.assertTrue(spenddinggoodPage.tarihAraligi.isDisplayed());

        //Yili tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        //  spenddinggoodPage.year.click();

        // last month tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        //  spenddinggoodPage.lastMonth.click();

        //thisMonth tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        //  spenddinggoodPage.thisMonth.click();

        // last 7 days tiklar

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        //  spenddinggoodPage.last7Days.click();

        // tarih araligina girer
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        //  spenddinggoodPage.dateRange.click();
        actions.sendKeys("2022-10-14 to 2022-11-14").perform();

        // sayfayi kapatir
        Driver.closeDriver();
    }
}