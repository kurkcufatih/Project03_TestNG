package tests.US_14;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_01 extends TestBaseRapor {
    public SpendinGoodPage spendinGoodPage;
    public Actions actions=new Actions(Driver.getDriver());
    public Select select;
    public static void run1() {
        tests.US_13.TC_01 test = new tests.US_13.TC_01();
        test.TC001();
        test.TC002();
        test.TC003();
        test.TC004();
        test.TC005();
        test.TC006();
        test.TC007();
    }
    @Test()
    public void TC0001() {
        run1();
    }
    @Test()
    public void TC001() {

        spendinGoodPage = new SpendinGoodPage();
        extentTest = extentReports.createTest("Kupon Olusturma Testi", "kupon olusturabilme");
        spendinGoodPage.minimumSpend.sendKeys("10000");
        extentTest.pass("Minimum spend girildi");
    }

    @Test(dependsOnMethods = "TC001")
    public void TC002() {
        ReusableMethods.jsExecutorScrool(spendinGoodPage.maximumSpend);
        spendinGoodPage.maximumSpend.sendKeys("100000");
        extentTest.pass("Maximum spend girildi");
    }

    @Test(dependsOnMethods = "TC002")
    public void TC003() {
        ReusableMethods.jsExecutorScrool(spendinGoodPage.individualUseOnly);
        ReusableMethods.jsExecutorClick(spendinGoodPage.individualUseOnly);
        extentTest.pass("Individual use only TIKLA");
    }
    @Test(dependsOnMethods = "TC003")
    public void TC004() {
        actions.sendKeys(Keys.TAB).perform();
        ReusableMethods.jsExecutorClick(spendinGoodPage.excludeSaleItems);
        extentTest.pass("Exclude sale items use only ");
    }
    @Test(dependsOnMethods = "TC004")
    public void TC005() {
        spendinGoodPage.productsTextbox.sendKeys("bag");
        spendinGoodPage.productsTextboxClick.click();
        extentTest.pass("Products Textbox'a kupon uygulanacak urunler secildi");
    }
    @Test(dependsOnMethods = "TC005")
    public void TC006() throws IOException {

        actions.sendKeys(Keys.TAB).perform();
        spendinGoodPage.excludeProductsTextbox.sendKeys("bag");
        spendinGoodPage.productsTextboxClick2.click();

            ReusableMethods.getScreenshot("Spending GoodPage Exclude ile Products ayni urun eklendi");

        extentTest.fail("Exclude Products ile Products'ta ayni urun secildi");
    }
    @Test(dependsOnMethods = "TC006")
    public void TC007()  {

        spendinGoodPage.productCategories.sendKeys("For Men");
        actions.moveToElement(spendinGoodPage.choosenProductCategories).click(spendinGoodPage.choosenProductCategories).perform();
        extentTest.pass("Product categories kupon uygulanacak urunler secildi");
    }
    @Test(dependsOnMethods = "TC007")
    public void TC008() throws IOException {

        spendinGoodPage.excludeCategories.sendKeys("For Men");
        ReusableMethods.waitFor(3);
        actions.moveToElement(spendinGoodPage.choosenProductCategories2).click(spendinGoodPage.choosenProductCategories2).perform();
        ReusableMethods.getScreenshot("Spending GoodPage Exclude categories ile Product kategories ayni katagori eklendi");

        extentTest.fail("Exclude categories ile Product categories'de ayni urun katagorileri secildi");
    }
    @Test(dependsOnMethods = "TC008")
    public void TC009() {
        spendinGoodPage.sonEmail .click();
        spendinGoodPage.sonEmail.sendKeys(ConfigReader.getProperty("berkEmail"));
        extentTest.pass("Email restrictions textbox'ina email girildi");

    }
}