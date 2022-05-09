package cef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CefForWindows {
    public static void main(String[] args) {
        //Path to the ChromeDriver executable.
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        //Path to the CEF executable.
        options.setBinary("C:\\work\\cef_binary_101.0.15+gca159c5+chromium-101.0.4951.54_windows64_client\\Release\\cefclient.exe");
        //Port to communicate on. Required starting with ChromeDriver v2.41.
        options.addArguments("remote-debugging-port=9222");

        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.google.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("hehe");


        driver.quit();
    }
}
