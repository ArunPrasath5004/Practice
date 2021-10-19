package org.some;

import org.find.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKart_AddToCart extends BaseClass{
	
	public FlipKart_AddToCart() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addToCart;

	public WebElement getAddToCart() {
		return addToCart;
	}
	
	
}
