package page_object_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.SamokatOrderPage;

public class TestOrderOfSamokat extends TestBase {
    private WebDriver driver;

    @Test
    public void checkFirstButtonForOrderSamokat() {
        //Драйвер для Firefox
        //driver = new FirefoxDriver();
        //Драйвер для Chrome
        driver = new ChromeDriver();

        SamokatOrderPage samokatOrderPage = new SamokatOrderPage(driver);

        samokatOrderPage.open();
        samokatOrderPage.clickFirstOrderButton(driver, "Макс", "Максимов",
                "Москва, Кутузовский проспект, 16", 1, "89771112233",
                "20.02.2023", 0, "Позвонить за час");
    }

    @Test
    public void checkSecondButtonForOrderSamokat() {
        //Драйвер для Firefox
        //driver = new FirefoxDriver();
        //Драйвер для Chrome
        driver = new ChromeDriver();

        SamokatOrderPage samokatOrderPage = new SamokatOrderPage(driver);

        samokatOrderPage.open();
        samokatOrderPage.clickSecondOrderButton(driver, "Ирина", "Климова",
                "Москва, Академика  Королева, 32", 224, "89774569988",
                "23.03.2023", 1, "Позвонить");
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
