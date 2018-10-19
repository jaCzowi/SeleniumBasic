package selenium_tests;

import config.TestConfigurationClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 *
 */
public class BasicTest extends TestConfigurationClass {

    @Test
    public void validateInputElement() {
        webDriver.get("https://www.google.com/");
        WebElement searchInput = webDriver.findElement(By.cssSelector("input[title='Szukaj']"));
        searchInput.sendKeys("Spring Framework", Keys.ENTER);
        WebElement searchInfo = webDriver.findElement(By.id("lst-ib"));
        Assert.assertEquals("Spring Framework", searchInfo.getAttribute("value"));
    }
}
