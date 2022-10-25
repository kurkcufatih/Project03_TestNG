package tests.US_05;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_005 {

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
    //Store Manager Short Description kismina bilgi girer
    //Store Manager Description kismina bilgi girer


    @Test
    public void TC_005() {

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

        //ReusableMethods.jsExecutorScrool(SpendinGoodPage.body);
        //ReusableMethods.jsExecutorClick(SpendinGoodPage.shortDescription);
        //js.executeScript("arguments[0].scrollIntoView(true);", SpendinGoodPage.body);
       // js.executeScript("arguments[0].scrollIntoView(true);", SpendinGoodPage.body);
        //SpendinGoodPage.shortDescription.sendKeys(ConfigReader.getProperty("shortDescription"));
        WebElement frame = Driver.getDriver().findElement(By.xpath("//iframe[@id='excerpt_ifr']"));
        frame.click();

        Driver.getDriver().switchTo().frame(frame);
        WebElement text = Driver.getDriver().findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        text.sendKeys(ConfigReader.getProperty("shortDescription"));
        Driver.getDriver().switchTo().defaultContent();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.waitFor(3);
        WebElement frame2 = Driver.getDriver().findElement(By.xpath("//iframe[@id='description_ifr']"));
        js.executeScript("arguments[0].click();",frame2);


        Driver.getDriver().switchTo().frame(frame2);
        WebElement text2 = Driver.getDriver().findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        text2.sendKeys(ConfigReader.getProperty("Description"));
        ReusableMethods.waitFor(2);

    }
}