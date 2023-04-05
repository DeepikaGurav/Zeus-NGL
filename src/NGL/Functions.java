package NGL;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Functions {

	Constants c = new Constants();
	Locators l = new Locators();

	protected WebDriver driver;

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

	public void findChildElements (List<WebElement> elements) {
		
		List<WebElement> rootElements = driver.findElements(By.xpath(l.rootElements));
		
		if (rootElements.isEmpty()) {
			throw new RuntimeException("No Root Element found");
		}
		else {
			return rootElements ;
		}
		
	}

	public void traverseAll() {
		try {
			List<WebElement> rootElements = findRootElements();
			
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
