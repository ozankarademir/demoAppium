package Tests;

import Base.BaseTest;
import Constants.HomePageConstants;
import io.appium.java_client.*;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static Constants.HomePageConstants.*;

public class LoginTests extends BaseTest {

    @Test
    public void Login() {
        clickButton(INFO_POP_UP_CLOSE);
        clickButton(HEPSI_EXPRESS_POPUP_CLOSE);
        clickButton(POP_OVER_DESCRİPTİON);
        clickButton(USER_ACCOUNT_BUTTON);
        clickButton(USER_ACCOUNT_LOGIN_BUTTON);
        sendKey(E_POSTA, "ozankarademir.92@gmail.com");
        sendKey(PASSWORD, "1907ozan");
        clickButton(LOGIN_BUTTON);
        clickButton(CONSTANT_POPUP_OK_BUTTON);
        Assert.assertTrue(getDriver().findElement(HomePageConstants.USER_NAME).getText().contains("Ozan karademir"));//fonksiyon yapmaya çalış
        clickButton(LOGOUT_BUTTON);
    }

    @Test
    public void changeUserInfo() throws InterruptedException {
        clickButton(INFO_POP_UP_CLOSE);
        clickButton(HEPSI_EXPRESS_POPUP_CLOSE);
        clickButton(POP_OVER_DESCRİPTİON);
        List<MobileElement> elements = getDriver().findElements(MobileBy.id("com.pozitron.hepsiburada:id/bottom_navigation_item_title"));
        elements.get(3).click();
        /*for (MobileElement element:elements){
            if (element.getText().equals("Siparişlerim"))
            {
                element.click();
            }
        }*/
        sendKey(E_POSTA, "ozankarademir.92@gmail.com");
        sendKey(PASSWORD, "1907ozan");
        clickButton(LOGIN_BUTTON);
        getWait().until(ExpectedConditions.presenceOfElementLocated(ORDERS_TITLE));
        Assert.assertTrue(getDriver().findElement(HomePageConstants.ORDERS_TITLE).getText().contains("Siparişlerim"));//fonksiyon yapmaya çalış
        Thread.sleep(2000);
        clickButton(ORDER_PAGE_USER_ACCOUNT_BUTTON);
        clickButton(USER_NAME);
        clearText(NAME_TEXT_BOX);
        sendKey(NAME_TEXT_BOX, "Emre");
        clickButton(UPDATE_BUTTON);
        clickButton(CONSTANT_POPUP_OK_BUTTON);
        Assert.assertTrue(getDriver().findElement(HomePageConstants.NAME_TEXT_BOX).getText().contains("Emre"));//fonksiyon yapmaya çalış
        clearText(NAME_TEXT_BOX);
        sendKey(NAME_TEXT_BOX, "Ozan");// Tekrar eski haline çevirmek için
        clickButton(UPDATE_BUTTON);
    }
    @Test
    public void productDetail() throws InterruptedException {
        clickButton(INFO_POP_UP_CLOSE);
        clickButton(HEPSI_EXPRESS_POPUP_CLOSE);
        clickButton(POP_OVER_DESCRİPTİON);
        swipescreenVertical();
        List<MobileElement> elements = getDriver().findElements(MobileBy.id("com.pozitron.hepsiburada:id/dod_list"));
        elements.get(0).click();
        getWait().until(ExpectedConditions.presenceOfElementLocated(ORDER_IMAGE));
        clickButton(ORDER_IMAGE);
        getWait().until(ExpectedConditions.presenceOfElementLocated(ORDER_IMAGE_CLOSE));
        for (int i = 0; i < 2; i++) {
            swipescreenHorizontal();
        }
        clickButton(ORDER_IMAGE_CLOSE);
        clickButton(TOOLBAR_TITLE);
        swipescreenVertical();
        String product_name = getDriver().findElement(PRODUCT_NAME).getText();
        clickButton(FAVORITE_BUTTON);
        sendKey(E_POSTA, "ozankarademir.92@gmail.com");
        sendKey(PASSWORD, "1907ozan");
        clickButton(LOGIN_BUTTON);
        clickButton(ORDER_PAGE_USER_ACCOUNT_BUTTON);
        clickButton(MY_FAVORITES);
        String favorite_page_product_name=getDriver().findElement(PRODUCT_NAME).getText(); // SUNGURA SOR !!!!!!!!!!!!!1
        Assert.assertEquals(product_name,favorite_page_product_name);
    }

    private void swipescreenVertical() throws InterruptedException {
        TouchAction action = new TouchAction(getDriver());
        action.press(PointOption.point(500,1200)).moveTo(PointOption.point(500,350)).release().perform();
        Thread.sleep(1000);
    }
    private void swipescreenHorizontal() throws InterruptedException {
        TouchAction action = new TouchAction(getDriver());
        action.press(PointOption.point(1000,800)).moveTo(PointOption.point(200,800)).release().perform();
        Thread.sleep(1000);
    }
   /* private void swipescreenVerticalProductDetail() throws InterruptedException {
        Dimension dim = getDriver().manage().window().getSize();
        int height = dim.getHeight();
        int width =dim.getWidth();
        int x =width/2;
        int starty=(int) (height*0.80);
        int endy= (int) (height*0.20);
        TouchAction action = new TouchAction(getDriver());
        action.press(PointOption.point(x,starty)).moveTo(PointOption.point(x,endy)).release().perform();
        Thread.sleep(1000);
    }*/

    public void clickButton(By by){
        getWait().until(ExpectedConditions.presenceOfElementLocated(by));
        getDriver().findElement(by).click();
    }

    public void sendKey(By by, String keys){
        getWait().until(ExpectedConditions.presenceOfElementLocated(by));
        getDriver().findElement(by).sendKeys(keys);
    }

    public void clearText(By by){
        getWait().until(ExpectedConditions.presenceOfElementLocated(by));
        getDriver().findElement(by).clear();
    }

}
