package com.ty.orangehealth.Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
	
	public void rightClick(WebDriver driver,WebElement ele)
	{
		Actions action = new Actions(driver);
		action.contextClick();
	}
	public void scrollToElement(WebDriver driver,WebElement ele)
	{
		Actions action = new Actions(driver);
		action.scrollToElement(ele);
	}
	public void scrollByAmount(WebDriver driver,int x,int y)
	{
		Actions action = new Actions(driver);
		action.scrollByAmount(x, y);
	}
	public void doubleClick(WebDriver driver,WebElement ele)
	{
		Actions action = new Actions(driver);
		action.doubleClick(ele);
	}
	
	public void selectByIndex(WebElement ele,int index)
	{
		Select sel =new Select(ele);
		sel.selectByIndex(index);
	}

}
