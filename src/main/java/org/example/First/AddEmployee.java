package org.example.First;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class AddEmployee {
    private WebDriver driver;
    private WebDriverWait wait;

    public AddEmployee(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        goToPIM();
        goToAddEmployee();
        addPhoto();
        pressCheckMark();
        fillEmployeeInformation();
        submit();

        Job job = new Job(driver);
    }

    public void goToPIM() {
        WebElement PIM = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/web/index.php/pim/viewPimModule']")));
        PIM.click();
    }

    public void goToAddEmployee() {
        WebElement addEmployeeLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add Employee")));
        addEmployeeLink.click();

    }

    public void addPhoto() {
        WebElement uploadTrigger = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i.oxd-icon.bi-plus")));
        uploadTrigger.click();
        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));

        String filePath = "C:\\Users\\Aleksej\\Desktop\\_up attack.png"; //TODO change to desire one

        fileInput.sendKeys(filePath);
    }

    public void pressCheckMark() {
        WebElement checkMark = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.oxd-switch-input")));
        checkMark.click();
    }

    public void fillEmployeeInformation() {
        WebElement firstName = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='firstName']")));
        firstName.sendKeys("TestName");

        WebElement lastName = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='lastName']")));
        lastName.sendKeys("testLastName");

        WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.oxd-input.oxd-input--active[data-v-1f99f73c=''][autocomplete='off']")));
        username.sendKeys(generateRandomUsername());

        String pass = "testPassword123";
        WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='password']")));
        password.sendKeys(pass);

        WebElement confirmPass = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.oxd-input.oxd-input--active[type='password'][data-v-1f99f73c=''][autocomplete='off']")));
        confirmPass.sendKeys(pass);

    }

    public void submit() {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[type='submit']")));
        button.click();
    }

    public String generateRandomUsername() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder username = new StringBuilder();
        int length = 10;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            username.append(characters.charAt(index));
        }

        return username.toString();
    }

}
