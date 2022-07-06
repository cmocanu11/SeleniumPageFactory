package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.SeleniumWrappers;

import java.util.List;

public class ShopPage extends SeleniumWrappers {

    Select selectDropDown;

    public ShopPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "span[style='left: 0%;']") public WebElement sliderInitialPosition;
    @FindBy(css = "span[style='left: 100%;']") public WebElement sliderFinalPosition;
    @FindBy(name = "orderby") public WebElement dropDown;
    @FindBy(xpath = "//span/span[@class='woocommerce-Price-amount amount']") public List<WebElement> price;

    @FindBy(linkText = "Cooking with love") public WebElement cookingWithLoveBook;

    public void filterByValue(String value){
        selectDropDown = new Select(dropDown);
        selectDropDown.selectByValue(value);
    }

    public Double getPriceOfItem(int itemNumber){
        return Double.valueOf(price.get(itemNumber).getText().substring(1));
    }

    public void navigateTo(WebElement element){
        click(element);
    }
}
