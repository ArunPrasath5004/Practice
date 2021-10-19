package org.some;

import org.find.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKart_Search extends BaseClass {
	
	public FlipKart_Search() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement popUp;
	
	@FindBy(name="q")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement search;

	public WebElement getPopUp() {
		return popUp;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearch() {
		return search;
	}
	
	
	

}
