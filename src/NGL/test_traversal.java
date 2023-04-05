package NGL;

public class test_traversal {

	public static void main(String[] args) {
		Functions f = new Functions();
		Constants c= new Constants();
		
		f.initiateDriver(c.driverPath);
		f.visitSite(c.url);
		Thread.sleep(2);
		f.login(c.username, c.password);
		
	}
	
}
