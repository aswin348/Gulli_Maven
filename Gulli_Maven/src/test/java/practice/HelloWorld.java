package practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloWorld {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("hello Gulli");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://test.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		int boxes = driver.findElements(By.xpath("//input[contains(@class,'input r4 wide')]")).size();
		System.out.println("total number of input fields in this page is " + boxes);

		for (int i = 1; i <= boxes; i++) {
			String part1 = "(//input[contains(@class,'input r4 wide')])[";
			String part2 = i + "]";
			String part3 = part1 + part2;
			System.out.println(part3);

			if (i == 1) {
				driver.findElement(By.xpath(part3)).sendKeys("Aswini");
			}

			if (i == 2) {
				driver.findElement(By.xpath(part3)).sendKeys("Pralipta");
			}
			// System.out.println("the id vlaue ==> " + id);
		}

		// Take screenshot
		TakesScreenshot sh = ((TakesScreenshot) driver);
		File fl = sh.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("C:\\Users\\Aswini Mishra\\eclipse-workspace\\Gulli_Maven\\Aswini.png");
		FileUtils.copyFile(fl, DestFile);

	}

}
