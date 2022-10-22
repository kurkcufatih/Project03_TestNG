package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class SpendinGoodPage {

    public SpendinGoodPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    /*Page sayfamizin Reusable olabilmesi acisindan ortak locateleri bir daha almamak icin
     alinan locatelerin yanina aciklama yazalim,ona gore herkes o locate'i kullansin. */
   /* US_01 (20. ile 59.satır) */








































/*US_02(61. ile 99.satır)*/







































    /*US_03(101. ile 139.satır)*/







































    /*US_04(141. ile 179.satır)*/







































    /*US_05(181. ile 219.satır)*/







































    /*US_06(221. ile 259.satır)*/







































    /*US_07(261. ile 299.satır)*/







































    /*US_08(301. ile 339.satır)*/
 @FindBy(xpath = "//main//div//div[@class='wcfm_menu_items wcfm_menu_wcfm-products']")
 public WebElement storageManagerButonunaTikladiktanSonraCikanProductButtonu;
 @FindBy(xpath = "//span[@class='wcfmfa fa-edit text_tip']")
 public WebElement urunUzerindekiEditButonu;
 @FindBy(xpath = "(//a[text()='My Account'])[1]")
 public WebElement anasayfadakiMyAccountButonu;
 @FindBy(xpath = "//*[@id='stock_qty']")
 public WebElement stockQty;
 @FindBy(xpath = "//select[@id='backorders']")
 public WebElement allowBackorders;
 @FindBy(xpath = "//input[@id='wcfm_products_simple_draft_button']")
 public WebElement editProductKismindakisubmitButonu;
 @FindBy(xpath = "//a/input[@value='Preview']")
 public WebElement editProductKismindakiViewButonu;
 @FindBy(xpath = "//script[@id='wcfm_core_js-js-extra']")
 public List<WebElement> notifikasyonMesajlari;
 @FindBy(xpath = "//p[@class='stock in-stock']")
 public WebElement mevcutStockMiktari;
@FindBy(xpath = "//*[@class='wcfmfa fa-cogs']")
public WebElement dashboardSettings;
@FindBy(xpath = "//*[@class='wcfmfa fa-truck']")
public WebElement settingButonunaTikladiktanSonraCikanShippingButonu;
@FindBy(xpath = "//*[@id='wcfmmp_pt']")
public WebElement processingTimeOptions;
@FindBy(xpath = "//form//input[@id='wcfm_settings_save_button']")
public WebElement saveButonu;
@FindBy(xpath = "//div[@class='wcfm-message wcfm-success']")
public WebElement savedSuccessfullyYazisi;












    /*US_09(341. ile 379.satır)*/







































    /*US_10(381. ile 419.satır)*/







































    /*US_11(421. ile 459.satır)*/







































    /*US_12(461. ile 499)*/
@FindBy(xpath = "//*[@class='icon-box-icon icon-orders']")
public WebElement myAccountOrdersButon;
@FindBy(xpath = "(//*[text()='View'])[1]")
public WebElement myAccountOrdersViewButon;
@FindBy(xpath = "//*[@class='icon-box-icon icon-downloads']")
public WebElement myAccountDownloadButon;
@FindBy(xpath = "//*[@class='icon-box-icon icon-addresses']")
public WebElement myAccountAddressesButon;
@FindBy(xpath = "//*[@class='icon-box-icon icon-account']")
public WebElement myAccountAccountDetailsButon;
@FindBy(xpath = "//thead//tr")
public WebElement productHead;
@FindBy(xpath = "(//*[@class='address-table'])[1]")
public WebElement billingAddressTable;
@FindBy(xpath = "(//*[@class='address-table'])[2]")
public WebElement shippingAddressTable;
@FindBy(xpath = "//*[@class='icon-box-title text-normal']")
public WebElement updateAccountDetails;
@FindBy(xpath = "//*[@id='account_first_name']")
public WebElement updateAccountFirstNameTextBox;
@FindBy(xpath = "//*[contains(@class, 'woocommerce-message alert alert-simple alert-icon alert-close-top alert-success')]")
public WebElement updateSuccessfulMessage;
@FindBy(xpath = "//strong[contains(text(),'Display name')]")
public WebElement updateFailedMessage;
@FindBy(xpath = "//*[contains(text(),'Coupon Successfully Published.')]")
public WebElement couponSuccessfullyPublishedMessage;
@FindBy(xpath = "//*[@id='coupons_manage_limit']")
public WebElement couponLimitButon;
@FindBy(xpath = "//*[@id='usage_limit']")
public WebElement usageLimitPerCouponTextBox;
@FindBy(xpath = "//*[@id='limit_usage_to_x_items']")
public WebElement limitUsageToxItemsTextBox;
@FindBy(xpath = "//*[@id='usage_limit_per_user']")
public WebElement usageLimitPerUserTextBox;
@FindBy(xpath = "//*[@id='wcfm_coupon_manager_submit_button']")
public WebElement couponSubmitButon;



    /*US_13(501. ile 539)*/
    @FindBy(xpath = "(//*[text()='My Account'])[1]")
    public WebElement myAccount;
    @FindBy(xpath = "//span[@class='wcfmfa fa-gift']")
    public WebElement couponButton;
    @FindBy(xpath = "//span[text()='Add New']")
    public WebElement couponAddNewButton;
    @FindBy (xpath ="//*[text()='Store Manager']")
    public WebElement storeManagerButton;                     //Ortak
   @FindBy(xpath = "//input[@id=\"title\"]")
   public WebElement codeText;
   @FindBy(xpath = "//textarea[@id='description']")
   public WebElement descriptionText;
   @FindBy(xpath = "//select[@id='discount_type']")
   public WebElement discountType;
   @FindBy(xpath = "//input[@id='coupon_amount']")
   public WebElement couponAmount;
   @FindBy(xpath = "//input[@id='expiry_date']")
   public WebElement couponExpiryDate;
    @FindBy(xpath = "//input[@id='free_shipping']")
    public WebElement allowFreeShipping;
    @FindBy(xpath = "//input[@id='show_on_store']")
    public WebElement showOnStore;

















    /*US_14(541. ile 579)*/
    @FindBy(xpath = "//input[@id='minimum_amount']")
    public WebElement minimumSpend;
    @FindBy(xpath = "//input[@id='maximum_amount']")
    public WebElement maximumSpend;
    @FindBy(xpath = "//input[@id='individual_use']")
    public WebElement individualUseOnly;
    @FindBy(xpath = "//input[@id='exclude_sale_items']")
    public WebElement excludeSaleItems;
    @FindBy(xpath = "(//input[@class='select2-search__field'])[1]")
    public WebElement productsTextbox;
    @FindBy(xpath = "(//*[text()='bag (100)'])[1]")
    public WebElement productsTextboxClick;
    @FindBy(xpath = "(//li[text()='bag (100)'])[2]")
    public WebElement productsTextboxClick2;
    @FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
    public WebElement excludeProductsTextbox;
    @FindBy(xpath = "(//input[@class='select2-search__field'])[3]")
    public WebElement productCategoriesTextbox;
    @FindBy(xpath = "//li[@id='select2-product_categories-result-wjal-395']")
    public WebElement productCategories;
    @FindBy(xpath = "(//input[@class='select2-search__field'])[4]")
    public WebElement excludeCategoriesTextbox;
    @FindBy(xpath = "//input[@id='customer_email']")
    public  WebElement emailRestrictions;















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



    @FindBy (xpath = "//input[@id='username']")
    public WebElement emailBox;

    @FindBy (xpath = "//button[@name='login']")
    public WebElement sigInButton;

    @FindBy (xpath = "(//span[@class='text'])[5]")
    public WebElement orders;

    @FindBy (xpath = "//span[@class='wcfmfa fa-eye text_tip']")
    public List<WebElement> ordersListViewDetails;

    @FindBy (xpath = "//a[text()='Dashboard']")
    public WebElement dashboard;

    @FindBy (xpath = "(//a[@class='wcfmmp_order_refund_request wcfm-action-icon'])[7]")
    public WebElement refundRequest;

    @FindBy (xpath = "//*[@name='wcfm_refund_request']")
    public WebElement refundRequestDropDown;

    @FindBy (xpath = "(//span[text()='Home'])[1]")
    public WebElement home;

    @FindBy (xpath = "//*[@id='wcfm_refund_reason']")
    public WebElement refundRequestReasonTextBox;

    @FindBy (xpath = "(//span[@class='text'])[8]")
    public WebElement refundButton;

    @FindBy (xpath = "(//a[@class='wcfm_dashboard_item_title transaction_order_id'])[3]")
    public WebElement orderIdUrunNo;

    @FindBy (xpath = "(//span[@class='woocommerce-Price-amount amount'])[3]")
    public WebElement orderIdAmount;

    /*US_19(741. ile 779)*/
    @FindBy (xpath = "(//tbody//tr//td)[19]")
    public WebElement refundType;

    @FindBy (xpath = "(//tbody//tr//td)[20]")
    public WebElement refundReason;



    @FindBy (xpath = "(//span[@class='text'])[11]")
    public WebElement follewers;

    @FindBy (xpath = "//td[text()='No data in the table']")
    public WebElement follewersTable;

    @FindBy (xpath = "(//span[@class='text'])[16]")
    public WebElement reviews;

    @FindBy (xpath = "//span[text()='Product Reviews']")
    public WebElement productReviews;

    @FindBy(xpath = "(//div[@class='wcfmmp-author-meta'])[2]")
    public WebElement productReviewsKullaniciBilgisi;

    @FindBy (xpath = "(//div[@class='wcfmmp-comments-content'])[2]")
    public WebElement productReviewsComment;

    @FindBy (xpath = "(//*[@itemprop='ratingValue'])[2]")
    public WebElement productReviewsRating;

    @FindBy (xpath = "//td[text()='15 October 2022 13:41']")
    public WebElement productReviewsDate;








    /*US_20(781. ile 819)*/

   public void girisYap(String userName, String password){
    Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
    signIn.click();
    emailBox.sendKeys(ConfigReader.getProperty(userName));
    passwordBox.sendKeys(ConfigReader.getProperty(password));
    sigInButton.click();
   }






























   
   /*US_21(821. ile 859)*/
    @FindBy (xpath = "//*[text()='Sign In '] ")
    public WebElement signIn;
    @FindBy (xpath = "//*[@id='username'] ")
    public WebElement userNameEmail;
    @FindBy (xpath = "//*[@id='password'] ")
    public WebElement password;
    @FindBy (xpath = "(//*[text()='Sign In'])[2]")
    public WebElement signIn2;
    @FindBy (xpath = "(//*[text()='My Account'])[1]")
    public WebElement myHesabim;
    @FindBy (xpath = "(//span[@class='text'])[14]")
    public WebElement reports;
    @FindBy (xpath = "//*[text()='Year']")
    public WebElement year;
    @FindBy (xpath = "//*[text()='Last Month']")
    public WebElement lastMonth;
    @FindBy (xpath = "//*[text()='This Month']")
    public WebElement thisMonth;
    @FindBy (xpath = "//*[text()='Last 7 Days']")
    public WebElement last7Days;
    @FindBy (xpath = "//*[@class='wcfm-date-range']")
    public WebElement dateRange;
    @FindBy (xpath = "(//*[@class='logo'])[1]")
    public WebElement logo;
    @FindBy (xpath = "//*[@class='wcfm-page-heading-text']")
    public WebElement tarihAraligi;
    @FindBy (xpath = "//*[@id='chart-placeholder-canvas']")
    public WebElement raporlar;
    @FindBy (xpath = "//*[@class='apply-btn']")
    public WebElement closs;









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
