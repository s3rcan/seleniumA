package tests;

import dto.TestField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import utils.DriverManager;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NMSRelativeLocators extends DriverManager {
    @Parameters("browser")
    @BeforeClass(groups = {"hooks"})
    void beforeClass(@Optional("browser") String browser) throws MalformedURLException {
        setDriver(browser);
    }

    @AfterClass(groups = {"hook"})
    void teardown() {driver.quit();}

   @Test(groups = {"version4"})
    public void relativeLocatorsV4Test() throws InterruptedException  {
        driver.get(baseURL);
        Thread.sleep(3000);
        driver.findElement(By.id("email")).sendKeys("admin");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("123");
        Thread.sleep(2000);
        //driver.findElements(By.tagName("button")).get(4).click();
        driver.findElement(By.xpath("//*[@id=\"single-spa-application:@nms/node-app-auth\"]/div[2]/div/form/div[4]/div/button/span[1]")).click();
        Thread.sleep(2000);
    }

    public void nmsLogin(String input1, String input2, String method) throws InterruptedException  {
        driver.get(baseURL);
        Thread.sleep(3000);
        driver.findElement(By.xpath(input1)).sendKeys("admin");
        Thread.sleep(2000);
        driver.findElement(By.xpath(input2)).sendKeys("123");
        Thread.sleep(2000);
        driver.findElement(By.xpath(method)).click();
        Thread.sleep(2000);
    }

    @Test(groups = {"version4"})
    public void nmsLoginMethod() throws InterruptedException  {
       nmsLogin("//*[@id=\"email\"]", "//*[@id=\"password\"]", "//*[@id=\"single-spa-application:@nms/node-app-auth\"]/div[2]/div/form/div[4]/div/button/span[1]");
    }


    public void dynamicTestMap(TestField testField) throws InterruptedException  {
        StopWatchTime.reset("timer reset");
        StopWatchTime.start("timer started");

        driver.get(baseURL);
        for(int i = 0; testField.getLabelList().size() > i; i++) {
            String field = testField.getLabelList().get(i);
            String value = testField.getValueList().get(i);

            driver.findElement(By.xpath(field)).sendKeys(value);
            Thread.sleep(3000);
        }
        driver.findElement(By.xpath(testField.getMethod())).click();
        Thread.sleep(3000);

        StopWatchTime.stop("timer stopped");
        StopWatchTime.timeTaken();
    }

    @Test(groups = {"version4"})
    public void nmsLoginMapMethod() throws InterruptedException  {
        TestField testField = new TestField();
        List<String> labelList = new ArrayList<>();
        List<String> valueList = new ArrayList<>();

        labelList.add("//*[@id=\"email\"]");
        valueList.add("admin");
        labelList.add("//*[@id=\"password\"]");
        valueList.add("123");

        testField.setLabelList(labelList);
        testField.setValueList(valueList);
        testField.setMethod("//*[@id=\"single-spa-application:@nms/node-app-auth\"]/div[2]/div/form/div[4]/div/button/span[1]");
        dynamicTestMap(testField);
    }

    // "//*[@id=\"email\"]"
    // "//*[@id=\"password\"]"
    // "//*[@id=\"single-spa-application:@nms/node-app-auth\"]/div[2]/div/form/div[4]/div/button/span[1]"
}
