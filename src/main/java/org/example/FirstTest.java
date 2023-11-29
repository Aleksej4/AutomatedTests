package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FirstTest {

    private WebDriverWait wait;
    private String id;
    public void startFirstTest(LoginPage loginPage){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        this.wait = wait;
        loginPage.login(driver);

        try {
            pim();
            addEmployee();
            checkBox();
            fillInfo();
            job();
            report();
            employeeList();

            System.out.println("Test 1 passed");
            driver.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public String getId(){
        return id;
    }
    public void pim (){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("PIM"))).click();
    }

    public void addEmployee(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add Employee"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")))
                .sendKeys("C:\\Users\\Aleksej\\Desktop\\_up attack.png");
    }

    public void checkBox(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.oxd-switch-input"))).click();
    }

    public void fillInfo(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='firstName']"))).sendKeys("TestName");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='lastName']"))).sendKeys("testLastName");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.oxd-input.oxd-input--active[data-v-1f99f73c=''][autocomplete='off']"))).sendKeys(generateRandomString(10));

        employeeId();

        String pass = "testPassword123";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='password']"))).sendKeys(pass);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.oxd-input.oxd-input--active[type='password'][data-v-1f99f73c=''][autocomplete='off']"))).sendKeys(pass);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[type='submit']"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h6.oxd-text.oxd-text--h6.orangehrm-main-title[data-v-7b563373][data-v-b6d78ace]")));
    }

    public void employeeId() {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("input.oxd-input.oxd-input--active[data-v-1f99f73c]")));

        WebElement idField = elements.get(4);
        String generatedId = generateRandomString(3);
        idField.sendKeys(generatedId);
        this.id = idField.getAttribute("value");
    }

    public void job(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.orangehrm-tabs-item[href*='/pim/viewJobDetails/']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Job')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//div//div[2]//div[1]//form//div[1]//div//div[1]//div//div[2]//div//div//input"))).sendKeys("2023-11-24");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//div//div[2]//div[1]//form//div[1]//div//div[7]//div//div[2]//div//div"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Full-Time Permanent')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//div//div[2]//div[1]//form//div[1]//div//div[5]//div//div[2]//div//div//div[1]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Administration')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
    }

    public void report(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Report-to')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//div//div[2]//div[2]//div[1]//div//button"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Type for hints...']"))).sendKeys("Odis");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Odis  Adalwin')]"))).click();
    }

    public void employeeList(){
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Employee List"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div[1]//div[2]//form//div[1]//div//div[1]//div//div[2]//div//div//input"))).sendKeys("Joseph Robinette Biden");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div[1]//div[2]//form//div[1]//div//div[3]//div//div[2]//div//div//div[1]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Full-Time Permanent')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div[1]//div[2]//form//div[1]//div//div[5]//div//div[2]//div//div//input"))).sendKeys("Odis");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Odis  Adalwin')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div[1]//div[2]//form//div[2]//button[2]"))).click();
    }

    public String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder username = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            username.append(characters.charAt(index));
        }

        return username.toString();
    }
}
