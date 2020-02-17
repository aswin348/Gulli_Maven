package practice;

import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GBP_To_INR {
	
	WebDriver d;
	
	@BeforeTest
	public void launchChrome() {
		System.out.println("Launch Chrome Browser");
		WebDriverManager.chromedriver().setup();
		 d= new ChromeDriver();	
		 d.manage().window().maximize();
		 d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void convertGBPToInr() throws EmailException {
		
		System.out.println("=========GBP to INR conversion Program========");
		d.get("https://google.com");
		d.findElement(By.cssSelector("input[title=Search]")).sendKeys("GBP To INR");
		//d.findElement(By.cssSelector("div[class='FPdoLc tfB0Bf'] input[value='Google Search'][name='btnK']")).click();
		d.findElement(By.cssSelector("input[title=Search]")).sendKeys(Keys.ENTER);
		String value1 = d.findElement(By.cssSelector("span[class='DFlfde SwHCTb']")).getText();
		System.out.println(value1);
		float f = Float.parseFloat(value1);
		
		if (f > 92.00) {
			sendEmail();
		}
		
		else
			System.out.println("The exchnage rate is below 92.");
	}
	
	public void sendEmail() throws EmailException {
		
	    Email email = new SimpleEmail();
   		email.setHostName("smtp.googlemail.com");
   		email.setSmtpPort(465);
   		email.setAuthenticator(new DefaultAuthenticator("sfdcaswini@gmail.com", "Aswin@348"));
   		email.setSSLOnConnect(true);
   		email.setFrom("sfdcaswini@gmail.com");
   		email.setSubject("i sent it using selenium");
   		email.setMsg("error");
   		email.addTo("pralisatapathy@gmail.com");
   		email.send();
   		System.out.println("==============Email sent==============");
		
	}

}
