package ua.org.autotest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/marya/source/driver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://www.i.ua/n");
    }

    @Test
    public void UserLogin()
    {
        WebElement loginField = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[1]/div[3]/form/ul/li[1]/p[2]/input"));
        loginField.sendKeys("maryna.testing.acc@i.ua");
        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[1]/div[3]/form/ul/li[1]/input"));
        passwordField.sendKeys("123qwerty");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[1]/div[3]/form/p/input"));
        loginButton.click();
        WebElement profileUser = driver.findElement(By.xpath("/html/body/div[1]/div[4]/ul/li[1]/span"));
        String mailUser = profileUser.getText();
        Assert.assertEquals("maryna.testing.acc@i.ua", mailUser);
    }

    @AfterClass
    public static void tearDown()
    {
        WebElement menuUser = driver.findElement(By.xpath("//*[@id=\"header_overall\"]/div[1]/ul[3]/li[3]/span"));
        menuUser.click();
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"accountSettingsPopup\"]/ul/li[7]/a"));
        logoutButton.click();
        driver.quit();
    }

}
