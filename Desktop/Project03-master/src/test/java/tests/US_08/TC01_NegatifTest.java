package tests.US_08;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TC01_NegatifTest {

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void US08_TC01_StockAndOrderManagement_NegatifTest() throws InterruptedException, IOException {
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

        //kullanici dasboard kismindan products butonuna tiklar
        ReusableMethods.waitFor(3);
        JavascriptExecutor jseProduct = (JavascriptExecutor) Driver.getDriver();
        jseProduct.executeScript("arguments[0].scrollIntoView(true);", spendinGoodPage.storageManagerButonunaTikladiktanSonraCikanProductButtonu);
        jseProduct.executeScript("arguments[0].click();", spendinGoodPage.storageManagerButonunaTikladiktanSonraCikanProductButtonu);
        spendinGoodPage.storageManagerButonunaTikladiktanSonraCikanProductButtonu.click();

        //kullanici stock miktarini degistirecegi urun uzerindeki edit buttonuna tiklar
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN);
        spendinGoodPage.urunUzerindekiEditButonu.click();

        //kullanici Stock Qty kismina urun miktarini girer
        spendinGoodPage.stockQty.clear();
        spendinGoodPage.stockQty.sendKeys("@");

        //kullanici  allow backorders seceneklerinden "do not allow, allow but notify costumer, veya allow" secenegini secer.
        Select select = new Select(spendinGoodPage.allowBackorders);
        select.selectByIndex(1);

        //kullanici submit butonuna tiklar
        JavascriptExecutor jseSubmit = (JavascriptExecutor) Driver.getDriver();
        jseSubmit.executeScript("arguments[0].scrollIntoView(true);", spendinGoodPage.editProductKismindakisubmitButonu);
        jseSubmit.executeScript("arguments[0].click();", spendinGoodPage.editProductKismindakisubmitButonu);

        //kullanici Product Successfully Published yazisini test eder
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(spendinGoodPage.successfullyPublishedYazisi));
        Assert.assertTrue(spendinGoodPage.successfullyPublishedYazisi.isDisplayed());

        //kullanici view butonuna tiklar
        JavascriptExecutor jseView = (JavascriptExecutor) Driver.getDriver();
        jseView.executeScript("arguments[0].scrollIntoView(true);", spendinGoodPage.editProductKismindakiViewButonu);
        jseView.executeScript("arguments[0].click();", spendinGoodPage.editProductKismindakiViewButonu);

        //kullanici stock miktari ile girdigi stock miktarinin uyumlulugunu test eder.
        List<String> handelsList = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(handelsList.get(1));
        ReusableMethods.waitFor(3);
        String expectedStockMiktari = "Available on backorder";
        Assert.assertEquals(spendinGoodPage.getMevcutStockMiktariNegatifTest.getText(), expectedStockMiktari);

        //kullanici stock miktarinin goruntusunu alir.
        ReusableMethods.getScreenshot(spendinGoodPage.getMevcutStockMiktariNegatifTest.getText());
    }
}

