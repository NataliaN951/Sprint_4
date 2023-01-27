package page_object_tests;

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
        samokatMainPage.open();
        samokatMainPage.mainQuestionIsDisplayed(driver);
        samokatMainPage.checkPoint(driver);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
