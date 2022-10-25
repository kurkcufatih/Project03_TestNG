package tests.US_06;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_001 {

    //Store Manager url adresine gider
    //Store Manager My Account'a tiklar
    //Store Manager Username or email address kutusuna tiklar
    //Store Manager Gecerli bir username veya email adresi yazar
    //Store Manager Password kutusuna tiklar
    //Store Manager Gecerli bir password girer
    //Store Manager Sign in butonuna tiklar
    //Store Manager, Store Manager seceneğini tiklar
    //Store Manager Products seceneğini tiklar
    //Store Manager Add New'e tiklar
    //Store Manager "Categories" bolumunu gorur
    //Store Manager "Vitamin" kategorisini secer
    //Store Manager "Vitamin" kategorisinin secildigini gorur


    @Test
    public void TC_001() {

        SpendinGoodPage SpendinGoodPage = new SpendinGoodPage();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        SpendinGoodPage.myAccount.click();
        js.executeScript("arguments[0].click();", SpendinGoodPage.SignIn);
        SpendinGoodPage.username.click();
        SpendinGoodPage.username.sendKeys(ConfigReader.getProperty("haticeEmail"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        SpendinGoodPage.Password.click();
        SpendinGoodPage.Password.sendKeys(ConfigReader.getProperty("haticePassword"));
        actions.sendKeys(Keys.ENTER).perform();
        js.executeScript("arguments[0].click();", SpendinGoodPage.StoreManager);
        SpendinGoodPage.StoreManager.click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        SpendinGoodPage.Products.click();
        js.executeScript("arguments[0].scrollIntoView(true);", SpendinGoodPage.addNew);
        SpendinGoodPage.addNew.click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(SpendinGoodPage.categoriesGorunur.isDisplayed());

        js.executeScript("arguments[0].scrollIntoView(true);", SpendinGoodPage.healtBeauty);
        js.executeScript("arguments[0].click();", SpendinGoodPage.healtBeauty);

        js.executeScript("arguments[0].scrollIntoView(true);", SpendinGoodPage.vitamin);
        js.executeScript("arguments[0].click();", SpendinGoodPage.vitamin);
        Assert.assertTrue(SpendinGoodPage.vitamin.isEnabled());


    }
}