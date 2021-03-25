package com.telran.qa.second;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://www.google.com/");
    }

    @Test
    public void testGoogleSearch() {
        type(By.name("q"), "WebDriver" + Keys.ENTER);
        click(By.cssSelector("[href='https://www.selenium.dev/documentation/en/webdriver/']"));
        back();
        //Assert
    }

    @Test
    public void testSearchImg() {
        type(By.name("q"), "Java" + Keys.ENTER);
        click(By.cssSelector("[data-hveid='CAEQAw']"));
    }

    public int multy(int a, int b){
        return a*b;
    }

    @Test(enabled = false)
    public void myTest(){
        int res = multy(2,5);
        System.out.println(res);
        Assert.assertEquals(res, 10);
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }

    //_____________________________________________
    private void back() {
        wd.navigate().back();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

}
