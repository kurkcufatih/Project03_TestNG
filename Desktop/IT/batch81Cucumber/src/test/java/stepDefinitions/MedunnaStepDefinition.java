package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.PracticeMedunnaNegativeTestPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class MedunnaStepDefinition {
    PracticeMedunnaNegativeTestPage practiceMedunnaNegativeTestPage = new PracticeMedunnaNegativeTestPage();

    @Given("kullanici {string} sayfasina gidecek")
    public void kullaniciSayfasinaGidecek(String arg0) {
        Driver.getDriver().get("https://medunna.com/");
    }
    @And("login olmak icin signin e tiklar")
    public void loginOlmakIcinSigninETiklar() {
        ReusableMethods.waitForClickablility(practiceMedunnaNegativeTestPage.signinSymbol, 15);
        practiceMedunnaNegativeTestPage.signinSymbol.click();
    }

    @And("signine tiklar")
    public void signineTiklar() {
        practiceMedunnaNegativeTestPage.signinButton.click();
    }

    @And("username icin {string} kullanici adini gonderir")
    public void usernameIcinKullaniciAdiniGonderir(String username) {
        username = Faker.instance().name().username();
        practiceMedunnaNegativeTestPage.username.sendKeys(username);

    }

    @And("password icin {string} parolasini gonderir")
    public void passwordIcinParolasiniGonderir(String password) {
        password = Faker.instance().internet().password();
        practiceMedunnaNegativeTestPage.password.sendKeys(password);
    }


    @And("Authentication information not correct uyarisini dogrular")
    public void authenticationInformationNotCorrectUyarisiniDogrular() {
        Assert.assertTrue(practiceMedunnaNegativeTestPage.signinWithCredentials.isDisplayed());

    }


}
