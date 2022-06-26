package tests.properties;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void browserTest(){
        String browser =System.getProperty("browser");
        System.out.println(browser);
    }

    @Test
    @Tag("test1")
    void propTest() {
        String browser = System.getProperty("browser", "safari");
        String browserVersion = System.getProperty("version", "100");
        String browserSize = System.getProperty("browserSize", "1920x1080");

        System.out.println(browser);
        System.out.println(browserVersion);
        System.out.println(browserSize);

    }
}
