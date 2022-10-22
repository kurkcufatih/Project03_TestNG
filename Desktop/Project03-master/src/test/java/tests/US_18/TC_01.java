package tests.US_18;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_01 {
    @Test
    public void testCase01() {
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
        ReusableMethods.waitFor(1);
        js.executeScript("arguments[0].click()",spendingPage.orders);
        js.executeScript("arguments[0].scrollIntoView(true);",spendingPage.home);
        ReusableMethods.waitFor(1);
        Assert.assertFalse(spendingPage.ordersListViewDetails.isEmpty());
        ReusableMethods.waitFor(1);
        ReusableMethods.jsExecutorScrool(spendingPage.refundRequest);
        js.executeScript("arguments[0].click()",spendingPage.refundRequest);
        ReusableMethods.waitFor(1);
        Select select = new Select(spendingPage.refundRequestDropDown);
        ReusableMethods.waitFor(1);
        select.selectByIndex(0);
        spendingPage.refundRequestReasonTextBox.sendKeys("Magazamizdan kaynakl bir sorundan dolayı urununuz gonderilememektedir.");
        //spendingPage.refundRequestSubmitButton.click();
    }
}
