package tests.US_17;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US17_TC01 extends TestBaseRapor {
    page.SpendinGoodPage spendinggoodPage = new page.SpendinGoodPage();
    static String adress1="Adress 1";
    static String adress2="Adres2";
    // Billing address; isim, soy isim, şirket ismi, tel, adres1 ve adres iki (optional), ülke, sehir, posta kodu
    @Test
    public void kayitliKisiMailAdresHarcamaSonsiparis() {
        extentTest = extentReports.createTest("Manage customers", "kayitli kisilerin isim/ kullanıcı adi/ emaili, adresi, harcama miktarı, son siparişleri görüldüğü doğrulandı.");
        //Kullanici url e gider
        Driver.getDriver().get(ConfigReader.getProperty("spendinggoodUrl"));
        extentTest.info("Spendinggood url'e gidildi.");
        //Sign in e tıklar
        spendinggoodPage.signInButton.click();
        //Email adresini girer
        spendinggoodPage.emailAdresBox.sendKeys(ConfigReader.getProperty("Email"));
        //Password girer
        spendinggoodPage.passwordBox.sendKeys(ConfigReader.getProperty("Password"));
        //Sign in butonuna tıklar
        spendinggoodPage.signInButton2.click();
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici girisi yapildi.");
        //My Account icinde Store Manager bölümüne girer
        spendinggoodPage.myAccountButton.click();
        spendinggoodPage.storeManager.click();
        ReusableMethods.waitFor(2);
        //Ardından Customers bölümüne girer
        ReusableMethods.jsExecutorScrool(spendinggoodPage.customers);
        ReusableMethods.jsExecutorClick(spendinggoodPage.customers);
        //Tablodaki Actions sutunundaki Edit Customer butonuna tıklar
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPage.editCustomerButton.click();
        //Add New butonuna tıklar
        spendinggoodPage.addNewButton.click();
        //Username girer
        Faker faker = new Faker();
        spendinggoodPage.usenameBox.sendKeys(faker.name().name());
        extentTest.info("Username girildi.");
        //Mail girer
        spendinggoodPage.emailBox.sendKeys(faker.internet().emailAddress());
        extentTest.info("mail girildi.");
        //Billing bölümüne inip, First Name girer
        spendinggoodPage.firstnameBox.sendKeys(faker.name().firstName());
        extentTest.info("Firstname girildi.");
        //Last Name girer
        spendinggoodPage.lastnameBox.sendKeys(faker.name().lastName());
        extentTest.info("Lastname girildi.");
        //Company Name girer
        ReusableMethods.jsExecutorScrool(spendinggoodPage.companynameBox);
        spendinggoodPage.companynameBox.sendKeys(faker.company().name());
        extentTest.info("Company name girildi.");
        //Phone girer
        spendinggoodPage.phoneBox.sendKeys(faker.phoneNumber().phoneNumber());
        extentTest.info("Phone girildi.");
        //Adress 1 girer
        spendinggoodPage.adress1Box.sendKeys(adress1);
        extentTest.info("Adress 1 girildi.");
        //Adress 2 girer
        spendinggoodPage.adress2Box.sendKeys(adress2);
        extentTest.info("Adress 2 girildi.");
        //Country girer
        Select select=new Select(spendinggoodPage.country);
        select.selectByIndex(3);
        extentTest.info("Country seçildi.");
        //City/Town girer
        spendinggoodPage.cityTown.sendKeys("City/Town");
        extentTest.info("cityTown girildi.");
        //State/Country girer
        select=new Select(spendinggoodPage.stateCountry);
        select.selectByIndex(2);
        extentTest.info("State/Country seçildi.");
        //Postcode/Zip girer
        spendinggoodPage.postcodeZip.sendKeys(faker.idNumber().invalid());
        extentTest.info("Postcode/Zip girildi.");
        //Submit butonu tıklar ,"Customer Succesfully Saved" yazısını doğrular
        ReusableMethods.jsExecutorScrool(spendinggoodPage.addCustomerSubmitbutton);
        spendinggoodPage.addCustomerSubmitbutton.click();
        Assert.assertTrue(spendinggoodPage.basariliGirisYazisi.isDisplayed(), "basarili giris yazisi gorunmuyor!");
        extentTest.info("\"Customer Succesfully Saved\" yazısı doğrulandi");
        //Sayfayı kapatır
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
        extentTest.pass(" PASS");

    }

}

