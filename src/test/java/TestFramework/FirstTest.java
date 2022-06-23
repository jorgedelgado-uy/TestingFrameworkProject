package TestFramework;

import org.testng.annotations.Test;

public class FirstTest extends BaseTest{

    public FirstTest(){
        super();
    }

    @Test
    public void firstRun() throws InterruptedException {
        _webDriver.navigate().to("https://www.google.com");
        Thread.sleep(10000);
    }

}
