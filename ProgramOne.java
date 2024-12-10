package SeleniumProgram;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProgramOne {
	static WebDriver driver;

	public static void main(String[] args) {
		browserInstantiation();
		waitForThisTime(2000);
		clickHere();
		waitForThisTime(2000);
		windowsSwitch();
		textVerification();
		waitForThisTime(2000);
		driver.quit();

	}

	public static void browserInstantiation() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
	}
	public static void windowsSwitch() {
		String parentWidnow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String windowHandle : allWindows) {
			if(!windowHandle.equals(parentWidnow)) {
				driver.switchTo().window(windowHandle);
			}
		}
	}

	public static void clickHere() {
		WebElement myElement = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
		myElement.click();
	}

	public static void textVerification() {
		waitForThisTime(2000);
		WebElement myElement1 = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]"));
		String text = myElement1.getText();
		if (text.equalsIgnoreCase("new Window")) {
			System.out.println("Text present in the new window :: " + text);
		}
		waitForThisTime(2000);
		driver.close();
	}

	public static void waitForThisTime(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
