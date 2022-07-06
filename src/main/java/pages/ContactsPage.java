package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class ContactsPage extends SeleniumWrappers {

    public ContactsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[name='your-name']") public WebElement nameInput;
    @FindBy(css = "button[title='Zoom in']") public WebElement zoomIn;
    @FindBy(css = "button[title='Zoom out']") public WebElement zoomOut;
    @FindBy(tagName = "iframe") public WebElement mapIframe;

    public void zoomMap(WebElement zoom){
        driver.switchTo().frame(mapIframe);
        click(zoom);
    }


}
