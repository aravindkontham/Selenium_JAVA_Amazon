
package Test;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Automate {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();

        // Verifying
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());

        // Search for "mobile"
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("mobile");
        searchBox.submit();

        // Apply filter for 4 stars
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fourStarsFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='p_72/1318476031']/span/a/section/i")));
        fourStarsFilter.click();

        // Wait for results and click the first result
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2")));
        firstResult.click();

        // Switch to the new window
        Set<String> windows = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();
        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Add to cart and handle possible interruptions
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']")));
        addToCartButton.click();


        // Go to cart
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")));
        cart.click();
   
    }
}
