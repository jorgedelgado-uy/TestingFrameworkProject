package TestFramework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(id="inputImage")
    private WebElement imageInput;

    @FindBy(tagName="textarea")
    private WebElement textAreaInput;

    @FindBy(xpath="//button[contains(text(),'Create Item')]")
    private WebElement createItemButton;

    @FindBy(xpath = "//body/div[@id='content']/div[1]/div[1]/ul[1]/li")
    private List<WebElement> listOfItems;

    private WebElement lastItem;
    private int itemCount;

    private final String ITEM_LIST_XPATH = "//body/div[@id='content']/div[1]/div[1]/ul[1]/li";

    public HomePage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void uploadImage(String filePath){
        wait.until(ExpectedConditions.elementToBeClickable(imageInput));
        imageInput.sendKeys(filePath);
    }

    public void fillDescription(String textDescriptions){
        textAreaInput.sendKeys(textDescriptions);
    }

    public void clickCreateItemButton(){
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfItems));
        itemCount = listOfItems.size();
        wait.until(ExpectedConditions.elementToBeClickable(createItemButton));
        createItemButton.click();
    }

        public String getImageSrcFromLastItem(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath(ITEM_LIST_XPATH), itemCount));
        lastItem = listOfItems.get(listOfItems.size() - 1);
        return lastItem.findElement(By.tagName("img")).getAttribute("src");
    }

    public String getTextFromLastItem(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath(ITEM_LIST_XPATH), itemCount));
        lastItem = listOfItems.get(listOfItems.size() - 1);
        return lastItem.findElement(By.tagName("p")).getText();
    }
}
