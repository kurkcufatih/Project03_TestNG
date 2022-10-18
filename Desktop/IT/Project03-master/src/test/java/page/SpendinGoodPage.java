package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

public class SpendinGoodPage {

    public SpendinGoodPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    /*Page sayfamizin Reusable olabilmesi acisindan ortak locateleri bir daha almamak icin
     alinan locatelerin yanina aciklama yazalim,ona gore herkes o locate'i kullansin.
    Ornegin signin kisminin locate'i alindiginda locate ismini anlasilabilir
    yazip yanina ekstra bi aciklama yaptigimizda herkes onu kullansin(Ozellikle ortak kullanilacak locateler icin)
    */
    /* US_01 (20. ile 59.satır) */






































    /*US_02(61. ile 99.satır)*/







































    /*US_03(101. ile 139.satır)*/







































    /*US_04(141. ile 179.satır)*/







































    /*US_05(181. ile 219.satır)*/







































    /*US_06(221. ile 259.satır)*/







































    /*US_07(261. ile 299.satır)*/







































    /*US_08(301. ile 339.satır)*/
@FindBy(xpath = "//div[@class='wcfm_menu_items wcfm_menu_wcfm-products']")
public WebElement storageManagerButonunaTikladiktanSonraCikanProductButtonu;

@FindBy(xpath = "//span[@class='wcfmfa fa-edit text_tip']")
public WebElement urunUzerindekiEditButonu;

@FindBy(xpath = "(//a[text()='My Account'])[1]")
public WebElement anasayfadakiMyAccountButonu;





































    /*US_09(341. ile 379.satır)*/







































    /*US_10(381. ile 419.satır)*/







































    /*US_11(421. ile 459.satır)*/







































    /*US_12(461. ile 499)*/







































    /*US_13(501. ile 539)*/







































    /*US_14(541. ile 579)*/







































    /*US_15(581. ile 619)*/


    /*US_16(621. ile 659)*/
    @FindBy(xpath = "//a[@class=\"login inline-type\"]")
    public WebElement signInButton;                             //ORTAK SIGNIN Button
    @FindBy(xpath = "//input[@id=\"username\"]")
    public WebElement emailAdresBox;                            //ORTAK SIGNIN Button
    @FindBy(xpath = "//input[@id=\"password\"]")
    public WebElement passwordBox;                              //ORTAK SIGNIN Button
    @FindBy(xpath = "//button[@class=\"woocommerce-button button woocommerce-form-login__submit\"]")
    public WebElement signInButton2;                            //ORTAK SIGNIN Button
    @FindBy(xpath = "//li[@id=\"menu-item-1074\"]")
    public WebElement myAccountButton;                          //ORTAK MYAccount Button
    @FindBy(xpath = "//li[@class=\"woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--wcfm-store-manager\"]")
    public WebElement storeManager;                             //ORTAK StoreManager Button
    @FindBy(xpath = "//span[@class=\"wcfmfa fa-user-circle\"]")
    public WebElement customers;
    @FindBy(xpath = "(//tbody//td)[1]")
    public WebElement kayitliKullaniciIsim;
    @FindBy(xpath = "(//tbody//td)[2]")
    public WebElement kayitliKullaniciKullaniciAdi;
    @FindBy(xpath = "(//tbody//td)[3]")
    public WebElement kayitliKullaniciMail;
    @FindBy(xpath = "(//tbody//td)[4]")
    public WebElement kayitliKullaniciAdres;
    @FindBy(xpath = "(//tbody//td)[6]")
    public WebElement kayitliKullaniciHarcamaMiktari;
    @FindBy(xpath = "(//tbody//td)[7]")
    public WebElement kayitliKullaniciSonSiparis;
    /*==========US16TC02==========*/
    @FindBy(xpath = "//a[@class=\"dt-button buttons-pdf buttons-html5\"]")
    public WebElement pdfDownloadButton;
    @FindBy(xpath = "//*[@id=\"wcfm-shop-customers_wrapper\"]/div[1]/a[3]")
    public WebElement excelDownloadButton;
    @FindBy(xpath = "//a[@class=\"dt-button buttons-csv buttons-html5\"]")
    public WebElement csvDownloadButton;
    /*==========US16TC03==========*/
    @FindBy(xpath = "//span[@class=\"wcfmfa fa-user-plus\"]")
    public WebElement addNewButton;
    @FindBy(xpath = "//input[@id=\"user_name\"]")
    public WebElement addCustomerUsername;

    /*US_17(661. ile 699)*/







































    /*US_18(701. ile 739)*/







































    /*US_19(741. ile 779)*/







































    /*US_20(781. ile 819)*/







































    /*US_21(821. ile 859)*/







































    /*US_22(861. ile 899)*/


    /*US_17(891-929)*/
    @FindBy(xpath = "//input[@id=\"user_email\"]")
    public WebElement addCustomerMail;
    @FindBy(xpath = "//input[@id=\"first_name\"]")
    public WebElement addCustomerFirstname;
    @FindBy(xpath = "//input[@id=\"last_name\"]")
    public WebElement addCustomerLastname;
    @FindBy(xpath = "//input[@id=\"wcfm_customer_submit_button\"]")
    public WebElement addCustomerSubmitbutton;
    @FindBy(xpath = "//div[@id=\"wcfm_customer_submit\"]")
    public WebElement basariliGirisYazisi;


}
