package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.*;
import utils.DriverManager;

import java.net.MalformedURLException;

public class WindowHandling extends DriverManager {

    @Parameters("browser")
    @BeforeClass(groups = {"hook"})
    void beforeClass(@Optional("browser") String browser) throws MalformedURLException {
        setDriver(browser);
    }

    @AfterClass(groups = {"hook"})
    void teardown() {driver.quit();}

    @Test(groups = {"version4"})
    public void windowHandlingV4Test() throws  InterruptedException {
        driver.get(baseURL);

        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("unal.sercann@gmail.com");
        Thread.sleep(3);
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
        Thread.sleep(3);
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("");
        Thread.sleep(3);
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
        Thread.sleep(3);
        driver.quit();
    }
}
