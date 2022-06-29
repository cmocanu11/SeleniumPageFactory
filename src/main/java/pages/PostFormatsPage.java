package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class PostFormatsPage extends SeleniumWrappers {

    public PostFormatsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[title='Search for:']") public WebElement searchField;
    @FindBy(xpath = "//a[contains(text(),'Audio post')]") public WebElement audioBookTitle;
    @FindBy(css = "span[class='mejs-time-handle']") public WebElement progressSlider;
    @FindBy(css = "div[class='mejs-horizontal-volume-current']") public WebElement volumeControl;
    @FindBy(css = "div[class*='mejs-playpause-button']") public WebElement playPauseButton;

}
