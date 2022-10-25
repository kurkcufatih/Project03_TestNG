package tests.US_07;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_004 {

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
    //Store Manager "Product brands" bolumunu gorur
    //Store Manager "NS8" markasini secer
    //Store Manager "NS8" markasinin secildigini gorur

    @Test
    public void TC_004() {

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
        js.executeScript("arguments[0].scrollIntoView(true);", SpendinGoodPage.Products);
        js.executeScript("arguments[0].click();", SpendinGoodPage.Products);
        js.executeScript("arguments[0].scrollIntoView(true);", SpendinGoodPage.addNew);
        js.executeScript("arguments[0].click();", SpendinGoodPage.addNew);
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(SpendinGoodPage.ProductBrandsGorunur.isDisplayed());

        js.executeScript("arguments[0].scrollIntoView(true);", SpendinGoodPage.NS8);
        js.executeScript("arguments[0].click();", SpendinGoodPage.NS8);
        Assert.assertTrue(SpendinGoodPage.NS8.isEnabled());

    }
}
