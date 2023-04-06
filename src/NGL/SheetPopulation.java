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
		ac = new Actions(driver);
		driver.manage().window().maximize();
		return driver;
	}

	public void LaunchURL() {
		driver.get(const1.URL);

	}
	//div[@id=\"main-menu\"]/ul/li[contains(@class,'expanded')]

	public static final String TR = "//span[text()=\"Teacher\"]";
	public static final String TRmenu = "//span[text()=\"Teacher\"]//following-sibling::ul";
	public String latestMenu=TRmenu;

	public String rootElementsPath = "//div[@id=\"main-menu\"]/ul/li[contains(@class,'expanded')]";
	public String childElementExtension = "/li/ul/child::li";
	
	public void test() throws InterruptedException {
		List<WebElement> test = findRootElements ();
		traverseAllRoot(test);
	}


	public List<WebElement> findRootElements () {
		List<WebElement> rootElements = driver.findElements((By.xpath(rootElementsPath)));

		if (rootElements.isEmpty()) {
			throw new RuntimeException("No Root Element found");
		}
		else {
			return rootElements ;
		}
	}

	public List<WebElement> findChildElements (WebElement element) throws InterruptedException {
		//element += "/ul";
		ac.moveToElement(element).perform();
		//String MenuPath = element.getTagName();
		//MenuPath = "/"+MenuPath+"/ul";
		WebElement MenuPath1 = element.findElement(By.xpath("//following-sibling::ul"));
		
		Thread.sleep(2000);
		List<WebElement> childElements = MenuPath1.findElements(By.xpath(MenuPath1+"/li"));

		if (childElements.isEmpty()) {
			throw new RuntimeException("No Child Element found");
		}
		else {
			return childElements;
		}

	}

	public void traverseAllRoot(List<WebElement> rootElements) throws InterruptedException {
		try {
			for(int r=2; r<=rootElements.size(); r++) {
				WebElement currentRoot = rootElements.get(r);
				List<WebElement> OffSpring= findChildElements(currentRoot);// call a function that will recursively call itself and fetch the list	--> traverseList	
				if(OffSpring.isEmpty()) {
					throw new RuntimeException("No OffSpring found");
				}
				else {
					traverseList(OffSpring);
				}
			}
		}
		finally {}
	}

	public void/*List<WebElement>*/ traverseList(List<WebElement> siblings) throws InterruptedException{
		for(int e=0; e<=siblings.size(); e++) {
			WebElement currentSibling = siblings.get(e);
			List<WebElement> offsprings = findChildElements(currentSibling);
			if (offsprings.isEmpty()) {
				throw new RuntimeException("No OffSprings 2 found");
			}
			else {
				traverseList(offsprings);
			}
		}
	}

/*public void TRListFetch() {
		ac = new Actions(driver);
		WebElement TRsection = driver.findElement(By.xpath(TR));
		ac.moveToElement(TRsection).perform(); // Hover on the Teacher section

		WebElement TRsectionmenu = driver.findElement(By.xpath(TRmenu));	
		List<WebElement> optionList = TRsectionmenu.findElements(By.xpath(TRmenu+"/li")); 
		// Fetching the Main Teacher Resource menu child of teachermenu
		if (optionList.size()!=0) {
		for (int i = 0; i < optionList.size(); i++)
		{
			WebElement current = optionList.get(i);
			ac.moveToElement(current).perform();
			latestMenu += "//following-sibling::ul";
			TRsectionmenu = driver.findElement(By.xpath(latestMenu));	// After this step go to recurrsion
			List<WebElement> optionList = TRsectionmenu.findElements(By.xpath(TRmenu+"/li"));
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
/*}
			catch(Exception e){
				System.out.println("End of list1  "+e);
			}
			finally {
			}
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
	}*/
public void DriverKill() {
	driver.close();
}
}