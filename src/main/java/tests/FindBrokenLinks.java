package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FindBrokenLinks extends BaseTest {

    @Test
    public void findBrokenLinks() throws IOException {

        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("Total links : "+ links.size());
        for (WebElement link:links) {
            String url = link.getAttribute("href");
            if(url == null){
                continue;
            }
            System.out.println(url);
            checkLinks(url);
        }

    }

    public static void checkLinks(String urlLink) throws IOException {
        try {
            URL url = new URL(urlLink);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(2000);
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode() == 200 ){
                System.out.println(urlLink + " - " + httpURLConnection.getResponseMessage());
            }
            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND ){
                System.out.println(urlLink + " - " + httpURLConnection.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
