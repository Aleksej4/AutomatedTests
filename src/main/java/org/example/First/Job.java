package org.example.First;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Job {

    private WebDriver driver;
    private WebDriverWait wait;

    public Job (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        goToJob();
        fillJobData();
    }

    public void goToJob(){
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.orangehrm-tabs-item[href*='/pim/viewJobDetails/']")));
        button.click();
    }

    public void fillJobData(){
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("div.oxd-select-text-input[data-v-67d2aedf=''][tabindex='0']")));

        WebElement joinedDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.oxd-input.oxd-input--active[placeholder='yyyy-mm-dd'][data-v-1f99f73c=''][data-v-4a95a2e0='']")));
        joinedDate.sendKeys("2023-11-18");

        WebElement jobTitle = elements.get(0);
        jobTitle.click();
        WebElement jobTitleDropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.oxd-select-dropdown")));
        jobTitleDropDown.click();

        WebElement jobCategory = elements.get(1);
        jobCategory.click();
        WebElement jobCategoryDropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.oxd-select-dropdown")));
        jobCategoryDropDown.click();

        WebElement location = elements.get(3);
        location.click();
        WebElement locationDropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.oxd-select-dropdown")));
        locationDropDown.click();

        WebElement employmentStatus = elements.get(4);
        employmentStatus.click();
        WebElement employmentStatusDropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.oxd-select-dropdown")));
        employmentStatusDropDown.click();
    }
}
