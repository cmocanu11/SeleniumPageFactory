package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BaseTest;

public class JsExecutorExample extends BaseTest {

//    @Test
    public void testJs() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;

//        jse.executeScript("arguments[0].click()",app.navMenu.searchButton);
//        jse.executeScript("arguments[0].value='cooking'",app.navMenu.searchField);
//        jse.executeScript("arguments[0].click()",app.navMenu.searchButton);

//        jse.executeScript("arguments[0].click(), arguments[1].value='cooking', arguments[0].click()"
//                , app.navMenu.searchButton, app.navMenu.searchField);


        jse.executeScript(" document.getElementsByClassName('icon-search')[0].click() ");
        jse.executeScript(" document.getElementsByClassName('search_field')[0].value='cooking' ");
        jse.executeScript(" document.getElementsByClassName('icon-search')[0].click() ");
        Thread.sleep(3000);

        //alternative element.getText()
        String text = jse.executeScript("return document.getElementsByClassName('post_title')[0].childNodes[0].innerHTML").toString();
        System.out.println("+++++++ Book title: " + text );

        //alternativa driver.getTitle()
        String pageTitle = jse.executeScript("return document.title").toString();
        System.out.println("+++++++ Page title: " + pageTitle);

        //alternative driver.getCurrentUrl()
        String pageUrl = jse.executeScript("return document.URL").toString();
        System.out.println("+++++++ Page URL: " + pageUrl);

        jse.executeScript("window.schimbTitlul = function(){document.title='This is a new title'};"
            + "window.schimbTitlul.call();");

        String pageTitleS = jse.executeScript("return document.title").toString();
        System.out.println("+++++++ Page title: " + pageTitleS);
        Thread.sleep(2000);

    }

//    @Test
    public void testJs2() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.navigate().to("https://keyfood.ro/");
        Thread.sleep(3000);
        jse.executeScript("window.location='https://keybooks.ro'");
        Thread.sleep(3000);
//        driver.navigate().back();
        jse.executeScript("window.history.go(-1)");
//        driver.navigate().forward();
        jse.executeScript("window.history.forward(-1)");
//        driver.navigate().refresh();
        jse.executeScript("window.history.go(0)");
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();

        Thread.sleep(3000);

    }

//    @Test
    public void testJs3() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0, 5500)");

        jse.executeScript("document.getElementsByClassName('sc_emailer_button')[0].scrollIntoView()");
        //Scroll down
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //Scroll up
        jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        Thread.sleep(3000);

    }

    @Test
    public void testJs4() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        long startTime = System.currentTimeMillis();
        System.out.println("Start time : " + startTime);

        jse.executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 5000);");

        long endTime = System.currentTimeMillis();
        System.out.println("End time : " + endTime);
        System.out.println("Passed time : " + (endTime - startTime));
    }

}
