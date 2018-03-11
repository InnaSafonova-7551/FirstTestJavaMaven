package FirstTest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "\\Users\\Acer\\IdeaProjects\\FirstTest\\src\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.rambler.ru/");
    }
    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.name("login"));
        loginField.sendKeys("innatest");
        System.out.println("введен логин");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("frvbfr2116");
        System.out.println("введен пароль");

        WebElement buttonOk = driver.findElement(By.xpath(".//*[@id=\"app\"]/div/div[1]/div[2]/form/div[3]/div/button"));
        buttonOk.click();
        System.out.println("выполнен вход");

        WebElement profileUser = driver.findElement(By.className("Profile-email-OI"));
        Assert.assertEquals("innatest@rambler.ru", profileUser.getText());
        System.out.println("выполнена идентификация профиля");
    }

    @AfterClass
    public static void tearDown() {
        WebElement logoutButton = driver.findElement(By.className("Profile-exit-2_"));
        logoutButton.click();
        System.out.println("автотест успешно завершен");
        driver.quit();
    }
}


