package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.NEW_COMMAND_TIMEOUT;

public class BaseTest {

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    @Before
    public void setUp() throws IOException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.UDID, "BH90Q72Z1L");
        capabilities.setCapability(NEW_COMMAND_TIMEOUT, 10000);
        capabilities.setCapability("skipUnlock", "true");
        capabilities.setCapability("appPackage", "com.pozitron.hepsiburada");
        capabilities.setCapability("appActivity", "com.hepsiburada.ui.startup.SplashActivity");
        //capabilities.setCapability(MobileCapabilityType.APP, "/Users/osungur/Downloads/hepsiburada-3-0-8.apk");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 10);
        System.out.println("test");
    }

    @After
    public void teardown(){
        driver.quit();
    }

    public AndroidDriver getDriver() {
        return (AndroidDriver) driver;
    }

    public void setDriver(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }
}
