package tests.US_03;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class US03_son extends TestBaseRapor {
    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());
    SpendinGoodPage spendinGoodPage = new SpendinGoodPage();

    @Test
    public void us_003Test01() {
        extentTest = extentReports.createTest("Orders da Browse products/Go Shop a gidilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        extentTest.info("Spendinggood Sitesine Gidildi");

        spendinGoodPage.signInButton.click();
        extentTest.info("Sign in butonuna tiklandi");

        spendinGoodPage.emailAdresBox.sendKeys(ConfigReader.getProperty("tubaEmail"));
        extentTest.info("Username olarak gecerli bir email adresi girildi");

        spendinGoodPage.passwordBox.sendKeys(ConfigReader.getProperty("tubaPassword"));
        extentTest.info("Gecerli bir password girildi");

        spendinGoodPage.signInButton2.click();
        ReusableMethods.waitFor(3);
        extentTest.info("Sign in butonuna tiklandi");

        spendinGoodPage.myAccountButton.click();
        extentTest.info("My Account a tiklandi");
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        spendinGoodPage.orderss.click();
        extentTest.info("Orders'a tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);

        spendinGoodPage.goShop.click();
        extentTest.info("Orders sayfasinda browse products/go shop a tiklandi");
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.pass("Orders sayfasında Browse Products/Go Shop a tiklandi");
    }

    @Test(dependsOnMethods = "us_003Test01")
    public void us_003Test02() {
        extentTest = extentReports.createTest("5 adet urun secme ve secilen urunleri tek tek sepete ekleyebilmeli");
        List<WebElement> addCartButonList = spendinGoodPage.miniAddToCartButon;
        List<WebElement> urunListesi = spendinGoodPage.UrunListesi;

        int sepet = 0;
        for (int i = 0; i < urunListesi.size(); i++) {
            ReusableMethods.jsExecutorScrool(urunListesi.get(i));
            ReusableMethods.waitFor(2);
            actions.moveToElement(urunListesi.get(i)).perform();
            if (addCartButonList.get(i).isEnabled()) {
                ReusableMethods.jsExecutorClick(addCartButonList.get(i));
                sepet++;

            }
            ReusableMethods.waitFor(2);
            if (sepet == 5) {
                break;
            }
        }
            extentTest.pass("5 adet urun secildi ve secilen urunler tek tek sepete eklendi");
        }

        @Test(dependsOnMethods = "us_003Test02")
        public void us_003Test03() {
            extentTest = extentReports.createTest("Sepete ve sonrasında checkout a gidilmeli");
            ReusableMethods.waitFor(3);
            actions.sendKeys(Keys.PAGE_UP).perform();
            ReusableMethods.waitFor(3);
            ReusableMethods.jsExecutorClick(spendinGoodPage.cart);
            extentTest.info("Sepete gidildi");
            spendinGoodPage.buttonCheckout.click();
            extentTest.pass("Sepete gidildi ve checkout butonu tiklandi");
        }

            @Test(dependsOnMethods = "us_003Test03")
            public void us_003Test04() {
            extentTest = extentReports.createTest("Adres bilgilerini girebilmeli");
            ReusableMethods.waitForClickablility(spendinGoodPage.billingDetailsfirstName, 15);
            ReusableMethods.jsExecutorScrool(spendinGoodPage.billingDetailsfirstName);
            spendinGoodPage.billingDetailsfirstName.clear();
            ReusableMethods.waitFor(2);

            actions.click(spendinGoodPage.billingDetailsfirstName).sendKeys(faker.name().firstName())
                    .sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                    .sendKeys(faker.company().name()).sendKeys(Keys.TAB).sendKeys("Turkey")
                    .sendKeys(Keys.ENTER).perform();
            ReusableMethods.waitFor(2);
            ReusableMethods.jsExecutorScrool(spendinGoodPage.billingDetailsstreetAddress);
            ReusableMethods.jsExecutorClick(spendinGoodPage.billingDetailsstreetAddress);
            spendinGoodPage.billingDetailsstreetAddress.clear();
            ReusableMethods.waitFor(2);
            actions.click(spendinGoodPage.billingDetailsstreetAddress).sendKeys(faker.address().streetAddress())
                    .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                    .sendKeys(faker.address().cityName()).sendKeys(Keys.TAB).sendKeys("Antalya", Keys.ENTER)
                    .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                    .sendKeys("tubaktas@gmail.com").perform();

            extentTest.pass("Adres bilgileri girildi");
    }

            @Test(dependsOnMethods = "us_003Test04")
            public void us_003Test05() {
            extentTest = extentReports.createTest("Your Order bolumunde Payment Methods'u seçmeli ve Place Order'a tıklanabilmeli ");
            ReusableMethods.waitFor(2);
            ReusableMethods.jsExecutorClick(spendinGoodPage.payAtTheDoorRadioButon);
            extentTest.info("Payments Methods seçildi");
            ReusableMethods.jsExecutorClick(spendinGoodPage.placeOrderButon);
            extentTest.info("Place Order tiklandi");
            ReusableMethods.waitForVisibility(spendinGoodPage.orderCompletedText, 15);
            String expectedText = "Thank you. Your order has been received.";
            String actualText = spendinGoodPage.orderCompletedText.getText();
            System.out.println("actualText = " + actualText);
            Assert.assertTrue(spendinGoodPage.orderCompletedText.isDisplayed());
            extentTest.pass("Your Order bolumunde Payment Methods seçildi ve Place Order a tiklandi ");

        }
    }
