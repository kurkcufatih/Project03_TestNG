package tests.US_19;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import page.SpendinGoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_02 {
    @Test
    public void testCase02() {
        SpendinGoodPage spendingPage = new SpendinGoodPage();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        spendingPage.girisYap("oguzEmail","oguzPassword");
        ReusableMethods.waitFor(3);
        spendingPage.myAccount.click();
        js.executeScript("arguments[0].scrollIntoView(true);", spendingPage.dashboard);
        ReusableMethods.waitFor(1);
        spendingPage.storeManager.click();
        js.executeScript("arguments[0].scrollIntoView(true);", spendingPage.home);
        js.executeScript("arguments[0].click()", spendingPage.follewers);
        js.executeScript("arguments[0].scrollIntoView(true);", spendingPage.home);
        String actualResultStr = spendingPage.follewersTable.getText();
        if (actualResultStr.equals("No data in the table")) {
            System.out.println("Tabloda data olmadigi icin actions degeri gorulemedi");
        }
    }
}
