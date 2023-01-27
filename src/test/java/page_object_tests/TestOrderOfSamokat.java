package page_object_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        samokatOrderPage.clickFirstOrderButton(driver);
        samokatOrderPage.checkFirstScreenForOrderSamokat(
                driver, "Макс", "Максимов", "Москва, Кутузовский проспект, 16", "89771112233");
        samokatOrderPage.checkSecondScreenForOrderSamokat(driver, "20.02.2023", "Позвонить за час");
        samokatOrderPage.checkConfirmOrder(driver);
        samokatOrderPage.checkOrderInformation(driver);
    }

    @Test
    public void checkSecondButtonForOrderSamokat() {
        //Драйвер для Firefox
        //driver = new FirefoxDriver();
        //Драйвер для Chrome
        driver = new ChromeDriver();

        SamokatOrderPage samokatOrderPage = new SamokatOrderPage(driver);

        samokatOrderPage.open();
        samokatOrderPage.clickSecondOrderButton(driver);
        samokatOrderPage.checkFirstScreenForOrderSamokat(
                driver, "Ирина", "Климова", "Москва, Академика  Королева, 32", "89774569988");
        samokatOrderPage.checkSecondScreenForOrderSamokat(driver, "20.02.2023", "Позвонить");
        samokatOrderPage.checkConfirmOrder(driver);
        samokatOrderPage.checkOrderInformation(driver);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
