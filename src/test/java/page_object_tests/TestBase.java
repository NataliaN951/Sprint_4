package page_object_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;

public class TestBase {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
}
