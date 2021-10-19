package org.find;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void browserLaunch(String browserName) {
		switch (browserName) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
			break;

		default:
			break;
		}
		
	}
	
	public static void get(String url) {
		driver.get(url);
		
	}
	
	public static String geturl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public static String titleGet() {
		String title = driver.getTitle();
		return title;
	}
	
	public static WebElement elementFind(String value,String locator) {
		
		WebElement a=null;
		
		if (value.equals("id")) {
			a = driver.findElement(By.id(locator));	
		}
		else if (value.equals("name")) {
			a = driver.findElement(By.name(locator));
		}
		else if (value.equals("xpath")) {
			a = driver.findElement(By.xpath(locator));
		}
		return a;
		
	}
	
	public static void sendValues(WebElement element,String value) {
		element.sendKeys(value);
		
	}
	
	public static void clickBtn(WebElement element) {
		element.click();
	}
	
	public static void browserClose() {
		driver.quit();
	}
	
	public static String getTheText(WebElement element) {
		String text = element.getText();
		return text;
		
	}
	
	public static String getTheAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
		
	}
	
	public static void dropElements(WebElement element,String value) {
		
		Select as=new Select(element);
		as.selectByValue(value);
	}
	
	public static void popUps(String opt) {
		
		Alert alert = driver.switchTo().alert();
		
		if (opt.equals("accept")) {
			alert.accept();
		}
		else if (opt.equals("dismiss")) {
			alert.dismiss();
		}
		else if (opt.equals("prompt")) {
			alert.sendKeys("Yes");
			alert.accept();
		}
	}
	
	public static void windowHandle(int index) {
		
		Set<String> window = driver.getWindowHandles();
		List<String> ln=new ArrayList<String>(window);
		
		driver.switchTo().window(ln.get(index));
	}
	
	public static void screenShot(String filename) throws IOException {
		
		TakesScreenshot tk=(TakesScreenshot)driver;
		
		File temp = tk.getScreenshotAs(OutputType.FILE);
		File perm = new File("./src/test/resources/Snaps"+filename+".png");
		
		FileUtils.copyFile(temp, perm);
	}
	
	public static void javaScriptSet(String text,WebElement element) {
		
		JavascriptExecutor jv=(JavascriptExecutor)driver;
		
		jv.executeScript("arguments[0].setAttribute('value','"+text+"');",element );
	}
	
	public static Object javeScriptGet(WebElement element) {
	
		JavascriptExecutor jv=(JavascriptExecutor)driver;
		
		Object value = jv.executeScript("return arguments[0].getAttribute('value');", element);
		return value;
	}
	
	
	public static void timeWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static void frameSwitch(int index) {
		
		driver.switchTo().frame(index);
	}
	
	public static void frameOut(String opt) {
		
		if (opt.equals("back")) {
			driver.switchTo().parentFrame();
		}
		else if (opt.equals("out")) {
			driver.switchTo().defaultContent();
		}
	}
	
	public static String driven(String fileName,String sheetName,int rIndex,int cIndex) throws IOException {
		
		File f=new File("./src/test/resources/Excel"+fileName+".xlsx");
		
		FileInputStream st=new FileInputStream(f);
		
		Workbook wk=new XSSFWorkbook(st);
		
		Sheet sheet = wk.getSheet(sheetName);
		Row row = sheet.getRow(rIndex);
		Cell cell = row.getCell(cIndex);
		
		int type = cell.getCellType();
		
		String value=null;
		if (type==1) {
			value = cell.getStringCellValue();
		}
		else {
		if (DateUtil.isCellDateFormatted(cell)) {
			SimpleDateFormat sm=new SimpleDateFormat("dd-MMM-yyyy");
			Date dt = cell.getDateCellValue();
			value = sm.format(dt);
		}
		else {
			double num = cell.getNumericCellValue();
			long ln=(long)num;
			value = String.valueOf(ln);
		}
		}
		return value;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
