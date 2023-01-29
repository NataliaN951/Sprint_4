package page_object_tests;

import data.DataForTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SamokatMainPage;

public class TestMainQuestionOfSamokatMainPage extends TestBase {
    private WebDriver driver;

    @Test
    public void checkMainQuestion() {
        driver = new ChromeDriver();

        SamokatMainPage samokatMainPage = new SamokatMainPage(driver);
        DataForTest dataForTest = new DataForTest();
        samokatMainPage.open();
        samokatMainPage.mainQuestionIsDisplayed(driver);
        samokatMainPage.checkPoint(driver, dataForTest.getExpectedResults(), dataForTest.getArrowOfQuestion(), dataForTest.getPointOfQuestion());
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
