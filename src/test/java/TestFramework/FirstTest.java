package TestFramework;

import TestFramework.Pages.HomePage;
import TestFramework.Utils.ConfigurationManager;
import TestFramework.Utils.Utils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{

    private String BASE_URL = ConfigurationManager.getInstance().getConfiguration("BASE_URL");
    private String FILE_PATH = ConfigurationManager.getInstance().getConfiguration("FILE_PATH");
    private String RANDOM_DESCRIPTION = Utils.getRandomText(10);

    public FirstTest(){
        super();
    }

    @Test
    public void CreateANewEntry()  {
        HomePage homePage = new HomePage(_webDriver, new WebDriverWait(_webDriver, 10));
        homePage.getDriver().get(BASE_URL);
        homePage.uploadImage(FILE_PATH);
        homePage.fillDescription(RANDOM_DESCRIPTION);
        homePage.clickCreateItemButton();

        Assert.assertTrue(
                homePage.getImageSrcFromLastItem().contains(Utils.getFileNameFromPath(FILE_PATH))
        );

        Assert.assertTrue(
                homePage.getTextFromLastItem().contains(RANDOM_DESCRIPTION)
        );
    }

}
