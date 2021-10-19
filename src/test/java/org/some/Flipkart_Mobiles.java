package org.some;

import java.util.List;

import org.find.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flipkart_Mobiles extends BaseClass{
	
	public Flipkart_Mobiles() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@class='_4rR01T'])")
	private List<WebElement> allMoblies;
	

	public List<WebElement> getallMoblies() {
		return allMoblies;
	}

	
	
}
