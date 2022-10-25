package tests.US_02;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_02 extends TestBaseRapor {
    SpendinGoodPage spendinGoodPage = new SpendinGoodPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void SupporTicketsFollowingsVeLogoutOlmaliTest() throws InterruptedException {
        extentTest = extentReports.createTest("Support tickets, followings ve log out olmali","Support tickets, follwings ve log out gorunur");
        extentTest.info("Email ve Sifre girilerek Siteye girilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        Thread.sleep(1500);
        extentTest.info("SignIn Buttonuna click yapar");
        spendinGoodPage.signIn.click();
        Thread.sleep(1500);
        extentTest.info("Email ve Password girip SIGN IN Buttonuna click yapar");
        spendinGoodPage.UserName.click();
        Thread.sleep(2000);
        actions.sendKeys("ceyhanbulent@gmail.com").
                sendKeys(Keys.TAB).sendKeys("ceycey1505").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.pass("Giris yapilip MyAccount yazısı gorulmeli");
        Thread.sleep(1500);
        spendinGoodPage.MyAccount.click();
        Assert.assertTrue(spendinGoodPage.MyAccountYazisi.isDisplayed());
        extentTest.pass("Acilan Sayfada Orders, Downloads, addresses, account details,whislist ve Logout gorulmeli");
        Assert.assertTrue(spendinGoodPage.OrdersGorunurOldugu.isDisplayed());
        Assert.assertTrue(spendinGoodPage.DownloadsGorunurOldugu.isDisplayed());
        Assert.assertTrue(spendinGoodPage.AdressGorunurOldugu.isDisplayed());
        Assert.assertTrue(spendinGoodPage.AccountDetailsGorunurOldugu.isDisplayed());
        Assert.assertTrue(spendinGoodPage.WishlistGorunurOldugu.isDisplayed());
        Assert.assertTrue(spendinGoodPage.LogoutGorunurOldugu.isDisplayed());
        extentTest.pass("Dashboard ve Altindaki Elementlerin Gorunurluk testi yapilir");
        Assert.assertTrue(spendinGoodPage.Dashboard.isDisplayed());
        Assert.assertTrue(spendinGoodPage.StoreManager.isDisplayed());
        Assert.assertTrue(spendinGoodPage.Orders.isDisplayed());
        Assert.assertTrue(spendinGoodPage.Downloads.isDisplayed());
        Assert.assertTrue(spendinGoodPage.Adresses.isDisplayed());
        Assert.assertTrue(spendinGoodPage.Accountdetails.isDisplayed());
        Assert.assertTrue(spendinGoodPage.Wishlist.isDisplayed());
        extentTest.pass("Support tickets, followings ve log out'ın oldugunun testi yapilir");
        Assert.assertTrue(spendinGoodPage.SupportTickets.isDisplayed());
        Assert.assertTrue(spendinGoodPage.Followings.isDisplayed());
        Assert.assertTrue(spendinGoodPage.LogoutDashboardAltinda.isDisplayed());
        extentTest.pass("Log Out'a tiklar ve Sayfayi kapatir");
        Thread.sleep(1500);
        spendinGoodPage.LogOut.click();
        Thread.sleep(2000);
        Driver.closeDriver();

    }
}