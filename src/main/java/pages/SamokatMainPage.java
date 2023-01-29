package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SamokatMainPage {
    private final WebDriver driver;
    //Заголовок Вопросы о важном
    private final By blockOfMainQuestion = By.xpath(".//div[@class='Home_SubHeader__zwi_E'][text()='Вопросы о важном']");
    //Стрелки для каждого пункта

    public SamokatMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        String url = "https://qa-scooter.praktikum-services.ru/";
        driver.get(url);
    }

    //Выпадающий список в разделе «Вопросы о важном». Тебе нужно проверить:
    //когда нажимаешь на стрелочку, открывается соответствующий текст.

    //Раздел «Вопросы о важном» отображается
    public void mainQuestionIsDisplayed(WebDriver driver) {
        driver.findElement(blockOfMainQuestion).isDisplayed();
    }

    //Проверка пунктов раздела Вопросы о важном
    public void checkPoint(WebDriver driver, String[] expectedResults, String[] arrowOfQuestion, String[] pointOfQuestion) {
        for (int i = 0; i < expectedResults.length; i++) {
            WebElement element = driver.findElement(By.id(arrowOfQuestion[i]));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(By.id(arrowOfQuestion[i])).click();
            String actualPoint = driver.findElement(By.cssSelector(pointOfQuestion[i])).getText();
            Assert.assertEquals(expectedResults[i], actualPoint);
        }
    }
}
