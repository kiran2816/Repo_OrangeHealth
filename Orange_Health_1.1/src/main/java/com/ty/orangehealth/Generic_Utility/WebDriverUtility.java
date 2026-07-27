package com.ty.orangehealth.Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility 
{
	public void dragAndDrop(WebDriver driver,WebElement ele1,WebElement ele2)
	{
		Actions action =new Actions(driver);
		action.dragAndDrop(ele1, ele2).perform();;
	}
	
	public void clickAndHold(WebDriver driver,WebElement ele1)
	{
		Actions action = new Actions(driver);
		action.clickAndHold(ele1).perform();;
	}

}
