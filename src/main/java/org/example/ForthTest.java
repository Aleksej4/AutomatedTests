package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ForthTest {
    private WebDriverWait wait;

    public void startForthTest(LoginPage loginPage){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        this.wait = wait;

        loginPage.login(driver);

        try{
            uploadPost();
            editPost();
            deletePost();

            driver.close();
            System.out.println("Test 4 passed");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void uploadPost(){
        sleepFor(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea.oxd-buzz-post-input"))).sendKeys("Noice");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.oxd-glass-button"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']"))).sendKeys("C:\\Users\\Aleksej\\Desktop\\_up attack.png");

        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--main")));

        WebElement idField = elements.get(2);
        idField.click();
    }

    public void editPost(){
        sleepFor(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i.oxd-icon.bi-three-dots"))).click();
        sleepFor(1000);

        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("li.orangehrm-buzz-post-header-config-item")));

        WebElement edit = elements.get(1);
        edit.click();

        sleepFor(2000);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']"))).sendKeys("C:\\Users\\Aleksej\\Desktop\\_up walk.png");

        List<WebElement> elements2 = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--main")));

        WebElement button = elements2.get(2);
        button.click();
    }

    public void addComment(){
        sleepFor(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.orangehrm-buzz-post-body-picture"))).click();
        sleepFor(1000);
        WebElement comment = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.oxd-input.oxd-input--active[placeholder='Write your comment...'][data-v-1f99f73c='']")));
        comment.sendKeys("some comments");
        comment.sendKeys(Keys.ENTER);
    }

    public void deletePost(){
        sleepFor(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i.oxd-icon.bi-three-dots"))).click();
        sleepFor(1000);

        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("li.orangehrm-buzz-post-header-config-item")));

        WebElement delete = elements.get(0);
        delete.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin[data-v-bddebfba][data-v-10d463b7]"))).click();


    }
    private void sleepFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
