package integration;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SimpleCRMS extends BaseTest {

    @Test
    public void main() {
        driver.findElement(By.xpath("//a[@class='signin']")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ADMIN");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin");
        driver.findElement(By.xpath("//a[@id='signin']")).click();

        System.out.println("-------Login successfully-------");
    }
}
