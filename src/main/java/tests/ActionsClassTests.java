package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.AssertJUnit.*;

public class ActionsClassTests extends BaseTest {

//    @Test
    public void hoverElement() throws InterruptedException {

        app.navMenu.hoverElement(app.navMenu.loginPopUp);
        Thread.sleep(3000);

        app.navMenu.hoverElement(app.navMenu.blogLink);
        Thread.sleep(3000);
        app.navMenu.navigateTo(app.navMenu.postFormatsLink);
        assertTrue(app.navMenu.checkCurrentUrl("https://keybooks.ro/category/post-formats/"));
    }

//    @Test (priority = 1)
    public void sendKeys() throws InterruptedException {

        Actions action = new Actions(driver);

        action.moveToElement(app.postFormatsPage.searchField)
                .keyDown(Keys.SHIFT)
                .sendKeys(app.postFormatsPage.searchField,"abracadabra")
                .perform();
        Thread.sleep(5000);
    }
//    @Test
    public void sendKeysExample2() throws InterruptedException {
        app.navMenu.navigateTo(app.navMenu.contactsLink);
        Actions action = new Actions(driver);

        action.moveToElement(app.contactsPage.nameInput)
                .sendKeys(app.contactsPage.nameInput,"Numele meu")
                .sendKeys(Keys.TAB,"abc@abc.com")
                .sendKeys(Keys.TAB,"Subiectul meu")
                .sendKeys(Keys.TAB,"Mesajul meu")
                .sendKeys(Keys.TAB, Keys.ENTER)
                .perform();
        Thread.sleep(5000);
    }

//    @Test
    public void dragAndDrop() throws InterruptedException {
        app.navMenu.navigateTo(app.navMenu.shoplink);
        app.shopPage.dragAndDrop(app.shopPage.sliderInitialPosition, 60, 0);
        app.shopPage.dragAndDrop(app.shopPage.sliderFinalPosition, -50,0);
        Thread.sleep(3000);
    }

    @Test
    public void moveByOffset() throws InterruptedException {
        app.navMenu.navigateTo(app.navMenu.contactsLink);
        int x = app.contactsPage.nameInput.getLocation().getX();
        System.out.println("X : "+ x);
        int y = app.contactsPage.nameInput.getLocation().getY();
        System.out.println("Y : "+ y);
        Actions action = new Actions(driver);

        action.moveByOffset(x,y).click().sendKeys("Test").perform();
        Thread.sleep(3000);

    }
}
