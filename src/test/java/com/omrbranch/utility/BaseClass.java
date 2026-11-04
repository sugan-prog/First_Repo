package com.omrbranch.utility;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.time.Duration;

import java.util.ArrayList;

import java.util.List;

import java.util.Properties;

import java.util.Set;



import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Alert;

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

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.safari.SafariDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {
	public static WebDriver driver;



private static final Logger logger = LogManager.getLogger(BaseClass.class);



Select select;

TakesScreenshot takesScreenshot;

Actions actions;

Alert alert;



public byte[] screenshot() {

logger.info("Capturing browser screenshot");

byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

logger.info("Screenshot captured successfully");

return screenshot;

}



public static void browserLaunch(String browserType) {

logger.info("Launching browser: {}", browserType);



try {

switch (browserType.toUpperCase()) {

case "CHROME":

driver = new ChromeDriver();

break;



case "FIREFOX":

driver = new FirefoxDriver();

break;



case "EDGE":

driver = new EdgeDriver();

break;



case "SAFARI":

driver = new SafariDriver();

break;



default:

throw new IllegalArgumentException("Unsupported browser: " + browserType);

}



logger.info("Browser launched successfully");



} catch (RuntimeException e) {

logger.error("Browser launch failed", e);

throw e;

}

}



public static String getProjectPath() {

String property = System.getProperty("user.dir");

logger.debug("Project path: {}", property);

return property;

}



public static String getPropertyFileValue(String key) throws IOException {



logger.debug("Reading property for key: {}", key);



Properties properties = new Properties();



String path = getProjectPath() + "/src/test/resources/config/config.properties";



try (FileInputStream file = new FileInputStream(path)) {

properties.load(file);

} catch (IOException e) {

logger.error("Failed to read properties file", e);

throw e;

}



String value = properties.getProperty(key);



if (value == null) {

logger.warn("Property key not found: {}", key);

} else {

logger.debug("Property loaded successfully: {}", key);

}



return value;

}



public void sendKeysElementJS(WebElement element, String data) {

logger.info("Entering text using JavaScript");



JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;



javascriptExecutor.executeScript("arguments[0].value = arguments[1];", element, data);



logger.info("JavaScript text entry completed");

}



public void dismissAlert() {

logger.info("Dismissing alert");

alert = driver.switchTo().alert();

alert.dismiss();

logger.info("Alert dismissed successfully");

}



public void acceptAlert() {

logger.info("Accepting alert");

alert = driver.switchTo().alert();

alert.accept();

logger.info("Alert accepted successfully");

}



public void dragAndDropElement(WebElement sourceElement, WebElement destElement) {



logger.info("Performing drag and drop");



actions = new Actions(driver);

actions.dragAndDrop(sourceElement, destElement).perform();



logger.info("Drag and drop completed");

}



public void screenshot(File destFile, WebElement element) throws IOException {



logger.info("Taking element screenshot");



File sourceFile = element.getScreenshotAs(OutputType.FILE);



FileUtils.copyFile(sourceFile, destFile);



logger.info("Element screenshot saved: {}", destFile.getPath());

}



public void screenshot(File destFile) throws IOException {

logger.info("Taking browser screenshot");



takesScreenshot = (TakesScreenshot) driver;



File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);



FileUtils.copyFile(sourceFile, destFile);



logger.info("Browser screenshot saved: {}", destFile.getPath());

}



public void visibilityOfElement(WebElement element) {

logger.debug("Waiting for element visibility");



WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));



driverWait.until(ExpectedConditions.visibilityOf(element));



logger.debug("Element is visible");

}



public static void implicitWait() {

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));



logger.info("Implicit wait set to 30 seconds");

}



public void implicitWait(int secs) {

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));



logger.info("Implicit wait set to {} seconds", secs);

}



public void switchToChildWindo() {

logger.info("Switching to child window");



String windowHandle = driver.getWindowHandle();

Set<String> windowHandles = driver.getWindowHandles();



for (String eachWindowId : windowHandles) {

if (!windowHandle.equals(eachWindowId)) {

driver.switchTo().window(eachWindowId);

logger.info("Switched to child window");

break;

}

}

}



public List<String> getAllOptionsTextFromDropdown(WebElement element) {



logger.debug("Getting all dropdown options");



List<String> allOptionsText = new ArrayList<String>();



select = new Select(element);



List<WebElement> options = select.getOptions();



for (WebElement webElement : options) {

String text = webElement.getText();

allOptionsText.add(text);

}



logger.info("Dropdown options retrieved. Count: {}", allOptionsText.size());



return allOptionsText;

}



public String getTextElement(WebElement element) {

String text = element.getText();



logger.debug("Element text retrieved");



return text;

}



public void selectOptionByIndex(WebElement element, int index) {

logger.info("Selecting dropdown by index: {}", index);



select = new Select(element);

select.selectByIndex(index);

}



public void selectOptionByValue(WebElement element, String text) {

logger.info("Selecting dropdown by value");



select = new Select(element);

select.selectByValue(text);

}



public void selectOptionByText(WebElement element, String text) {

logger.info("Selecting dropdown by visible text");



select = new Select(element);

select.selectByVisibleText(text);

}



public static void enterApplicationUrl(String url) {

logger.info("Navigating to application URL");



driver.get(url);



logger.info("Application navigation completed");

}



public static void maximizeWindow() {

driver.manage().window().maximize();



logger.info("Browser window maximized");

}



public void sendKeysElement(WebElement element, String data) {

logger.info("Entering text into element");



if (isEnabledElement(element) && isDisplayedElement(element)) {



clearTextBoxElement(element);

element.sendKeys(data);



logger.info("Text entered successfully");



} else {

logger.warn("Element is not enabled or displayed");

}

}



public void sendKeysElementEnter(WebElement element, String data) {

logger.info("Entering text and pressing Enter");



element.sendKeys(data, Keys.ENTER);



logger.info("Enter key action completed");

}



public void clickElement(WebElement element) {

logger.info("Clicking element");



visibilityOfElement(element);



if (isEnabledElement(element) && isDisplayedElement(element)) {



element.click();



logger.info("Element clicked successfully");



} else {

logger.warn("Element is not enabled or displayed");

}

}



public static void closeAllBrowser() {

logger.info("Closing all browser windows");



driver.quit();



logger.info("Browser closed successfully");

}



public String getApplicationTitle() {

String title = driver.getTitle();



logger.info("Application title: {}", title);



return title;

}



public String getApplicationUrl() {

String currentUrl = driver.getCurrentUrl();



logger.debug("Application URL retrieved");



return currentUrl;

}



public void clearTextBoxElement(WebElement element) {

element.clear();



logger.debug("Text box cleared");

}



public WebElement findLocatorById(String attributeValue) {

logger.debug("Finding element by ID: {}", attributeValue);



WebElement element = driver.findElement(By.id(attributeValue));



return element;

}



public WebElement findLocatorByName(String attributeValue) {

logger.debug("Finding element by name: {}", attributeValue);



WebElement element = driver.findElement(By.name(attributeValue));



return element;

}



public WebElement findLocatorByClassName(String attributeValue) {

logger.debug("Finding element by class name: {}", attributeValue);



WebElement element = driver.findElement(By.className(attributeValue));



return element;

}



public WebElement findLocatorByXpath(String exp) {

logger.debug("Finding element by XPath: {}", exp);



WebElement element = driver.findElement(By.xpath(exp));



return element;

}



public boolean isDisplayedElement(WebElement element) {

boolean displayed = element.isDisplayed();



logger.debug("Element displayed: {}", displayed);



return displayed;

}



public boolean isEnabledElement(WebElement element) {

boolean enabled = element.isEnabled();



logger.debug("Element enabled: {}", enabled);



return enabled;

}



public boolean isSelectedElement(WebElement element) {

boolean selected = element.isSelected();



logger.debug("Element selected: {}", selected);



return selected;

}



public String getDomPropertyValue(WebElement element) {

String domProperty = element.getDomProperty("value");



logger.debug("DOM value property retrieved");



return domProperty;

}



public String getDomPropertyValue(WebElement element, String attributeName) {



String domProperty = element.getDomProperty(attributeName);



logger.debug("DOM property retrieved: {}", attributeName);



return domProperty;

}

}



