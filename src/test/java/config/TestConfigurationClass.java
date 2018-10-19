package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.Objects;

/**
 * Class for first tests using Selenium WebDiver
 * Basic using Chrome browser
 */
public class TestConfigurationClass {

    protected WebDriver webDriver;

    @BeforeMethod
    public void setupChromeDriverWithOptions() {
        System.setProperty("webdriver.chrome.driver", getAbsoluteVariablePath());
        // System.setProperty("webdriver.chrome.driver", TestConfigurationClass.class.getResource("chromedriver.exe").getFile());
        ChromeOptions chromeOptions = new ChromeOptions()
                .addArguments("start-maximized")
                .addArguments("disable-extensions");
        webDriver = new ChromeDriver(chromeOptions);
    }

    private String getAbsoluteVariablePath() {
        return new File(Objects.requireNonNull(getClass()
                .getClassLoader()
                .getResource("chromedriver.exe"))
                .getFile())
                .getAbsolutePath();
    }

    @AfterMethod
    public void closeCurrentWindowDriver() throws InterruptedException {
        webDriver.quit();
    }
}
