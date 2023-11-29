package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ThirdTest {
    private WebDriverWait wait;

    public void startThirdTest(LoginPage loginPage){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        this.wait = wait;

        loginPage.login(driver);

        try{
            dataFill();
            shortlist();
            interview();

            driver.close();
            System.out.println("Test 3 passed");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void dataFill(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[1]//div//div//div//div[2]//div[1]//div[2]//input"))).sendKeys("Test");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[1]//div//div//div//div[2]//div[2]//div[2]//input"))).sendKeys("TestMiddle");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[1]//div//div//div//div[2]//div[3]//div[2]//input"))).sendKeys("TestLast");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[2]//div//div//div//div[2]//div//div"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Associate IT Manager')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[3]//div//div[1]//div//div[2]//input"))).sendKeys("testing@gmail.com");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[3]//div//div[2]//div//div[2]//input"))).sendKeys("+7000000000");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[4]//div//div//div//div//div[2]//input"))).sendKeys("C:\\Users\\Aleksej\\Desktop\\LogsBankingSystem\\Survey.pdf");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[5]//div//div[1]//div//div[2]//input"))).sendKeys("some keywords");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[6]//div//div//div//div[2]//textarea"))).sendKeys("just notes");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[8]//button[2]"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".oxd-form-loader")));

    }

    public void shortlist(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div[1]//form//div[2]//div[2]//button[2]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[2]//div//div//div//div[2]//textarea"))).sendKeys("some notes");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[3]//button[2]"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".oxd-form-loader")));

    }

    public void interview(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div[1]//form//div[2]//div[2]//button[2]"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.oxd-input.oxd-input--active")));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[2]//div//div[1]//div//div[2]//input"))).sendKeys("interview");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[2]//div//div[2]//div//div//div[2]//div//div//input"))).sendKeys("Odis");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Odis  Adalwin')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[2]//div//div[3]//div//div[2]//div//div//input"))).sendKeys("2023-11-30");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[2]//div//div[4]//div//div[2]//div//div[1]//input"))).sendKeys("07:00 PM");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[2]//div//div[5]//div//div[2]//textarea"))).sendKeys("notesTest");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div//div[1]//div[2]//div[2]//div//div//form//div[3]//button[2]"))).click();
    }

}
