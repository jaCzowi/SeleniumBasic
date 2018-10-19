package selenium_tests;

import config.TestConfigurationClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Test for auto-complete and validate form page
 *
 * @see <a href="http://toolsqa.com/automation-practice-form/">Practise Form</a>
 * Configuration class for driver {@link  TestConfigurationClass}
 */

public class PractiseFormTest extends TestConfigurationClass {

    private Random randomNumber;

    private void loadPageAndInitField() {
        webDriver.get("http://toolsqa.com/automation-practice-form/");
        randomNumber = new Random();
    }

    @Test
    public void shouldCompleteTestForm() throws InterruptedException {
        // SET UP
        this.loadPageAndInitField();

        //BEGIN TEST 
        WebElement fName = webDriver.findElement(By.cssSelector("input[name='firstname']"));
        fName.sendKeys("Wiktor");

        WebElement lName = webDriver.findElement(By.cssSelector("input[name='lastname']"));
        lName.sendKeys("Najlepszy");

        WebElement genderBtn = webDriver.findElement(By.id("sex-0"));
        genderBtn.click();

        //Experience 
        this.selectExpYearBtn();

        WebElement dateLabel = webDriver.findElement(By.id("datepicker"));
        dateLabel.sendKeys(
                new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
                        .format(Calendar.getInstance().getTime()));

        //PROFESSION SELECT
        this.selectProfessionChBox();
        // FILE UPLOADING 
        this.uploadFileFromResource();

        // AUTOMATION TOOLS
        this.selectAutomationTools();

        Select countries = new Select(webDriver.findElement(By.id("continents")));
        countries.selectByIndex(randomNumber.nextInt(6));
        // to show changes
        Thread.sleep(2000);

        //SELENIUM COMMANDS 
        this.selectSeleniumCommands();

        // SUBMIT and END
        WebElement submitBtn = webDriver.findElement(By.id("submit"));
        submitBtn.click();

    }

    private void selectExpYearBtn() {
        List<WebElement> expYearBtns = webDriver.findElements(By.name("exp"));
        WebElement selectedExpBtn = expYearBtns.get(randomNumber.nextInt(6));
        selectedExpBtn.click();
    }

    private void selectProfessionChBox() {
        List<WebElement> professionChBox = webDriver.findElements(By.name("profession"));
        for (WebElement webEl : professionChBox) {
            if (webEl.getAttribute("value").equalsIgnoreCase(this.generateRandomProfession())) {
                webEl.click();
            }
        }
    }

    private void selectSeleniumCommands() {
        Select commandHandler = new Select(webDriver.findElement(By.name("selenium_commands")));
        List<WebElement> selComands = commandHandler.getOptions();

        for (WebElement webElement : selComands) {
            if (webElement.getText().equalsIgnoreCase("WebElement Commands")) {
                webElement.click();
                break;
            }
        }
    }

    private void selectAutomationTools() {
        List<WebElement> automationTools = webDriver.findElements(By.name("tool"));
        automationTools.stream()
                .filter(t -> t.getAttribute("value").equalsIgnoreCase("Selenium Webdriver") || t.getAttribute("value").equalsIgnoreCase("Selenium IDE"))
                .collect(Collectors.toList())
                .forEach(WebElement::click);
    }

    private void uploadFileFromResource() {
        WebElement uploadElement = webDriver.findElement(By.id("photo"));
        File file = new File(getClass().getClassLoader().getResource("testfile.txt").getFile());
        uploadElement.sendKeys(file.getAbsolutePath());
        uploadElement.sendKeys();

    }

    private String generateRandomProfession() {
        int i = randomNumber.nextInt(15) + 1;
        return i >= 8 ? "Automation Tester" : "Manual Tester";
    }

    @AfterMethod
    @Override
    public void closeCurrentWindowDriver() throws InterruptedException {
        Thread.sleep(6000);
        super.closeCurrentWindowDriver();
    }
}
