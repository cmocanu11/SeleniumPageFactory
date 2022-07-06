package tests;

import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

public class Curs9Ex2 extends BaseTest {

    @Test
    public void exercitiul2(){
        app.navMenu.navigateTo(app.navMenu.shoplink);
        app.shopPage.navigateTo(app.shopPage.cookingWithLoveBook);

        assertTrue(app.productPage.addToCartButton.isDisplayed());
        assertTrue(app.productPage.starRating.isDisplayed());
        assertTrue(app.productPage.productMeta.isDisplayed());
        assertTrue(app.productPage.bookPrice.isDisplayed());
        assertTrue(app.productPage.bookTitle.isDisplayed());
        assertTrue(app.productPage.galleryTrigger.isDisplayed());
        assertTrue(app.productPage.numberInput.isDisplayed());
        assertTrue(app.productPage.shortDescription.isDisplayed());
    }

}
