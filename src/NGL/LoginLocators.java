package NGL;
import NGL.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginLocators {
	
	WebDriver driver;
	WebDriverWait wait;
	
	Constants const1 = new Constants();
	
	public LoginLocators(WebDriver driver/*, WebDriverWait wait*/) {
		this.driver = driver;
		//this.wait = wait;
	}

	public static final String UserName = "//label[contains (text(), 'Username')]//following-sibling::input";
	public static final String Password = "//label[contains (text(), 'Password')]//following-sibling::input";
	public static final String LoginBtn = "//input[@value='Log in']";
	
	public void loginsite() {		
		driver.findElement(By.xpath(UserName)).sendKeys(const1.UserName);
		driver.findElement(By.xpath(Password)).sendKeys(const1.Password);
		driver.findElement(By.xpath(LoginBtn)).click();
	}
}