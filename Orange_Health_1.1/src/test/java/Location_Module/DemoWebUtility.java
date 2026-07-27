package Location_Module;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ty.orangehealth.Generic_Utility.WebDriverUtility;

public class DemoWebUtility {
	@Test
	public void clickandhold()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/clickHold?sublist=0");
		WebElement ele = driver.findElement(By.id("circle"));
		
		WebDriverUtility wu=new WebDriverUtility();
		wu.clickAndHold(driver, ele);
		
		
	}

	@Test
	public void draganddrop()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/drag-and-drop");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement source = driver.findElement(By.id("column-a"));
		WebElement target = driver.findElement(By.id("column-b"));
		
		WebDriverUtility wu=new WebDriverUtility();
		wu.dragAndDrop(driver,source, target);	
	}

}
