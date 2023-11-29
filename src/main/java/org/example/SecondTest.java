package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SecondTest {
    private WebDriverWait wait;
    private String id;

    public void startSecondTest (String id, LoginPage loginPage) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        this.wait = wait;
        this.id = id;

        loginPage.login(driver);

        try {
            goToPIM();
            searchForId();
            fillPersonalDetails();

            System.out.println("Test 2 passed");

            driver.close();

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void goToPIM() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/web/index.php/pim/viewPimModule']"))).click();
    }

    public void searchForId() {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("input.oxd-input.oxd-input--active[data-v-1f99f73c]")));

        WebElement idField = elements.get(1);
        idField.sendKeys(this.id);

        clickSearchButton();
        chooseEmployee();
    }

    public void chooseEmployee() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i.oxd-icon.bi-pencil-fill[data-v-bddebfba][data-v-f5c763eb]"))).click();
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space[data-v-10d463b7][data-v-7dc449d6]"))).click();
    }

    public void fillPersonalDetails() {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("input.oxd-input.oxd-input--active")));
        sleepFor(300);

        fillField(elements.get(7), "14789123");
        sleepFor(300);

        fillField(elements.get(8), "2025-05-12");
        sleepFor(300);

        fillField(elements.get(9), "791724");
        sleepFor(300);

        fillField(elements.get(10), "9182738");
        sleepFor(300);

        fillField(elements.get(2), "TestMiddle");
        sleepFor(300);

        fillField(elements.get(4), "TestNickname");
        sleepFor(300);

        fillField(elements.get(6), "01349");
        sleepFor(300);

        List<WebElement> dropDownElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("div.oxd-select-text.oxd-select-text--active")));

        selectDropdown(dropDownElements.get(0));
        sleepFor(300);

        selectDropdown(dropDownElements.get(1));
        sleepFor(300);

        fillField(elements.get(11), "1997-01-25");
        sleepFor(300);

        WebElement radiobutton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.oxd-radio-input.oxd-radio-input--active.--label-right.oxd-radio-input[data-v-7ef819fd]")));
        radiobutton.click();
        sleepFor(300);

        fillField(elements.get(12), "None");
        sleepFor(300);

        saveButtons(0);

        selectDropdown(dropDownElements.get(2));
        sleepFor(300);

        saveButtons(1);

        attachments();
        attachments();

        editFile();
        downloadFile();
        deleteFile();
    }

    private void sleepFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    private void fillField(WebElement element, String text) {
        element.sendKeys(text);
    }

    private void selectDropdown(WebElement dropdown) {
        dropdown.click();
        WebElement dropdownOptions = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.oxd-select-dropdown")));
        dropdownOptions.click();
    }

    private void attachments(){
        WebElement addButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--text[data-v-10d463b7][data-v-3dab643a]")));
        addButton.click();

        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
        String filePath = "C:\\Users\\Aleksej\\Desktop\\_up attack.png";
        fileInput.sendKeys(filePath);
        try {
            saveButtons(2);
        }catch (Exception e){
            System.out.println("Not saved");
        }

    }

    private void editFile(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i.oxd-icon.bi-pencil-fill[data-v-bddebfba][data-v-f5c763eb]"))).click();

        WebElement textarea = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea.oxd-textarea.oxd-textarea--active.oxd-textarea--resize-vertical[data-v-bd337f32]")));
        textarea.click();
        textarea.sendKeys("Edited description");
        saveButtons(2);
    }

    private void deleteFile(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i.oxd-icon.bi-trash[data-v-bddebfba][data-v-f5c763eb]"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin[data-v-10d463b7][data-v-64d94959]"))).click();
    }

    private void downloadFile(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i.oxd-icon.bi-download[data-v-bddebfba][data-v-f5c763eb]"))).click();

        sleepFor(5000);
    }

    private void saveButtons(int index){
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("button[type='submit']")));
        elements.get(index).click();
    }

}
