package NGL;

import java.util.List;

import org.openqa.selenium.WebElement;

public class Element {

	WebElement currentElement;
	WebElement parentElement;
	List<WebElement> childElements;
	
	public Element(WebElement element, WebElement parent, List<WebElement> child){
		currentElement = element;
		parentElement = parent;
		childElements = child;
	}
}
