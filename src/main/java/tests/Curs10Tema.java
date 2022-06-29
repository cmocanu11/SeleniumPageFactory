package tests;

import org.junit.experimental.theories.Theories;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BaseTest;

public class Curs10Tema extends BaseTest {

    @Test
    public void dragAndDrop() throws InterruptedException {
        app.navMenu.hoverElement(app.navMenu.blogLink);
        app.navMenu.navigateTo(app.navMenu.postFormatsLink);
        Actions action = new Actions(driver);

        action.moveToElement(app.postFormatsPage.audioBookTitle);
        app.postFormatsPage.audioBookTitle.click();
        app.postFormatsPage.playPauseButton.click();
//        app.postFormatsPage.playPauseButton.click();
        action.dragAndDropBy(app.postFormatsPage.progressSlider,300,0).build().perform();
        action.moveToElement(app.postFormatsPage.volumeControl)
                .clickAndHold(app.postFormatsPage.volumeControl)
                        .moveByOffset(-50,0)
                                .release().build().perform();
        action.moveToElement(app.postFormatsPage.progressSlider)
                        .clickAndHold(app.postFormatsPage.progressSlider)
                                .moveByOffset(200,0).release().build().perform();
        Thread.sleep(5000);
    }

}
