package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
    @FindBy(xpath = "//*[text()='Register']") public WebElement Register;

    @FindBy(xpath = "//*[@class='nav-link']") public WebElement SIGNUP;
    @FindBy(xpath = "//*[@class='wcfmmp_become_vendor_link']")  public WebElement BecomeVendor;
    @FindBy(xpath = "//*[@class='page-title']") public WebElement VendorRegistration;
    @FindBy(xpath = "//*[@id='wcfm_membership_registration_form']") public WebElement EmailPasswordConfirmPassword;
    @FindBy(xpath = "//*[@class='wcfm-membership-wrapper']") public WebElement UcEmailPasswordConfirmPassword;
    @FindBy(xpath = "//*[@id='user_email']") public WebElement Email;
    @FindBy(xpath = "//*[@class='wcfm-text wcfm_email_verified_input']") public WebElement VerificationCodeBox;

    @FindBy(xpath = "//*[@class='wcfm-text wcfm_submit_button wcfm_email_verified_button']") public WebElement ReSendCode;
    //  @FindBy(xpath = "//*[@id='passoword']") public WebElement Password;
    @FindBy(xpath = "//*[@id='confirm_pwd']") public WebElement ConfirmPassword;
    @FindBy(xpath = "//*[@id='wcfm_membership_register_button']") public WebElement RegisterButton;
    @FindBy(xpath = "//*[@class='wcfm-message wcfm-error']") public WebElement UniqOlmayanYazisi;



    @FindBy (xpath = "//*[@class='email']") public WebElement geciciEmail;

    @FindBy (css = "a#renew") public WebElement emailBoxRefresh;
    @FindBy(xpath = "//tbody//tr[1]") public WebElement geciciEmailBox;
    @FindBy(xpath = "//*[@id='body_content_inner']") public WebElement verificationCode;
    @FindBy(xpath = "//*[@id='renew']") public WebElement yenilemeTusu;
    //US_02 Locatleri
    @FindBy(xpath = "//*[@class='page-title']") public WebElement MyAccountYazisi;
    @FindBy(xpath = "//*[@id='username']") public WebElement UserName;
    @FindBy(xpath = "//*[@id='password']") public WebElement PasswordSıgnIn;

    @FindBy(xpath = "//*[@value='Sign In']") public WebElement SıgnInButton;
    @FindBy(xpath = "//*[text()='Log out']") public WebElement LogOut;
    @FindBy(xpath = "(//*[@class='icon-box text-center'])[1]") public WebElement OrdersGorunurOldugu;
    @FindBy(xpath = "(//*[@class='icon-box text-center'])[2]") public WebElement DownloadsGorunurOldugu;
    @FindBy(xpath = "(//*[@class='icon-box text-center'])[3]") public WebElement AdressGorunurOldugu;
    @FindBy(xpath = "(//*[@class='icon-box text-center'])[4]") public WebElement AccountDetailsGorunurOldugu;
    @FindBy(xpath = "(//*[@class='icon-box text-center'])[5]") public WebElement WishlistGorunurOldugu;
    /*US_02(61. ile 99.satır)*/
    @FindBy(xpath = "(//*[@class='icon-box text-center'])[6]") public WebElement LogoutGorunurOldugu;
    @FindBy(xpath = "//*[text()='Dashboard']") public WebElement Dashboard;

    @FindBy(xpath = "(//*[text()='Orders'])[1]") public WebElement Orders;
    /*US_02(61. ile 99.satır)*/
    @FindBy(xpath = "(//*[text()='Downloads'])[1]") public WebElement Downloads;
    @FindBy(xpath = "(//*[text()='Addresses'])[1]") public WebElement Adresses;
    @FindBy(xpath = "(//*[text()='Wishlist'])[2]") public WebElement Wishlist;
    @FindBy(xpath = "(//*[text()='Account details'])[1]") public WebElement Accountdetails;
    @FindBy(xpath = "//*[text()='Support Tickets']") public WebElement SupportTickets;
    @FindBy(xpath = "//*[text()='Followings']") public WebElement Followings;
    @FindBy(xpath = "(//*[text()='Logout'])[1]") public WebElement LogoutDashboardAltinda;

    @FindBy(xpath = "//*[@class='text-uppercase text-center mb-0']") public List<WebElement> Elemanlar;





























    /*US_03 US_04 (101. ile 179.satır)*/
    @FindBy (xpath="(//*[text()='Orders'])[2]")
    public WebElement orderss;
    @FindBy (xpath="//a[@class='btn btn-dark btn-rounded btn-icon-right continue-shopping mb-4 mt-6']")
    public WebElement goShop;
    @FindBy (xpath="(//*[@class='w-icon-cart'])[1]")
    public WebElement cart;
    @FindBy (xpath="//a[@class='button checkout wc-forward']")
    public WebElement buttonCheckout;
    @FindBy (xpath = "//*[@aria-label='Add “Arcelik” to your cart']")
    public WebElement buzdolabi;
    @FindBy(xpath = "//*[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart']")
    public List<WebElement> miniAddToCartButon;
    @FindBy(xpath = "//*[@class='product-wrap']")
    public List<WebElement>UrunListesi;
    @FindBy (xpath="//*[@name='billing_first_name']")
    public  WebElement billingDetailsfirstName;
    @FindBy (xpath="//*[@name='billing_last_name']")
    public  WebElement billingDetailslastName;
    @FindBy (xpath="//*[@name='billing_company']")
    public  WebElement billingDetailscompany;
    @FindBy (xpath="//*[@id='billing_address_1']")
    public  WebElement billingDetailsstreetAddress;
    @FindBy (xpath="//*[@name='billing_postcode']")
    public  WebElement billingDetailspostCode;
    @FindBy (xpath="//*[@name='billing_city']")
    public  WebElement billingDetailscity;
    @FindBy (xpath="//*[@name='billing_phone']")
    public  WebElement billingDetailsphone;
    @FindBy (xpath="//*[@name='billing_email']")
    public  WebElement billingDetailemail;
    @FindBy (id="place_order")
    public WebElement placeOrder;
    @FindBy (xpath="(//*[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail'])[10]")
    public WebElement productsCrusher;
    @FindBy (xpath="(//*[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart'])[3]")
    public WebElement productsCrusherCart;
    @FindBy (xpath="(//a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart'])[4]")
    public WebElement productsBagCart;
    @FindBy (xpath="(//label[@class='product-label label-sale'])[2]")
    public WebElement productsBag;
    @FindBy (xpath="(//*[@class='sticky-content-wrapper'])[2]")
    public WebElement addtoCartButton;
    @FindBy (xpath = "//*[@class='woocommerce-cart-form__cart-item cart_item']")
    public WebElement priceSubTotalProduct;
    @FindBy(xpath = "//*[@id='payment_method_cod']")
    public WebElement payAtTheDoorRadioButon;
    @FindBy(xpath = "//*[@id='place_order']")
    public WebElement placeOrderButon;
    @FindBy(xpath = "//*[text()='Thank you. Your order has been received.']")
    public WebElement orderCompletedText;
    @FindBy (xpath = "//*[@class='woocommerce-ordering toolbox-item toolbox-sort select-box']")
    public  WebElement sortByMove;
    @FindBy (xpath = "(//*[@class='product-label label-new'])[2]")
    public  WebElement arcelikBuzdolabiMove;
    @FindBy (xpath = "(//a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart'])[2]")
    public  WebElement arcelikBuzdolabiChart;
    @FindBy (xpath = "//*[@class='btn btn-sm btn-rounded']")
    public  WebElement viewChart;
    @FindBy (xpath = "//*[@title='Plus']")
    public WebElement quantityPlus;
    @FindBy(xpath = "//*[@title='Minus']")
    public WebElement getQuantityMinus;
    @FindBy (xpath = "//*[@name='update_cart']")
    public WebElement updateChart;
    @FindBy (xpath = "//*[text()='Your cart is currently empty.']")
    public WebElement cartEmpty;
    @FindBy (xpath = "//button[@name='apply_coupon']")
    public WebElement applyCoupon;
    @FindBy(xpath = "//*[@class='woocommerce-shipping-destination']")
    public WebElement shippingCountry;
    @FindBy (xpath = "//*[@id='calc_shipping_city_field']")
    public WebElement shippingCity;
    @FindBy (id = "calc_shipping_state")
    public WebElement shippingState;





    /*US_05 - US_06  -  US_07 (181. ile 299.satır)*/
    @FindBy (xpath = "(//*[text()='My Account'])[1]")
    public WebElement MyAccount;
    @FindBy (xpath = "(//*[text()='Sign In'])[2]")
    public WebElement SignIn;
    @FindBy (xpath = "//*[@id='username']")
    public WebElement username;
    @FindBy (xpath = "(//*[@name='password'])[1]")
    public WebElement Password;
    @FindBy (xpath = "//*[text()='Store Manager']")
    public WebElement StoreManager;
    @FindBy (xpath = "(//*[@class='text'])[4]")
    public WebElement Products;
    @FindBy (xpath = "(//*[text()='Status'])[1]")
    public WebElement statusGorunur;
    @FindBy (xpath = "(//*[text()='Stock'])[1]")
    public WebElement stockGorunur;
    @FindBy (xpath = "(//*[text()='Price'])[1]")
    public WebElement priceGorunur;
    @FindBy (xpath = "(//*[text()='Date'])[1]")
    public WebElement dateGorunur;
    @FindBy (xpath = "(//*[@class='wcfmfa fa-cube'])[3]")
    public  WebElement addNew;
    @FindBy (xpath = "(//*[text()='Virtual'])[1]")
    public WebElement virtualGorunur;
    @FindBy(xpath = "(//*[text()='Downloadable'])[1]")
    public WebElement downloadableGorunur;
    @FindBy (xpath = "//*[@id='pro_title']")
    public WebElement productTitle;

    @FindBy (xpath = "//*[@id='regular_price']")
    public WebElement price;

    @FindBy (xpath = "//*[@id='featured_img_display']")
    public WebElement fotoEkle1;
    @FindBy (xpath = "//*[@class='media-menu-item']")
    public WebElement mediaLibrary;
    @FindBy (xpath = "(//*[@class='attachment save-ready'])[1]")
    public WebElement ilkFotoSec;
    @FindBy (xpath = "//*[@class='button media-button button-primary button-large media-button-select']")
    public WebElement select;
    @FindBy(xpath = "(//*[@class='placeHolder'])[1]")
    public WebElement fotoEkle2;
    @FindBy (xpath = "(//*[@class='attachment-preview js--select-attachment type-image subtype-jpeg landscape'])[10]")
    public WebElement ikinciFotoSec;
    @FindBy (xpath = "(//*[@class='button media-button button-primary button-large media-button-select'])[2]")
    public WebElement addToGallery;
    @FindBy (xpath = "//*[@class='wcfm_product_manager_gallery_fields']")
    public  WebElement fotolarGorunur;
    @FindBy (xpath = "//*[@class='wcfm_product_manager_cats_checklist_fields wcfm_product_taxonomy_product_brand']")
    public  WebElement ProductBrandsGorunur;

    @FindBy (xpath = "//*[@id='excerpt_ifr']")
    public WebElement shortDescription;

    @FindBy (xpath = "(//*[@class='mce-container-body mce-flow-layout'])[3]")
    public WebElement body;

    @FindBy (xpath = "//*[@class='wcfm_product_manager_cats_checklist_fields']")
    public WebElement categoriesGorunur;

    @FindBy (xpath = "(//*[@class='wcfmfa fa-arrow-circle-right sub_checklist_toggler'])[15]")
    public WebElement healtBeauty;
    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[41]")
    public WebElement vitamin;
    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[8]")
    public  WebElement bestSeller;
    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[17]")
    public WebElement electronics;
    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[42]")
    public WebElement homeAndGarden;

    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[52]")
    public WebElement indirimliUrunler;

    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[9]")
    public WebElement booksMusicFilm;

    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[35]")
    public WebElement healtBeautySec;

    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[24]")
    public WebElement fashion;

    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[70]")
    public WebElement toysGames;

    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[1]")
    public WebElement accessories;

    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[79]")
    public WebElement yeniUrunler;

    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_brand '])[7]")
    public WebElement elegantAutoGroup;

    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_brand '])[10]")
    public WebElement greenGrass;

    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_brand '])[23]")
    public WebElement nodeJS;

    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_brand '])[25]")
    public WebElement NS8;

    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_brand '])[31]")
    public WebElement RED;

    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_brand '])[39]")
    public WebElement SkysuiteTech;

    @FindBy (xpath = "(//*[@class='wcfm-checkbox checklist_type_product_brand '])[41]")
    public WebElement Sterling;







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
    @FindBy(xpath = "//*[contains(text(), 'Product Successfully Saved.')]")
    public WebElement successfullyPublishedYazisi;
    @FindBy(xpath = "//p[@class='stock in-stock']")
    public WebElement mevcutStockMiktariPozitifTest;
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
    @FindBy(xpath = "//*[@class='stock available-on-backorder']")
    public WebElement getMevcutStockMiktariNegatifTest;
    @FindBy(xpath = "//*[text()='Do not Allow']")
    public WebElement doNotAllow;
    @FindBy(xpath = "//*[text()='Allow, but notify customer']")
    public WebElement allowButNotifyCustomer;
    @FindBy(xpath = "//*[text()='Allow']")
    public WebElement allow;



    /*US_09(341. ile 379.satır)*/







































    /*US_10(381. ile 419.satır)*/
    @FindBy(xpath = "(//span[@class='wcfmfa fa-cube'])[1]")
    public WebElement product;
    @FindBy(xpath = "(//*[@class='wcfmfa fa-edit text_tip'])[1]")
    public WebElement product_edit;

    @FindBy(xpath = "(//*[@class='fields_collapser attributes_collapser wcfmfa fa-arrow-circle-down'])[1]")
    public WebElement product_attribute_ToggleBlock;

    @FindBy(xpath = "(//*[.='Select all'])[1]")
    public WebElement product_attribute_SelectAll;
    @FindBy(xpath = "(//*[@class='wcfm_submit_button'])[1]")
    public WebElement product_attribute_SelectAll_SubmitButton;
    @FindBy(xpath = "(//*[@class='fields_collapser attributes_collapser wcfmfa fa-arrow-circle-down'])[3]")
    public WebElement product_attribute_ToggleBlockSize;


    @FindBy(xpath = "(//*[.='Add New'])[1]")
    public WebElement product_addNew;
    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[9]")
    public WebElement product_ToptanurunGostermeAyarlari;
    @FindBy(xpath = "//*[@class='piecetype wcfm_title field_61d331d8dc5a9']")
    public WebElement product_ToptanurunGostermeAyarlari_piecetype  ;
    @FindBy(xpath = "//*[@class='unitpercart wcfm_title field_61d33933d88bd']")
    public WebElement product_ToptanurunGostermeAyarlari_UnitsPerPiece  ;
    @FindBy(xpath = "//*[@class='minorderqtytr wcfm_title field_61d33a93da83d']")
    public WebElement product_ToptanurunGostermeAyarlari_MinorderQuantity  ;













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
    @FindBy (xpath ="(//*[@class='select2-search__field'])[3]")
    public WebElement productCategories;
    @FindBy (xpath ="(//*[@class='select2-search__field'])[4]")
    public WebElement excludeCategories;
    @FindBy (xpath ="//*[@id='customer_email']")
    public WebElement sonEmail;
    @FindBy (xpath ="//li[@class='select2-results__option select2-results__option--highlighted']")
    public WebElement choosenProductCategories;
    @FindBy (xpath ="//li[@class='select2-results__option select2-results__option--highlighted']")
    public WebElement choosenProductCategories2;













    /*US_15(581. ile 619)*/
    @FindBy (xpath = "//*[@id='calc_shipping_postcode_field']")
    public WebElement shippingPostCode;
    @FindBy (xpath = "//*[@class='checkout-button button alt wc-forward']")
    public WebElement proceedtoCheckout;
    @FindBy (xpath = "//*[@class='btn btn-dark btn-rounded btn-icon-left continue-shopping mb-4 mr-auto']")
    public WebElement continueShopping;
    @FindBy (xpath = "//*[@name='clear_cart']")
    public WebElement clearChart;
    @FindBy (xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement updateCartDisplayed;





























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
    @FindBy(xpath = "//input[@id=\"bzip\"]") public WebElement billingPostcodeZip;
    @FindBy(xpath = "(//span[@class=\"wcfmfa fa-edit text_tip\"])[1]") public WebElement editCustomerButton;
    @FindBy(xpath = "//input[@id='user_name']") public WebElement usenameBox;
    @FindBy(xpath = "//input[@id=\"user_email\"]") public WebElement emailBox17;
    @FindBy(xpath = "//input[@id=\"bfirst_name\"]") public WebElement firstnameBox;
    @FindBy(xpath = "//input[@id=\"last_name\"]") public WebElement lastnameBox;
    @FindBy(xpath = "//input[@id=\"bcompany_name\"]") public WebElement companynameBox;
    @FindBy(xpath = "//input[@id=\"bphone\"]") public WebElement phoneBox;
    @FindBy(xpath = "//input[@id=\"baddr_1\"]") public WebElement adress1Box;
    @FindBy(xpath = "//input[@id=\"baddr_2\"]") public WebElement adress2Box;
    @FindBy(xpath = "//select[@id=\"bstate\"]") public WebElement stateCountry;
    @FindBy(xpath = "//input[@id=\"bcity\"]") public WebElement cityTown;
    @FindBy(xpath = "//select[@id=\"bcountry\"]") public WebElement country;
    @FindBy(xpath = "//input[@id=\"bzip\"]") public WebElement postcodeZip;
    @FindBy(xpath = "//div//input[@id='same_as_billing']") public WebElement sameAsBillingCheckbox;
    @FindBy(xpath = "//input[@id=\"saddr_1\"]") public WebElement shippingAdress1;
    @FindBy(xpath = "//input[@id=\"saddr_2\"]") public WebElement shippingAdress2;
    @FindBy(xpath = "//select[@id=\"scountry\"]") public WebElement shippingCountryC;
    @FindBy(xpath = "//input[@id=\"scity\"]") public WebElement shippingCityTown;
    @FindBy(xpath = "//input[@id=\"sstate\"]") public WebElement shippingStateCountry;



















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