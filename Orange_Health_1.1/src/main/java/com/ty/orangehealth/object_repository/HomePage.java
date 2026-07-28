package com.ty.orangehealth.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy
	private WebElement suptBtn;
	
	@FindBy
	private WebElement testBtn;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSuptBtn() {
		return suptBtn;
	}

	public WebElement getTestBtn() {
		return testBtn;
	}
	
	
	
	
}
