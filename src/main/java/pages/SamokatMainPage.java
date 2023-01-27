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
    String[] arrowOfQuestion = {
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"
    };
    //Текст для каждого пункта
    String[] pointOfQuestion = {
            "[id='accordion__panel-0'] p",
            "[id='accordion__panel-1'] p",
            "[id='accordion__panel-2'] p",
            "[id='accordion__panel-3'] p",
            "[id='accordion__panel-4'] p",
            "[id='accordion__panel-5'] p",
            "[id='accordion__panel-6'] p",
            "[id='accordion__panel-7'] p"
    };
    //Ожидаемый текст для каждого пункта
    String[] expectedResults = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

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
    public void checkPoint(WebDriver driver) {
        for (int i = 0; i < expectedResults.length; i++) {
            WebElement element = driver.findElement(By.id(arrowOfQuestion[i]));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(By.id(arrowOfQuestion[i])).click();
            String actualPoint = driver.findElement(By.cssSelector(pointOfQuestion[i])).getText();
            Assert.assertEquals(expectedResults[i], actualPoint);
        }
    }
}
