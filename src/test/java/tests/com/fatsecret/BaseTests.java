package tests.com.fatsecret;

import com.fatsecret.driver.AppiumDriverManager;
import com.fatsecret.steps.StepsAll;
import com.fatsecret.steps.StepsAssert;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import properties.Properties;

import java.net.MalformedURLException;

public class BaseTests {
    protected AppiumDriver driver;
    protected StepsAll stepsAll;
    protected StepsAssert stepsAssert;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        AppiumDriverManager.initAndroid(Properties.mainProperties.fatsecretPackage(), Properties.mainProperties.fatsecretStartupActivity(),
                Properties.mainProperties.deviceEmulatorPixel());
        driver = AppiumDriverManager.getDriver();
        stepsAll = new StepsAll(driver);
        stepsAssert = new StepsAssert(driver);
    }

    @AfterEach
    public void tearDown() {
        AppiumDriverManager.killCurrentDriver();
    }
}