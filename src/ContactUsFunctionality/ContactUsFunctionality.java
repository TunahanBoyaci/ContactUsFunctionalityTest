package ContactUsFunctionality;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ContactUsFunctionality extends BaseDriver {
    @Test
    @Parameters({"message","username","password"})
    public void contactUsTest(String message,String username,String password){
        login(username,password);

        WebElement contactButton = driver.findElement(By.xpath("//a[text()='Contact Us']"));
        contactButton.click();

        WebElement enquiryInbox = driver.findElement(By.cssSelector("textarea[id='input-enquiry']"));
        enquiryInbox.sendKeys(message);

        WebElement subButton = driver.findElement(By.cssSelector("input[value='Submit']"));
        subButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));
    }
}
