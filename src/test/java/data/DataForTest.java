package data;

public class DataForTest {
    //Стрелки для каждого пункта
    private final String[] arrowOfQuestion = {
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
    private final String[] pointOfQuestion = {
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
    private final String[] expectedResults = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    public String[] getArrowOfQuestion() {
        return arrowOfQuestion;
    }

    public String[] getPointOfQuestion() {
        return pointOfQuestion;
    }

    public String[] getExpectedResults() {
        return expectedResults;
    }
}
