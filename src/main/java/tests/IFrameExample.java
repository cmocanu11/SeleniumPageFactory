package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.TestNgListener;

import java.util.ArrayList;
import java.util.List;

@Listeners(TestNgListener.class)
public class IFrameExample extends BaseTest {

    @Test
    public void iframeExampleTest() throws InterruptedException {
        app.navMenu.navigateTo(app.navMenu.contactsLink);
        Thread.sleep(3000);
        app.contactsPage.click(app.contactsPage.zoomIn);
        Thread.sleep(3000);
    }

    @Test
    public void iframeExampleTest2() throws InterruptedException {
        app.navMenu.navigateTo(app.navMenu.eventsLink);
        app.eventsPage.click(app.eventsPage.festivalOfOldFilmsLink);
        app.singleEventPage.clickMap();

        System.out.println(driver.getWindowHandles());
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        driver.findElement(By.id("searchboxinput")).clear();
        driver.findElement(By.id("searchboxinput")).sendKeys("Cluj");
        driver.findElement(By.id("searchbox-searchbutton")).click();
        Thread.sleep(3000);
        driver.close();
        Thread.sleep(3000);
    }
//    @Test
    public void openNewTab() throws InterruptedException {
        Thread.sleep(5000);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.open('https://keyfood.ro/','_blank')");
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        driver.switchTo().window(browserTabs.get(0));
        driver.get("https://www.sport.ro");
        Thread.sleep(5000);

    }
}
