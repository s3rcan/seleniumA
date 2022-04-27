package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public String baseURL;

    // public void setDriver() {
    //   WebDriverManager.chromedriver().setup();
    //   driver = new ChromeDriver();
    //  System.out.println("Chrome");
    //   baseURL = "https://www.gloriajeans.com.tr/";
    //  driver.manage().window().maximize();
    //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}

    public void setDriver(String testBrowser) throws MalformedURLException{

        switch (testBrowser){
            case "grid-firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                driver = new RemoteWebDriver(new URL("http://localhost:4444"), firefoxOptions);
                System.out.println("----- Selenium Grid Chrome ------");
                break;
            }
            case "grid-chrome":{
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                System.out.println("------ Selenium Chrome -----");
                break;
            }
            case "firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                System.out.println("-----Browser is firefox ------");
                break;
            }
            case "firefox-headless": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                System.out.println("---- Browser is firefox-----");
                break;
            }
            case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                driver = new ChromeDriver(chromeOptions);
                System.out.println("--- Browser is chrome headles-----");
                break;
            }
            default:{

                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Users\\anayurt\\AppData\\Local\\Temp\\cef_binary_100.0.24+g0783cf8+chromium-100.0.4896.127_windows64_client\\Release\\cefclient.exe");
                options.addArguments("remote-debugging-port=9222");
                driver = new ChromeDriver(options);

                System.out.println("---- Browser is chrıome-bonigarcia-------");
                break;
            }
        }

        js = (JavascriptExecutor) driver;
        baseURL = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

        driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);


    }

}
