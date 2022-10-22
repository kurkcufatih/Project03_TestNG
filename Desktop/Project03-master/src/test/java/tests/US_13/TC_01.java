package tests.US_13;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC_01 extends TestBaseRapor {
public SpendinGoodPage spendinGoodPage;
public Actions actions = new Actions(Driver.getDriver());
public Select select;



    @Test
    public void TC001() {
        spendinGoodPage = new SpendinGoodPage();
        extentTest = extentReports.createTest("Kupon Olusturma Testi", "kupon olusturabilme");
        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        extentTest.info("Spendinggood Sitesine Gidildi");
        spendinGoodPage.signInButton.click();
        extentTest.info("Sign In Butonuna Tiklandi");
        spendinGoodPage.emailAdresBox.sendKeys(ConfigReader.getProperty("berkEmail"));
        spendinGoodPage.passwordBox.sendKeys(ConfigReader.getProperty("berkPassword"));
        spendinGoodPage.signInButton2.click();
        extentTest.info("Giris yapildi");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(spendinGoodPage.signInButton2));
        ReusableMethods.jsExecutorClick(spendinGoodPage.myAccount);
        extentTest.info("MyAccount'a tiklandi");
        ReusableMethods.jsExecutorScrool(spendinGoodPage.storeManagerButton);
        ReusableMethods.jsExecutorClick(spendinGoodPage.storeManagerButton);
        extentTest.info("StoreManager'a tiklandi");
        ReusableMethods.jsExecutorScrool(spendinGoodPage.couponButton);
        ReusableMethods.jsExecutorClick(spendinGoodPage.couponButton);
        extentTest.info("Coupon Button'a tiklandi");
        ReusableMethods.jsExecutorScrool(spendinGoodPage.couponAddNewButton);
        ReusableMethods.jsExecutorClick(spendinGoodPage.couponAddNewButton);
        extentTest.info("Add new butonuna tiklandi");
        spendinGoodPage.codeText.sendKeys("FreeShop");
        extentTest.pass("Code Text Box'a girildi");
    }
    @Test(dependsOnMethods = "TC001")
    public void TC002() {
        spendinGoodPage.descriptionText.sendKeys("Firsat Urunu");
        extentTest.pass("Description Text Box'a Tanimlama yapildi");
    }
    @Test(dependsOnMethods = "TC002")
    public void TC003() {
        select = new Select(spendinGoodPage.discountType);
        select.selectByIndex(1);
        extentTest.pass("Discount Typed'a indirim secenegi secildi");
    }
    @Test(dependsOnMethods = "TC003")
    public void TC004() {
        spendinGoodPage.couponAmount.clear();
        spendinGoodPage.couponAmount.sendKeys("10");
        extentTest.pass("Coupon Amount'a kupon miktari girildi");
    }
    @Test(dependsOnMethods = "TC004")
    public void TC005() {
        spendinGoodPage.couponExpiryDate.sendKeys("2022-12-02");
        extentTest.pass("Coupon expiry date'e kuponun gecerlilik tarihi girildi");
    }
    @Test(dependsOnMethods = "TC005")
    public void TC006() {
        ReusableMethods.jsExecutorScrool(spendinGoodPage.allowFreeShipping);
        ReusableMethods.jsExecutorClick(spendinGoodPage.allowFreeShipping);
        extentTest.pass("Allow free shipping tiklandi");
    }
    @Test(dependsOnMethods = "TC006")
    public void TC007() {
        ReusableMethods.jsExecutorScrool(spendinGoodPage.showOnStore);
        ReusableMethods.jsExecutorClick(spendinGoodPage.showOnStore);
        extentTest.pass("Show on store tiklandi");
    }
    }

