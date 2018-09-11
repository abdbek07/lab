package lab;


import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test(priority=1)
	public void open() {
		driver.get("https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313.TR12.TRC2.A0.H0.Xbook.TRS0&_nkw=book&_sacat=0");
		
	}
	
	@Test(enabled=false)
	public void radioButton() {
		WebElement radMale = driver.findElement(By.cssSelector("[value='male']"));
		
		if(!(radMale.isSelected())) {
			radMale.click();
		}
		
		assertTrue(radMale.isSelected());
	}
	
	@Test(priority=2)
	public void checkBoxWithJavascriptExecutor() throws InterruptedException {
//		driver.get("https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313.TR12.TRC2.A0.H0.Xbook.TRS0&_nkw=book&_sacat=0");
		String script=null;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[aria-label=\"Used\"]")));
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("document.querySelector('input[aria-label=\"Used\"]').checked=true");
		
	}
	
}
