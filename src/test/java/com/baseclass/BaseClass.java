package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;
	List<WebElement> elementsList;
	private String res;
	
	public String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}
	
	public String getPropertyValues (String key)throws FileNotFoundException, IOException {
		Properties property = new Properties();
		property.load(new FileInputStream("C:\\Users\\rathi\\eclipse-workspace\\FlipkartTask\\Config\\config.properties"));
		Object object = property.get(key);
		String value = (String) object;
		return value;
	}
	
	public void asserttrueAnElementText(WebElement el, String msg) {
		String text = el.getText();
		boolean contains = text.contains(text);
		Assert.assertTrue(msg, contains);
	}
	
	public void assertEqualsAnElement(WebElement el, String msg, String expect) {
		String attribute = el.getAttribute("value");
		Assert.assertEquals(msg, expect , attribute);
	}
		
	public String getCellData(String sheetName, int rowNum, int cellNum) throws IOException {
		
		String res = null;
		File file = new File("C:\\Users\\anith\\eclipse-workspace\\FrameWorkTest1\\Excel sheets\\Login.xlsx"); 
		FileInputStream stream = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellNum);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		
		case STRING:
			res=cell.getStringCellValue();
			break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				java.util.Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YY");
				res = dateFormat.format(dateCellValue);
			} else {
				double actualvalue = cell.getNumericCellValue();
				long round = Math.round(actualvalue);
				if(actualvalue == round) {
					res = String.valueOf(round);
				} else {
					res = String.valueOf(actualvalue);
				}
			}
			break;
		default:
			break;
		}
		return res;
	}
	
	public void updateCellValue(String sheetName, int rowNum, int cellNum, String oldData, String newData) throws IOException {
					
		File file = new File ("C:\\Users\\anith\\eclipse-workspace\\FrameWorkTest1\\Excel sheets\\Login.xlsx");
		FileInputStream instream = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(instream);
		Sheet sheet = w.getSheet("login");
		Row row = sheet.getRow(rowNum);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		if(value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream outstream = new FileOutputStream(file);
		w.write(outstream);
	}
	
	public void createACellAndSetAValue(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		
		File file = new File ("C:\\Users\\anith\\eclipse-workspace\\FrameWorkTest1\\Excel sheets\\Login.xlsx");
		FileInputStream inStream = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(inStream);
		Sheet sheet = w.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		org.apache.poi.ss.usermodel.Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream outStream = new FileOutputStream(file);
		w.write(outStream);
	}

	public Set<String> getAllWindowsID() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	public void elementClear(WebElement element) {
		visibilityOfElement(element);
		element.clear();
	}

	public void dragAndDrop(WebElement s, WebElement d) {
		visibilityOfElement(d);
		visibilityOfElement(s);
		Actions actions = new Actions(driver);
		actions.dragAndDrop(s, d).perform();
	}

	public void elementSendKeysEnter(WebElement element, String data) {
		visibilityOfElement(element);
		element.sendKeys(data, Keys.ENTER);
	}

	public List<String> getAllOptionsText(WebElement element) {
		visibilityOfElement(element);
		List<String> allOptionsText = new ArrayList<>();

		Select select = new Select(element);
		List<WebElement> options = select.getOptions();

		for (WebElement webElement : options) {
			String text = webElement.getText();
			allOptionsText.add(text);
		}
		return allOptionsText;

	}

	public void screenshot(WebElement element, String fileName) throws IOException {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshotAs,
				new File("C:\\Users\\LENOVO\\eclipse-workspace\\FrameworkClass1145AM\\images\\" + fileName + ".png"));
	}

	public void screenshot(String fileName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshotAs,
				new File("C:\\Users\\LENOVO\\eclipse-workspace\\FrameworkClass1145AM\\images\\" + fileName + ".png"));

	}

	public void visibilityOfElement(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToChildWindow() {
		String pWindowName = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();

		for (String eachWindow : windowHandles) {
			if (!pWindowName.equals(eachWindow)) {
				driver.switchTo().window(eachWindow);
			}

		}

	}

	public boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public boolean isSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

	public boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	// 99%--->value fixed
	public String elementGetAttributeValue(WebElement element) {
		visibilityOfElement(element);
		String attribute = null;
		if (isDisplayed(element)) {

			attribute = element.getAttribute("value");
		}
		return attribute;

	}

	// 1%--->D
	public String elementGetAttributeValue(WebElement element, String attributeName) {
		visibilityOfElement(element);
		String attribute = null;
		if (isDisplayed(element)) {

			attribute = element.getAttribute(attributeName);
		}
		return attribute;
	}

	public String elementGetText(WebElement element) {
		visibilityOfElement(element);
		String text = null;
		if (isDisplayed(element)) {

			text = element.getText();
		}
		return text;
	}

	public void implicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void elementSendKeysJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

	}

	public void selectOptionByIndex(WebElement element, int index) {
		visibilityOfElement(element);
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectOptionByValue(WebElement element, String text) {
		visibilityOfElement(element);
		Select select = new Select(element);
		select.selectByValue(text);
	}

	public void selectOptionByText(WebElement element, String text) {
		visibilityOfElement(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void sendkeysusingjs(WebElement element,String data) {
		visibilityOfElement(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
        // Use JavaScript Executor to send keys
        js.executeScript("arguments[0].value = arguments[1];", element, data);		

	}

	public static void browserLaunch(String browserType) {
		switch (browserType) {
		case "CHROME":
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			break;
		case "EDGE":
			driver = new EdgeDriver();
			break;
		case "IE":
			driver = new InternetExplorerDriver();
			break;
		default:
			break;
		}
	}

	public void getApplnUrl(String url) {
		driver.get(url);

	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void elementSendKeys(WebElement element, String data) {
		if (isEnabled(element) && isDisplayed(element)) {
			element.sendKeys(data);
		}
	}

	public void elementClick(WebElement element) {
		visibilityOfElement(element);
		if (isEnabled(element) && isDisplayed(element)) {
			element.click();
		}
	}
	
	public void elementClickByJs(WebElement el) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		visibilityOfElement(el);
		if (isEnabled(el) && isDisplayed(el)) {
			js.executeScript("arguments[0].click();", el);	
		}
	}

	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public String getURLText () {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public WebElement findLocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

	public WebElement findLocatorByCLassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}

	public WebElement findLocatorByXpath(String xpathExp) {
		WebElement element = driver.findElement(By.xpath(xpathExp));
		return element;
	}
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}
	public byte[] takeScreenshot() {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
		
	}
	
	public List<WebElement>elementList(String xpath){
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		return elements;
		
	}
	public void webElementList(List<WebElement>elements) {
		this.elementsList=elements;
	}


}
