package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final String username = "Admin";
    private final String password = "admin123";

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        login();
    }

    public void login() {
        WebElement usernameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='username']")));
        usernameInput.sendKeys(username);

        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='password']")));
        passwordInput.sendKeys(password);

        WebElement logInButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[type='submit']")));
        logInButton.click();
    }
}
