package NGL;

public class Locators {
		
	public final String UserName = "//label[contains (text(), 'Username')]//following-sibling::input";
	public final String Password = "//label[contains (text(), 'Password')]//following-sibling::input";
	public final String LoginBtn = "//input[@value='Log in']";
	
	public final String TR = "//span[text()=\"Teacher\"]";
	public final String TRmenu = "//span[text()=\"Teacher\"]//following-sibling::ul";
	
	public String rootElements = "//div[@id=\"main-menu\"]/ul/li[contains(@class,'expanded')]";
	public String childElementExtension = "/ul/child::li";
	
	
}