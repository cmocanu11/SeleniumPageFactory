package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class SingleEventPage extends SeleniumWrappers {

    public SingleEventPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "iframe") public WebElement mapFrame;
    @FindBy(partialLinkText = "map") public WebElement showMap;

    public void clickMap(){
        hoverElement(mapFrame);
        driver.switchTo().frame(mapFrame);
        click(showMap);
    }
}
