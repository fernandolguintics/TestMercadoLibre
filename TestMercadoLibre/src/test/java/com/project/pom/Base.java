package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	private WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver ChromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	public WebElement FindElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> FindElements(By locator){
		return driver.findElements(locator);
	}
	
	public String GetText(WebElement element) {
		return element.getText();
	}
	
	public String GetText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void Type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
		
	}
	public void Click(By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean IsDisplayed(By locator) {
		try{
			return driver.findElement(locator).isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException ex) {
			return false;
		}
	}
	
	public void visit(String url) {
		driver.get(url);
	}
}
