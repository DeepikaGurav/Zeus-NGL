package NGL;
import NGL.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TecacherResource {

	public static WebDriver driver;

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		TecacherResource tr= new TecacherResource();
		SheetPopulation sp= new  SheetPopulation();
		driver = sp.driverCall();
		sp.LaunchURL();
		LoginLocators ll= new LoginLocators(driver);
		ll.loginsite();
		sp.TRListFetch();
		sp.DriverKill();
	}
}