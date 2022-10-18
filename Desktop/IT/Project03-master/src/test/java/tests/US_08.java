package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_08 {
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void US008_StockAndOrderManagement_PozitifTest() throws InterruptedException {
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
        spendinGoodPage.urunUzerindekiEditButonu.click();

        //kullanici Stock Qty kismina urun miktarini girer

        //kullanici  allow backorders seceneklerinden "do not allow, allow but notify costumer, veya allow" secenegini secer.
        //kullanici submit butonuna tiklar
        //kullanici Product Successfully Published yazisini test eder
        //kullanici view butonuna tiklar
        //kullanici stock miktari ile girdigi stock miktarinin uyumlulugunu test eder.
        //kullanici stock miktarinin goruntusunu alir.

    }
}
