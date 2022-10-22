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

public class TC01_PozitifTest {
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void US008_StockAndOrderManagement_PozitifTest() throws InterruptedException, IOException {
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
        Thread.sleep(2000);

        //kullanici dasboard kismindan products butonuna tiklar
        Thread.sleep(2000);
        spendinGoodPage.storageManagerButonunaTikladiktanSonraCikanProductButtonu.click();

        //kullanici stock miktarini degistirecegi urun uzerindeki edit buttonuna tiklar
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN);
        spendinGoodPage.urunUzerindekiEditButonu.click();

        //kullanici Stock Qty kismina urun miktarini girer
        spendinGoodPage.stockQty.clear();
        spendinGoodPage.stockQty.sendKeys("10");

        //kullanici  allow backorders seceneklerinden "do not allow, allow but notify costumer, veya allow" secenegini secer.
        Select select = new Select(spendinGoodPage.allowBackorders);
        select.selectByIndex(1);

        //kullanici submit butonuna tiklar
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", spendinGoodPage.editProductKismindakisubmitButonu);
        jse.executeScript("arguments[0].click();", spendinGoodPage.editProductKismindakisubmitButonu);
        actions.sendKeys(Keys.ENTER).perform();

        //kullanici Product Successfully Published yazisini test eder
        String yazi = "Product Successfully Published";
        Assert.assertFalse(spendinGoodPage.notifikasyonMesajlari.contains(yazi));
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15));

        //kullanici view butonuna tiklar
        actions.moveToElement(spendinGoodPage.editProductKismindakiViewButonu);
        spendinGoodPage.editProductKismindakiViewButonu.click();

        //kullanici stock miktari ile girdigi stock miktarinin uyumlulugunu test eder.
        String actualStoclMiktari = spendinGoodPage.mevcutStockMiktari.getText();
        String expectedStockMiktari = String.valueOf(10);
        Assert.assertTrue(actualStoclMiktari.contains(expectedStockMiktari));

        //kullanici stock miktarinin goruntusunu alir.
        ReusableMethods.getScreenshot(spendinGoodPage.mevcutStockMiktari.getText());
    }
}

