package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.First.AddEmployee;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        LoginPage loginPage = new LoginPage(driver);
        AddEmployee addEmployee = new AddEmployee(driver);


    }
}
