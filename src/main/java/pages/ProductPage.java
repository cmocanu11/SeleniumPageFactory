package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

import java.util.List;

public class ProductPage extends SeleniumWrappers {

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "a[class = 'woocommerce-product-gallery__trigger']") public WebElement galleryTrigger;
    @FindBy(css = "h1[class = 'product_title entry-title']") public WebElement bookTitle;
    @FindBy(css = "span[class = 'woocommerce-Price-amount amount']") public WebElement bookPrice;
    @FindBy(css = "div[class = 'star-rating']") public WebElement starRating;
    @FindBy(css = "div[class = 'woocommerce-product-details__short-description']") public WebElement shortDescription;
    @FindBy(css = "input[class = 'input-text qty text']") public WebElement numberInput;
    @FindBy(css = "button[class *= 'single_add_to_cart_button']") public WebElement addToCartButton;
    @FindBy(css = "div[class = 'product_meta']") public WebElement productMeta;


}
