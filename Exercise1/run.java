import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HelloWorld");
		
		//Step1: Visit Amazon.com webpage
		System.setProperty("webdriver.chrome.driver", "/Users/sathu/Downloads/chromedriver"); 
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.amazon.com/");  
		
		
		//Step2: Search for a book
		String book="qa testing for beginners";
		WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
		searchBoxElement.sendKeys(book);
		searchBoxElement.sendKeys(Keys.RETURN);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		//Step3: Click on 1st item in the listed results.
		WebElement firstResultElement = driver.findElement(By.className("s-result-item"));
		firstResultElement.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//System.out.print(firstResultElement.getText());//getText());
		//firstResultElement.click();
		
		//Step4: Get the price of first item.
		WebElement priceElement = driver.findElement(By.id("newBuyBoxPrice"));
		String firstBookPriceString = priceElement.getText();
		assert firstBookPriceString.equalsIgnoreCase("$47.49") : 0;
		//Assert price as expected
		
		
		//Step5: Add item to cart
		WebElement addToCartButtonElement = driver.findElement(By.id("add-to-cart-button"));
		addToCartButtonElement.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step6: Assert price before checkout
		/*WebElement priceBeforeCheckoutElement = driver.findElement(By.className("a-color-price.hlb-price.a-inline-block.a-text-bold"));
		String priceBeforeCheckoutString = priceBeforeCheckoutElement.getText();
		System.out.print(priceBeforeCheckoutString);*/
		
		
		//Step7: Proceed to checkout
		WebElement checkoutElement = driver.findElement(By.id("hlb-ptc-btn-native"));
		checkoutElement.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.quit();
	}

}
