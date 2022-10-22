package tests.US_18;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_04 {
    @Test
    public void testCase04() {
        SpendinGoodPage spendingPage=new SpendinGoodPage();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();

        spendingPage.girisYap("oguzEmail","oguzPassword");
        ReusableMethods.waitFor(3);
        spendingPage.myAccount.click();
        js.executeScript("arguments[0].scrollIntoView(true);",spendingPage.dashboard);
        ReusableMethods.waitFor(1);
        spendingPage.storeManager.click();
        js.executeScript("arguments[0].scrollIntoView(true);",spendingPage.home);
        js.executeScript("arguments[0].click()",spendingPage.refundButton);
        js.executeScript("arguments[0].scrollIntoView(true);",spendingPage.home);
        Assert.assertTrue(spendingPage.refundType.isDisplayed());
        Assert.assertTrue(spendingPage.refundReason.isDisplayed());
    }
}
