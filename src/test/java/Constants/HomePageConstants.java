package Constants;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import Base.BaseTest;
import java.util.List;

public class HomePageConstants {
    static String app = "com.pozitron.hepsiburada:id/";

    public static By HEPSI_EXPRESS_POPUP_CLOSE = By.id(app + "dialog_close");
    public static By USER_ACCOUNT_BUTTON = By.id(app + "account_icon");
    public static By POP_OVER_DESCRİPTİON = By.id(app + "pop_over_description");
    public static By USER_ACCOUNT_LOGIN_BUTTON = By.id(app + "llUserAccountLogin");
    public static By E_POSTA = By.id(app + "etLoginEmail");
    public static By PASSWORD = By.id(app + "etLoginPassword");
    public static By INFO_POP_UP_CLOSE = By.id("android:id/button2");
    public static By LOGIN_BUTTON = By.id("btnLoginLogin");
    public static By LOGOUT_BUTTON = By.id(app + "ll_user_account_menu_logout");
    public static By CONSTANT_POPUP_OK_BUTTON = By.id("android:id/button1");
    public static By USER_NAME = By.id(app + "tvUserAccountUsername");
    public static By ORDERS_TITLE = By.id(app + "tv_toolbar_title");
    public static By NAME_TEXT_BOX = By.id(app + "etUserFirstName");
    public static By UPDATE_BUTTON = By.id(app + "btnOkSend");
    public static By ORDER_PAGE_USER_ACCOUNT_BUTTON = By.id(app + "iv_toolbar_user_account_menu");
    public static By ORDER_IMAGE = By.id(app + "vp_product_detail_banner");
    public static By ORDER_IMAGE_CLOSE = By.id(app + "ivCloseImageGallery");
    public static By TOOLBAR_TITLE = By.id(app + "tv_toolbar_title");
    public static By FAVORITE_BUTTON = By.id(app + "cb_product_list_item_favourite");
    public static By MY_FAVORITES = By.id(app + "ll_user_account_menu_favorites");
    public static By PRODUCT_NAME = By.id(app + "tv_product_list_item_name");













}
