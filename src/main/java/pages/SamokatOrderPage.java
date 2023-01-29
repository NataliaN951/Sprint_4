package pages;

import org.openqa.selenium.*;

public class SamokatOrderPage {
    private final WebDriver driver;
    //Верхняя кнопка Заказать
    private final By firstOrderbutton = By.xpath(".//button[@class='Button_Button__ra12g']");
    //Нижняя кнопка Заказать
    private final By secondOrderbutton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка для куки
    private final By cookiesButton = By.xpath(".//button[@id='rcc-confirm-button']");
    //Заголовок Для кого самокат
    private final By titleOfFirstOrderForm = By.xpath(".//div[@class='Order_Header__BZXOb'][text()='Для кого самокат']");
    //Поле Имя
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Поле Фамилия
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле Адрес
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле Станция метро
    private final By stationField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Название станции метро
    private final By stationName = By.className("select-search__row");
    //Поле Телефон
    private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private final By nextButton = By.xpath(".//button[text()='Далее']");
    //Заголовок Про аренду
    private final By titleOfSecondOrderForm = By.xpath(".//div[@class='Order_Header__BZXOb'][text()='Про аренду']");
    //Поле Когда привезти самокат
    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле Срок аренды
    private final By periodField = By.xpath(".//div[@class='Dropdown-placeholder']");
    //Срок аренды в списке
    private final By period = By.xpath(".//div[@class='Dropdown-option'][1]");
    //Чек-бокс цвет
    private final By colour = By.xpath(".//label[@class ='Checkbox_Label__3wxSf']");
    //Поле Комментарий для курьера
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка заказать
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //заголовок Хотите оформить заказ
    private final By confirmOrder = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ'][text()='Хотите оформить заказ?']");
    //Кнопка Да
    private final By yesButton = By.xpath(".//button[text()='Да']");
    //Заголовок заказ оформлен
    private final By order = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ'][text()='Заказ оформлен']");

    public SamokatOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        String url = "https://qa-scooter.praktikum-services.ru/";
        driver.get(url);
    }

    public void clickFirstOrderButton(
            WebDriver driver, String name, String surname, String address,
            int stationIndex, String phone, String orderDate, int colourIndex, String comments) {
        driver.findElement(cookiesButton).click();
        driver.findElement(firstOrderbutton).click();
        checkFirstScreenForOrderSamokat(driver, name, surname, address, stationIndex, phone);
        checkSecondScreenForOrderSamokat(driver, orderDate, colourIndex, comments);
        checkConfirmOrder(driver);
        checkOrderInformation(driver);
    }

    public void clickSecondOrderButton(
            WebDriver driver, String name, String surname, String address,
            int stationIndex, String phone, String orderDate, int colourIndex, String comments) {
        driver.findElement(cookiesButton).click();
        WebElement element = driver.findElement(secondOrderbutton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(secondOrderbutton).click();
        checkFirstScreenForOrderSamokat(driver, name, surname, address, stationIndex, phone);
        checkSecondScreenForOrderSamokat(driver, orderDate, colourIndex, comments);
        checkConfirmOrder(driver);
        checkOrderInformation(driver);
    }

    public void checkFirstScreenForOrderSamokat(
            WebDriver driver, String name, String surname, String address, int stationIndex, String phone) {
        driver.findElement(titleOfFirstOrderForm).isDisplayed();

        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(stationField).click();
        WebElement element = driver.findElements(stationName).get(stationIndex);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        driver.findElement(phoneField).sendKeys(phone);

        driver.findElement(nextButton).click();
    }

    public void checkSecondScreenForOrderSamokat(
            WebDriver driver, String orderDate, int colourIndex, String comments) {
        driver.findElement(titleOfSecondOrderForm).isDisplayed();

        driver.findElement(dateField).sendKeys(orderDate, Keys.ENTER);
        driver.findElement(periodField).click();
        driver.findElement(period).click();
        WebElement element = driver.findElements(colour).get(colourIndex);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        driver.findElement(commentField).sendKeys(comments);

        driver.findElement(orderButton).click();
    }

    public void checkConfirmOrder(WebDriver driver) {
        driver.findElement(confirmOrder).isDisplayed();
        driver.findElement(yesButton).click();
    }

    public void checkOrderInformation(WebDriver driver) {
        driver.findElement(order).isDisplayed();
    }
}
