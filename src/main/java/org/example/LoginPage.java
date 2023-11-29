package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final String username = "Admin";
    private final String password = "admin123";


    public void login(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement usernameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='username']")));
        usernameInput.sendKeys(username);

        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='password']")));
        passwordInput.sendKeys(password);

        WebElement logInButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[type='submit']")));
        logInButton.click();
    }
}
