package tests.US_04;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US04_son extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    SpendinGoodPage spendinGoodPage = new SpendinGoodPage();

    @Test
    public void us_004Test01() {
        extentTest = extentReports.createTest("Secilen ürün View Cartta görülmeli; Rakam, miktar ve toplam olarak görülmeli");
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
        ReusableMethods.jsExecutorClick(spendinGoodPage.orders);
        extentTest.info("Orders'a tiklandi");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        ReusableMethods.jsExecutorClick(spendinGoodPage.goShop);
        extentTest.info("Orders sayfasinda browse products/go shop a tiklandi");

        ReusableMethods.jsExecutorScrool(spendinGoodPage.sortByMove);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        actions.moveToElement(spendinGoodPage.arcelikBuzdolabiMove).perform();
        spendinGoodPage.arcelikBuzdolabiChart.click();
        ReusableMethods.waitFor(3);
        extentTest.info("Secilen urun sepete eklendi");

        spendinGoodPage.viewChart.click();
        extentTest.info("view cart a tiklandi");

        Assert.assertTrue(spendinGoodPage.priceSubTotalProduct.isDisplayed());
        extentTest.pass("Acilan sayfada ürünler;product,Price,Ouantity,subtotal olarak görüldü");
}
        @Test(dependsOnMethods = "us_004Test01" )
          public void us_004Test02() {
            extentTest = extentReports.createTest("Secilen urunun artirilip azaltildigi ve stok fazlasi urunun eklenemedigi gorulmeli");
            spendinGoodPage.quantityPlus.click();
            spendinGoodPage.getQuantityMinus.click();
            for (int i = 0; i < 186; i++) {
                spendinGoodPage.quantityPlus.click();
                extentTest.info("secilmis urunun artirilip azaltilabildiğini ve stok fazlasi urunun eklenemedigi goruldu");
            }

            extentTest.pass("secilmis urunun artirilip azaltilabildiğini ve stok fazlasi urunun eklenemedigi goruldu");
        }
        @Test(dependsOnMethods = "us_004Test02" )
          public void us_004Test03(){
        extentTest = extentReports.createTest("Update Cart ile rakamlarin güncellendigi gorulmeli");
        ReusableMethods.waitFor(3);
        ReusableMethods.jsExecutorClick(spendinGoodPage.updateChart);
        Assert.assertTrue(spendinGoodPage.updateCartDisplayed.isDisplayed());
        extentTest.info("Update Cart ile rakamlarin güncellendigi goruldu");
        ReusableMethods.waitFor(3);
        extentTest.pass("Update Cart ile rakamlarin güncellendigi goruldu");
}
        @Test(dependsOnMethods = "us_004Test03" )
        public void us_004Test04(){
        extentTest = extentReports.createTest("Coupon secenegi gorulmeli");
        Assert.assertTrue(spendinGoodPage.applyCoupon.isDisplayed());
        extentTest.info("Coupon secenegi goruldu");
        ReusableMethods.waitFor(5);
        extentTest.pass("Coupon secenegi goruldu");

        }
        @Test(dependsOnMethods = "us_004Test04" )
        public void us_004Test05(){
        extentTest = extentReports.createTest("Shipping bilgileri gorulmeli ve toplam rakam sağda populate edilmeli");
        Assert.assertTrue(spendinGoodPage.shippingCountry.isDisplayed());
        Assert.assertTrue(spendinGoodPage.shippingState.isDisplayed());
        Assert.assertTrue(spendinGoodPage.shippingCity.isDisplayed());
        Assert.assertTrue(spendinGoodPage.shippingPostCode.isDisplayed());
        extentTest.info("Shipping bilgilerini goruldu ve toplam rakam sağda populate edildi");
        extentTest.pass("Shipping bilgilerini goruldu ve toplam rakam sağda populate edildi");
    }
        @Test(dependsOnMethods = "us_004Test05" )
        public void us_004Test06(){
        extentTest = extentReports.createTest("Proceed to Checkout butonunun olduğunu teyit edilmeli");
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(spendinGoodPage.proceedtoCheckout.isDisplayed());
        extentTest.info("Proceed to Checkout butonunun olduğu teyit edildi");
        extentTest.pass("Proceed to Checkout butonunun olduğu teyit edildi");
}
        @Test(dependsOnMethods = "us_004Test06" )
        public void us_004Test07(){
        extentTest = extentReports.createTest("Continue butonunun olduğu teyit edilmeli");
        Assert.assertTrue(spendinGoodPage.continueShopping.isDisplayed());
        extentTest.info("Continue butonunun olduğu teyit edildi");
        extentTest.pass("Continue butonunun olduğu teyit edildi");

        }
        @Test(dependsOnMethods = "us_004Test07" )
        public void us_004Test08(){
        extentTest = extentReports.createTest("Clear cart butonu ile rakamlar silinebilmeli");
        ReusableMethods.jsExecutorClick(spendinGoodPage.clearChart);
        Assert.assertTrue(spendinGoodPage.cartEmpty.isDisplayed());
        extentTest.info("Clear cart butonu ile rakamlar silindi");
        extentTest.pass("Clear cart butonu ile rakamlar silindi");
    }
}




