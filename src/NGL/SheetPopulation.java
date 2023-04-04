package NGL;
import NGL.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

//import common.WebDriverWait;

//import MarkProject.WebElement;

public class SheetPopulation {
	protected WebDriver driver;
	protected String siteUri;
	final String dir = System.getProperty("user.dir");
	Actions ac;
	Constants const1 = new Constants();
		
public WebDriver driverCall( ) {
		
		System.setProperty("webdriver.chrome.driver", dir + "\\src\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

public void LaunchURL() {
	driver.get(const1.URL);
	
}

	public static final String TR = "//span[text()=\"Teacher\"]";
	public static final String TRmenu = "//span[text()=\"Teacher\"]//following-sibling::ul";
	

	
		
	public void TRListFetch() {
		ac = new Actions(driver);
		WebElement TRsection = driver.findElement(By.xpath(TR));
		ac.moveToElement(TRsection).perform(); // Hover on the Teacher section
		
		WebElement TRsectionmenu = driver.findElement(By.xpath(TRmenu));	
		List<WebElement> optionList = TRsectionmenu.findElements(By.xpath(TRmenu+"/li")); // Fetching the Main Teacher Resource menu

		for (int i = 0; i < optionList.size(); i++)
		{
			WebElement current = optionList.get(i);
			ac.moveToElement(current).perform();

			System.out.println(current.getText());
			
		try {
				System.out.println("Inside Try1 ");

				AllListTravers(current);
				System.out.println("End of Try1 ");

			/*	List<WebElement> optionList1 = current.findElements(By.xpath("/li/ul/child::li"));
				for (int j = 0; j < optionList1.size(); j++)
				{
					System.out.print(optionList1.get(j).getText());
				}*/
			}
			catch(Exception e){
				System.out.println("End of list1  "+e);
			}
			finally {
			}
		}
	}
	public void AllListTravers(WebElement current) {
		WebElement TRsectionmenu1 = current.findElement(By.xpath(TRmenu+"/li/ul"));	
		List<WebElement> optionList1 = TRsectionmenu1.findElements(By.xpath("/li/ul/child::li"));
		//WebElement TRsectionmenu = driver.findElement(By.xpath(TRmenu));	
		System.out.println(optionList1.size());
		for (int j = 0; j < optionList1.size(); j++)
		{
			//current = optionList1.get(j);
			//ac.moveToElement(current).perform();
			System.out.println(optionList1.get(j).getText());
			try {
				System.out.println("Insixed Try2 ");
			//AllListTravers(current);
			System.out.println("End of Try ");
			}
			catch(Exception e){
				System.out.println("End of list  "+e);
			}
			finally {
				
			}
		}
	}
	public void DriverKill() {
		driver.close();
	}
}