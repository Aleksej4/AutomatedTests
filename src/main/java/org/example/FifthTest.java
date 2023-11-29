package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FifthTest {

    private WebDriverWait wait;

    public void startFifthTest(LoginPage loginPage){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/definePredefinedReport");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        this.wait = wait;
        loginPage.login(driver);

        try {
            dataFill();
            System.out.println("Test 5 passed");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void dataFill(){
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("html body div#app div.oxd-layout div.oxd-layout-container " +
                        "div.oxd-layout-context div.orangehrm-background-container " +
                        "div.orangehrm-card-container form.oxd-form div.oxd-form-row " +
                        "div.oxd-grid-2.orangehrm-full-width-grid " +
                        "div.oxd-grid-item.oxd-grid-item--gutters " +
                        "div.oxd-input-group.oxd-input-field-bottom-space " +
                        "div input.oxd-input.oxd-input--active"))).sendKeys("TESTING");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("html body div#app div.oxd-layout div.oxd-layout-container " +
                        "div.oxd-layout-context div.orangehrm-background-container " +
                        "div.orangehrm-card-container form.oxd-form div.oxd-form-row " +
                        "div.oxd-grid-4.orangehrm-full-width-grid " +
                        "div.oxd-grid-item.oxd-grid-item--gutters.orangehrm-report-criteria.--span-column-2 " +
                        "div.oxd-input-group.oxd-input-field-bottom-space div div.oxd-select-wrapper"))).click();


        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(), 'Employee Name')]"))).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("html body div#app div.oxd-layout div.oxd-layout-container " +
                "div.oxd-layout-context div.orangehrm-background-container " +
                "div.orangehrm-card-container form.oxd-form div.oxd-form-row " +
                "div.oxd-grid-4.orangehrm-full-width-grid " +
                "div.oxd-grid-item.oxd-grid-item--gutters.orangehrm-report-criteria.--span-column-2 " +
                "div.oxd-input-group div button.oxd-icon-button.orangehrm-report-icon"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("html body div#app div.oxd-layout div.oxd-layout-container " +
                        "div.oxd-layout-context div.orangehrm-background-container " +
                        "div.orangehrm-card-container form.oxd-form div.oxd-form-row " +
                        "div.oxd-grid-4.orangehrm-full-width-grid " +
                        "div.oxd-grid-item.oxd-grid-item--gutters.orangehrm-report-criteria.--span-column-2 " +
                        "div.oxd-input-group.oxd-input-field-bottom-space div div.oxd-select-wrapper"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(), 'Pay Grade')]"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("html body div#app div.oxd-layout div.oxd-layout-container " +
                "div.oxd-layout-context div.orangehrm-background-container " +
                "div.orangehrm-card-container form.oxd-form div.oxd-form-row " +
                "div.oxd-grid-4.orangehrm-full-width-grid " +
                "div.oxd-grid-item.oxd-grid-item--gutters.orangehrm-report-criteria.--span-column-2 " +
                "div.oxd-input-group div button.oxd-icon-button.orangehrm-report-icon"))).click();


        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div.oxd-form-row:nth-child(3) > div:nth-child(2) > div:nth-child(2) " +
                        "> div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) " +
                        "> div:nth-child(1)"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(), 'Current and Past Employees')]"))).click();

    }
}
