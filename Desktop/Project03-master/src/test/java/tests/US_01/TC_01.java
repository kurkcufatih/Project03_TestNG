package tests.US_01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class TC_01 {
    SpendinGoodPage spendinGoodPage = new SpendinGoodPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void OnayKoduGirme() throws InterruptedException {
        //Istenilen URL'ye gider
        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        Thread.sleep(1500);
        //Acilan sayfada signIn buttonunu tiklar
        spendinGoodPage.signIn.click();
        Thread.sleep(1500);
        //Acilan sayfada sign up buttonunu tiklar
        spendinGoodPage.SIGNUP.click();
        Thread.sleep(1500);
        //Acilan sayfada Become a Vendor'a tiklar
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        //Sayfada Email, Password, ConfirmPassword girilme kisimlarinin gorunur oldugunu test eder
        Assert.assertTrue(spendinGoodPage.UcEmailPasswordConfirmPassword.isDisplayed());
        Thread.sleep(1500);
        //Email kismina click yapar
        spendinGoodPage.Email.click();
        Thread.sleep(1500);
        actions.sendKeys("ceyhanbulent@gmail.com").sendKeys(Keys.TAB).
                sendKeys("123456").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("ceycey1505").sendKeys(Keys.TAB).
                sendKeys("ceycey1505").sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
        //Girilen mail adresinin uniq olduguna bakilir
        spendinGoodPage.UniqOlmayanYazisi.isDisplayed();
        //Sayfayi yeniler
        Driver.getDriver().navigate().refresh();
        Thread.sleep(2000);
        //Email ve onay kodu icin yeni bir sayfa acip "https://www.mohmal.com/tr/inbox" adresinden mail ve codu alip getirir
        //Yeni bir sekme acilir
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        //"https://www.mohmal.com/tr/inbox" adresine gidilir
        Driver.getDriver().get("https://www.mohmal.com/tr/inbox");
        Thread.sleep(1500);
        //Acilan sayfadaki email adresini getirip yazdirir
        List<String> windowList = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowList.get(1));
        Thread.sleep(1500);
        String email = spendinGoodPage.geciciEmail.getText();
        System.out.println(email);
        //Tekrar "https://www.mohmal.com/tr/inbox" adresine gider
        Driver.getDriver().switchTo().window(windowList.get(0));
        spendinGoodPage.Email.sendKeys(email);
        Thread.sleep(1500);
        Driver.getDriver().switchTo().window(windowList.get(1));
        Thread.sleep(4000);
        //YenilemeTusuna click yapar
        spendinGoodPage.yenilemeTusu.click();
        Thread.sleep(1500);
        //Cikan reklami kapatir
        Driver.getDriver().navigate().refresh();
        //Maile gelen kismina tiklar
        spendinGoodPage.geciciEmailBox.click();
        //Acilan sayfada iframe oldugu icin methodu oluşturulur
        WebElement iframe = Driver.getDriver().findElement(By.cssSelector("div>#read>div>iframe")); //iframe gir
        Driver.getDriver().switchTo().frame(iframe);
        Thread.sleep(1500);
        //maile gelen kodu alip getirir
        int code = Integer.parseInt(spendinGoodPage.verificationCode.getText().replaceAll("\\D", ""));
        String code2 = String.valueOf(code);
        //iframe den cikis yapar
        Driver.getDriver().switchTo().defaultContent(); //iframe den cikis
        Driver.getDriver().switchTo().window(windowList.get(0));
        Thread.sleep(1000);
        spendinGoodPage.VerificationCodeBox.sendKeys(code2);
        Thread.sleep(1000);
        //Password olusturur
        spendinGoodPage.Password.sendKeys("ceycey1505");
        Thread.sleep(1000);
        //Ayni pasword tekrar girilir
        spendinGoodPage.ConfirmPassword.sendKeys("ceycey1505");
        Thread.sleep(1000);
        //RegisterButtonuna tiklar
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
        //Siteye kayit yaptigini doğrular
        spendinGoodPage.MyAccount.isDisplayed();
        //sayfayi kapatir
        Thread.sleep(2000);
        Driver.closeDriver();

    }
}