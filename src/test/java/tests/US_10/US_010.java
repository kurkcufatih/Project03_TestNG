package tests.US_10;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

public class US_010 extends TestBaseRapor {
    SpendinGoodPage spendingGoodPage=new SpendinGoodPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void TC001(){


        extentTest = extentReports.createTest("Siparis Ozellikler Testi", "siparis ozelliklerini olusturabilme");
        //1 vendor url ye gider
        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        extentTest.info("Spendinggood Sitesine Gidildi");

        //2 vendor sayfadan sign in yazisina tiklar
        spendingGoodPage.signInButton.click();
        extentTest.info("Sign In Butonuna Tiklandi");

        //3 vendor valid username girer
        spendingGoodPage.emailAdresBox.sendKeys(ConfigReader.getProperty("MuhammedEmail"));

        //4 vendor valid Password girer
        spendingGoodPage.passwordBox.sendKeys(ConfigReader.getProperty("MuhammedPassword"));

        //5.vendor sign In tıklar
        spendingGoodPage.signInButton2.click();
        extentTest.info("Giris yapildi");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(spendingGoodPage.signInButton2));

        //6.vendor My Account yazisina tiklar
        ReusableMethods.jsExecutorClick(spendingGoodPage.myAccountButton);
        extentTest.info("MyAccount'a tiklandi");

        //7.vendor  store Manager yazısını tıklar
        ReusableMethods.jsExecutorScrool(spendingGoodPage.storeManager);
        ReusableMethods.jsExecutorClick(spendingGoodPage.storeManager);

        //8.vendor Product yazisina tiklar
        ReusableMethods.jsExecutorScrool(spendingGoodPage.product);
        ReusableMethods.jsExecutorClick(spendingGoodPage.product);
        // WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        // wait.until(ExpectedConditions.invisibilityOf(spendingGoodPage.product));

        //9.vendor Product bolumunde urunun uzerine gelip Edit'e tiklar
        ReusableMethods.jsExecutorScrool(spendingGoodPage.product_edit);
        ReusableMethods.jsExecutorClick(spendingGoodPage.product_edit);

        //10.vendor Attributes bolumune tiklar
        ReusableMethods.jsExecutorScrool(spendingGoodPage.product_attribute_ToggleBlock);
        ReusableMethods.jsExecutorClick(spendingGoodPage.product_attribute_ToggleBlock);


        //11.vendor Color bolumunde Select All yazisina tiklar ve tum renk seceneklerini belirtir
        ReusableMethods.jsExecutorScrool(spendingGoodPage.product_attribute_SelectAll);
        ReusableMethods.jsExecutorClick(spendingGoodPage.product_attribute_SelectAll);

        //12.vendor submit yazisina tiklar
        ReusableMethods.jsExecutorScrool(spendingGoodPage.product_attribute_SelectAll_SubmitButton);
        ReusableMethods.jsExecutorClick(spendingGoodPage.product_attribute_SelectAll_SubmitButton);




    }
    @Test (dependsOnMethods = "TC001")
    public void TC002(){



        //11.vendor Size bolumunde Select All yazisina tiklar ve tum beden seceneklerini belirtir
        ReusableMethods.jsExecutorScrool(spendingGoodPage.product_attribute_ToggleBlockSize);
        ReusableMethods.jsExecutorClick(spendingGoodPage.product_attribute_ToggleBlockSize);

        //12.vendor submit yazisina tiklar
        ReusableMethods.jsExecutorScrool(spendingGoodPage.product_attribute_SelectAll_SubmitButton);
        ReusableMethods.jsExecutorClick(spendingGoodPage.product_attribute_SelectAll_SubmitButton);




    }



}
