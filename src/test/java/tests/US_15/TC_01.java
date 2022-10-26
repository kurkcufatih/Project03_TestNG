package tests.US_15;

import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_01 extends TestBaseRapor {
    SpendinGoodPage spendinGoodPage=new SpendinGoodPage();
    Actions actions=new Actions(Driver.getDriver());
    public static void run2() throws IOException {
    tests.US_14.TC_01 test2=new tests.US_14.TC_01();
        test2.TC001();
        test2.TC002();
        test2.TC003();
        test2.TC004();
        test2.TC005();
        test2.TC006();
        test2.TC007();
        test2.TC008();
        test2.TC009();
}
    @Test
    public void tc_001() throws IOException {
        tests.US_14.TC_01.run1();
        run2();
        ReusableMethods.jsExecutorScrool(spendinGoodPage.couponLimitButon);
        ReusableMethods.jsExecutorClick(spendinGoodPage.couponLimitButon);
        extentTest.info("Limit'e tiklandi");
        spendinGoodPage.usageLimitPerCouponTextBox.sendKeys("2");
        extentTest.pass("Usage limit per coupon'a bir sayi degeri girildi");
    }
    @Test(dependsOnMethods = "tc_001")
    public void tc_002() {
        spendinGoodPage.limitUsageToxItemsTextBox.sendKeys("3");
        extentTest.pass("Limit usage to X items'e bir sayi degeri girildi");

    }
    @Test(dependsOnMethods = "tc_002")
    public void tc_003() {
        spendinGoodPage.usageLimitPerUserTextBox.sendKeys("2");
        extentTest.pass("Limit usage limit per user'a bir sayi degeri girildi");
        ReusableMethods.jsExecutorScrool(spendinGoodPage.couponSubmitButon);
        spendinGoodPage.couponSubmitButon.click();
        extentTest.info("Submit butonuna basildi");
        ReusableMethods.waitForVisibility(spendinGoodPage.couponSuccessfullyPublishedMessage,15);
        String exceptionText="Coupon Successfully Published.";
        String actualText=spendinGoodPage.couponSuccessfullyPublishedMessage.getText();
        Assert.assertEquals(exceptionText,actualText);
        extentTest.pass("Kupon basarili bir sekilde olusturuldu");

    }

}



