package selenium_tests;

import config.TestConfigurationClass;
import models.PractiseTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Test for extracting data from practise-table
 *
 * @see <a href="http://toolsqa.com/automation-practice-table/">Practise Table</a>
 * Configuration class for driver  {@link  TestConfigurationClass}
 */
public class PractiseTableTest extends TestConfigurationClass {

    private PractiseTable practiseTableModel;

    private void setUpPage() {
        webDriver.get("http://toolsqa.com/automation-practice-table/");
        practiseTableModel = new PractiseTable();
    }

    @Test
    public void shouldFetchDataFromTable() {
        this.setUpPage();

        // setup Headers
        List<WebElement> headers = webDriver.findElements(By.cssSelector("table[summary='Sample Table'] tbody tr"));
        for (WebElement wD : headers) {
            practiseTableModel.setStructureToList(wD.findElement(By.cssSelector("th")).getText());
        }
        for (int col = 1; col <= 5; col++) {
            for (int row = 1; row < 5; row++) {
                switch (col) {
                    case 1:
                        String eachCountry = webDriver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + row + "]/td[" + col + "]")).getText();
                        practiseTableModel.setCountryToList(eachCountry);
                        break;
                    case 2:
                        String eachCity = webDriver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + row + "]/td[" + col + "]")).getText();
                        practiseTableModel.setToCityList(eachCity);
                        break;
                    case 3:
                        String eachHeight = webDriver
                                .findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + row + "]/td[" + col + "]"))
                                .getText();
                        practiseTableModel.setHeightToList(eachHeight);
                        break;
                    case 4:
                        String eachBuiltDate = webDriver
                                .findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + row + "]/td[" + col + "]"))
                                .getText();
                        practiseTableModel.setDateBuilt(eachBuiltDate);
                        break;
                    case 5:
                        String eachRank = webDriver
                                .findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + row + "]/td[" + col + "]"))
                                .getText();
                        practiseTableModel.setRank(eachRank);
                        break;
                }
            }
        }
        // ENDS and Validate
        practiseTableModel.printTable();
        assertEquals(4, practiseTableModel.getCityList().size());
        assertEquals(Optional.of(1), java.util.Optional.ofNullable(practiseTableModel.getRankList().get(0)));
        assertEquals("509m", practiseTableModel.getHeightList().get(2));
    }
}
