package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.PracticeFormPage;
import utilities.Driver;

import java.util.Random;

public class PracticeFormStepDefinition {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Given("Kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String url) {
        Driver.getDriver().get(url);

    }

    @When("username {string} password {string} ve textarea {string} kisimlarini doldurur")
    public void username_password_ve_textarea_kisimlarini_doldurur(String username, String password, String textarea) {
        practiceFormPage.username.sendKeys(username);
        practiceFormPage.password.sendKeys(password);
        practiceFormPage.comments.clear();
        practiceFormPage.comments.sendKeys(textarea);
    }

    @When("bir dosya yukler")
    public void bir_dosya_yukler() {

        practiceFormPage.chooseFile.sendKeys("C:\\Users\\kurkcu\\Desktop\\test.txt");

        /*String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "/Desktop/test.txt";
        practiceFormPage.chooseFile.sendKeys(filePath);*/
    }

    @When("checkbox1 i secer")
    public void checkbox1_i_secer() {
        if (!practiceFormPage.checkbox1.isSelected()) {
            practiceFormPage.checkbox1.click();
        }
        if (practiceFormPage.checkbox2.isSelected()) {
            practiceFormPage.checkbox2.click();
        }
        if (practiceFormPage.checkbox3.isSelected()) {
            practiceFormPage.checkbox3.click();
        }
    }

    @When("radio2 yi secer")
    public void radio2_yi_secer() {
        practiceFormPage.radio2.click();
    }

    @When("selection item3 secer")
    public void selection_item3_secer() {
        practiceFormPage.selectItem3.click();
    }

    @When("dropdown itmem4 secer")
    public void dropdown_itmem4_secer() {
        Select select = new Select(practiceFormPage.dropdown);
        Random random = new Random();
        int rastgele = random.nextInt(select.getOptions().size() - 1);

        select.selectByIndex(rastgele);

        //random java based, selenium degil
    }

    @When("submite tiklar")
    public void submite_tiklar() {
        practiceFormPage.submitButton.click();
    }

    @Then("dosyanin yuklendigini dogrular")
    public void dosyanin_yuklendigini_dogrular() {
        Assert.assertTrue(practiceFormPage.fileName.isDisplayed());
    }
}