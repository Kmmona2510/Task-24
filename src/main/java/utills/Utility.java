package utills;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	//create a global variable
	public static WebDriver driver;
	
	public String excelfile;
	public String sheet;
	
	//for browser launch condition for crossbrowser testing
	public void browserLaunch(String browser,String url) {
		
		if(browser.equals("chrome")) {
			driver =new ChromeDriver();
		}else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	//close the browser
	public void closeBrowser() {
		driver.close();
	}
	
	//for find element 
	public void findElement(String attribute,String sendkeysvalue) {
		driver.findElement(By.id(attribute)).sendKeys(sendkeysvalue);
		
	}
	
	//for click the element
	public void click(WebElement clickelement) {
		clickelement.click();
	}
	
	//explicitwait method
	public void explicitWait(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	//excel read method
	public String[][] excelRead() throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\MOORTHI\\eclipse-workspace\\DemoBlaze\\data\\" + excelfile + ".xlsx");
		
		XSSFSheet sheet = book.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		
		int columncount = sheet.getRow(0).getLastCellNum();
			
		
		String[][] data =new String[rowCount][columncount];
		
				
		for(int i=1;i<=rowCount;i++) {
			
		XSSFRow row = sheet.getRow(i);
		
			for(int j=0;j<columncount;j++) {
				
			XSSFCell cell =	row.getCell(j);
			
			data[i-1][j] = cell.getStringCellValue();
			
			
			}
		}
		
		book.close();
		
		return data;
		
		
	}
	
	//screenshot method
	public String getScreenshot(String screenshotname) throws IOException {
		
		String path = "C:\\Users\\MOORTHI\\eclipse-workspace\\DemoBlaze\\Screenshot\\" +screenshotname+ ".png";
		
		TakesScreenshot  screenshot =(TakesScreenshot) driver;
		File source =screenshot.getScreenshotAs(OutputType.FILE);
		File destination = 	new File(path);
		FileUtils.copyFile(source, destination);
		return path;
		
	}
	
	

}
