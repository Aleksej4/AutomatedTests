package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();

        //FirstTest firstTest = new FirstTest();
        //firstTest.startFirstTest(loginPage);
        //String id = firstTest.getId();

        //SecondTest secondTest = new SecondTest();
        //secondTest.startSecondTest(id, loginPage);

        //ThirdTest thirdTest = new ThirdTest();
        //thirdTest.startThirdTest(loginPage);

        //ForthTest forthTest = new ForthTest();
        //forthTest.startForthTest(loginPage);

        FifthTest fifthTest = new FifthTest();
        fifthTest.startFifthTest(loginPage);
    }
}
