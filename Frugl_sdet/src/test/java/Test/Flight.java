package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.expedia.com/");
		String currentUrl = driver.getCurrentUrl();
        String pageTitle = driver.getTitle();
        System.out.println("URL: " + currentUrl);
        System.out.println("Title: " + pageTitle);
     // Click on the language selector and choose "India" and "English"
        WebElement languageButton = driver.findElement(By.xpath("//*[@id=\"app-layer-base\"]/div[2]/div[1]/header/div/section/div/div/div[2]/button"));
        languageButton.click();
        WebElement regionIndia = driver.findElement(By.xpath("//a[contains(text(),'India')]"));
        regionIndia.click();
        WebElement languageEnglish = driver.findElement(By.xpath("//button[contains(text(),'English')]"));
        languageEnglish.click();
        

        // Click on the Flights tab
        WebElement flightsTab = driver.findElement(By.xpath("//a[@href='/Flights']"));
        flightsTab.click();
      //*[@id="multi-product-search-form-1"]/div/div/div/div/div[1]/ul/li[2]/a/span
	}
	
	

}
