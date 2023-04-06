package NGL;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Functions {

	Constants c = new Constants();
	Locators l = new Locators();

	protected WebDriver driver;
	Actions action = new Actions(driver);

	public void initiateDriver(String driverPath) {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void visitSite(String url) {
		driver.get(url);
	}

	public void login(String username, String password) {
		driver.findElement(By.xpath(l.UserName)).sendKeys(username);
		driver.findElement(By.xpath(l.Password)).sendKeys(password);
		driver.findElement(By.xpath(l.LoginBtn)).click();
	}

	public List<WebElement> findRootElements () {
		List<WebElement> rootElements = driver.findElements(By.xpath(l.rootElements));

		if (rootElements.isEmpty()) {
			throw new RuntimeException("No Root Element found");
		}
		else {
			return rootElements ;
		}
	}

	public void findChildElements (WebElement element) {

		ac.moveToElement(element).perform();
		Thread.sleep(2000);
		List<WebElement> childElements = element.findElements(By.xpath(l.childElementExtension));

		if (childElements.isEmpty()) {
			return False;
		}
		else {
			return childElements;
		}

	}

	public void traverseAllRoot(List<WebElement> rootElements) {
		try {
			for(int r=0; r<=rootElements.size(); r++) {
				currentRoot = rootElements.get(r);
				// call a function that will recursively call itself and fetch the list	--> traverseList	
			}
		}
		
	public List<WebElement> traverseList(List<WebElement> siblings){
		for(int e=0; e<=siblings; e++) {
			currentSibling = siblings.get(e)
			offsprings = findChildElements(currentSibling);
			if (offsprings) {
				traverseList(offsprings)
			}
			else {
				System.out.println("No Child Element Found");
			}
		}
	}
	

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
