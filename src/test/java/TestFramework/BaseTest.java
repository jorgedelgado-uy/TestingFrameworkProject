package TestFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest
{
    protected WebDriver _webDriver;
    private final String localDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/%s";

    @BeforeClass
    public void initialize(){
        System.setProperty("webdriver.chrome.driver", String.format(localDriverPath, "chromedriver.exe"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        _webDriver = new ChromeDriver(chromeOptions);
    }

    @AfterClass
    public void tearDown(){
        _webDriver.close();
    }

}
