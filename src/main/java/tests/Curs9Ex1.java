package tests;

import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

public class Curs9Ex1 extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        app.navMenu.navigateTo(app.navMenu.shoplink);
        app.shopPage.filterByValue("price");
        Thread.sleep(3000);
        Double pret = app.shopPage.getPriceOfItem(0);
        Double pret2 = app.shopPage.getPriceOfItem(app.shopPage.price.size()-1);
        boolean bol = pret < pret2;
        assertTrue(bol);
    }
}
