package tests.TemaCurs12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

public class TemaJs extends BaseTest {

    String javaScriptHover = "var objObject = document.createEvent('MouseEvents');" +
            "objObject.initMouseEvent('mouseover',true);" +
            "arguments[0].dispatchEvent(objObject);";

    String javaScriptScroll = "arguments[0].scrollIntoView();window.scrollBy(0, -window.innerHeight / 4);";
    String javaScriptClick = "arguments[0].click()";

    @Test
    public void commentTest() throws InterruptedException {
        WebElement header = driver.findElement(By.cssSelector("div.top_panel_middle"));


        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(javaScriptHover,app.navMenu.blogLink);
        jse.executeScript(javaScriptClick,app.navMenu.postFormatsLink);
        jse.executeScript(javaScriptScroll, app.postFormatsPage.galleryFormatLink);
        jse.executeScript(javaScriptClick,app.postFormatsPage.galleryFormatLink);

        WebElement commentArea = driver.findElement(By.cssSelector("textarea[id='comment']"));
        WebElement nameInput = driver.findElement(By.cssSelector("input[id='author']"));
        WebElement emailInput =  driver.findElement(By.cssSelector("input[id='email']"));


        jse.executeScript(javaScriptScroll,commentArea);

        JavaScriptSendKeys("Ceva",commentArea);
        JavaScriptSendKeys("Cosmin",nameInput);
        JavaScriptSendKeys("cosmin@test.ovidiu",emailInput);

        jse.executeScript("document.getElementById('send_comment').click()");
        Thread.sleep(3000);
    }

    public void  JavaScriptSendKeys(String keys, WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value= '" + keys +"'",element);
    }

}
