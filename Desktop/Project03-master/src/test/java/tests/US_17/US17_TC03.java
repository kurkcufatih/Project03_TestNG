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

public class US17_TC03 extends TestBaseRapor {
    page.SpendinGoodPage spendinggoodPage = new page.SpendinGoodPage();
    // Shipping address; yukaridaki adresleri farklı olarak ekleyebilirler


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
        //Herhangi bir kullanıcının actions kısmında bulunan edit customer ikonunu tıklar
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
        spendinggoodPage.adress1Box.sendKeys("Adres1");
        extentTest.info("Adress 1 girildi.");
        //Adress 2 girer
        spendinggoodPage.adress2Box.sendKeys("Adres2");
        extentTest.info("Adress 2 girildi.");
        //Country girer
        Select select = new Select(spendinggoodPage.country);
        select.selectByIndex(3);
        extentTest.info("Country seçildi.");
        //City/Town girer
        spendinggoodPage.cityTown.sendKeys("City/Town");
        extentTest.info("CityTown girildi.");
        //State/Country secer
        select = new Select(spendinggoodPage.stateCountry);
        select.selectByIndex(2);
        extentTest.info("State/Country seçildi.");
        //Postcode/Zip girer
        spendinggoodPage.postcodeZip.sendKeys(faker.idNumber().invalid());
        extentTest.info("Postcode/Zip girildi.");
        //Same as Billing  tıklar
        ReusableMethods.waitFor(3);
        spendinggoodPage.sameAsBillingCheckbox.click();
        //Adress 1'e daha once girilmis olandan farklı adres girer
        spendinggoodPage.shippingAdress1.sendKeys("Adres3");
        extentTest.info("******Adress 1'e daha once girilmis olandan farklı adres girildi.******");
        //Adress 2'e daha once girilmis olandan farklı adres girer
        spendinggoodPage.shippingAdress2.sendKeys("Adres4");
        extentTest.info("******Adress 2'e daha once girilmis olandan farklı adres girildi.******");
        //Country'e daha once girilmis olandan farklı deger girer
        select=new Select(spendinggoodPage.shippingCountryC);
        extentTest.info("******Country'e daha once girilmis olandan farklı deger girildi.******");
        select.selectByIndex(5);
        //City/Town'e daha once girilmis olandan farklı deger girilir
        spendinggoodPage.shippingCityTown.sendKeys("City/Town2");
        extentTest.info("******CityTown'a daha once girilmis olandan farklı değer girildi.******");
        //State/Country'e daha once secilmis olandan farklı değer secer
        spendinggoodPage.shippingStateCountry.sendKeys("State/Country5");
        extentTest.info("******State/Country'de daha once secilmis olandan farklı değer seçildi.******");
        //submit botona tıklar ve "Customer Succesfully Saved" yazısını doğrular
        ReusableMethods.jsExecutorScrool(spendinggoodPage.addCustomerSubmitbutton);
        ReusableMethods.waitFor(3);
        spendinggoodPage.addCustomerSubmitbutton.click();
        Assert.assertTrue(spendinggoodPage.basariliGirisYazisi.isDisplayed(), "basarili giris yazisi gorunmuyor!");
        extentTest.info("\"Customer Succesfully Saved\" yazısı doğrulandi");
        //Sayfayı kapatır
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
        extentTest.pass("Farklı adres testi PASS");
    }
}