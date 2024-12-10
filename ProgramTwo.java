package SeleniumProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProgramTwo {

	static WebDriver driver;

	public static void main(String[] args) {
		browserInstantiation();
		waitForFixTime(2000);
		frameTop();
		waitForFixTime(2000);
		frameMiddle();
		waitForFixTime(2000);
		frameRight();
		waitForFixTime(2000);
		frameBottom();
		waitForFixTime(2000);
		driver.quit();
	}

	public static void browserInstantiation() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
	}

	public static void frameTop() {
		WebElement frameTop = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(frameTop);
		waitForFixTime(2000);
		WebElement frameLeft = driver.findElement(By.xpath("//frame[@name='frame-left']"));
		driver.switchTo().frame(frameLeft);
		waitForFixTime(2000);
		WebElement myElement = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
		String textInLeftFrame = myElement.getText();
		if (textInLeftFrame.equalsIgnoreCase("left")) {
			System.out.println("Text Present in Left Frame :: " + textInLeftFrame);
		}

	}

	public static void frameMiddle() {
		driver.switchTo().parentFrame();
		WebElement frameMiddle = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(frameMiddle);
		waitForFixTime(2000);
		WebElement myElement2 = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
		String textInMiddleFrame = myElement2.getText();
		if (textInMiddleFrame.equalsIgnoreCase("middle")) {
			System.out.println("Text Present in Middle Frame :: " + textInMiddleFrame);
		}
	}

	public static void frameRight() {
		driver.switchTo().parentFrame();
		waitForFixTime(2000);
		WebElement frameRight = driver.findElement(By.xpath("//frame[@name='frame-right']"));
		driver.switchTo().frame(frameRight);
		waitForFixTime(2000);
		WebElement myElement3 = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
		String textInRightFrame = myElement3.getText();
		if (textInRightFrame.equalsIgnoreCase("right")) {
			System.out.println("Text present in Right Frame :: " + textInRightFrame);
		}
	}

	public static void frameBottom() {
		driver.switchTo().defaultContent();
		waitForFixTime(2000);
		WebElement frameBottom = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		driver.switchTo().frame(frameBottom);
		waitForFixTime(2000);
		WebElement myElement4 = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
		String textInBottomFrame = myElement4.getText();
		if (textInBottomFrame.equalsIgnoreCase("bottom")) {
			System.out.println("Text present in Bottom Frame :: " + textInBottomFrame);
		}
	}

	public static void waitForFixTime(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
