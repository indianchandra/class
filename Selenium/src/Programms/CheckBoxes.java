package Programms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxes {
	public static void main(String[] args) {
		
		ChromeDriver driver =new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	String text = driver.findElement(By.id("remember")).getAttribute("checked");
	System.out.println("text");
	
	
	
	
	
	
	
	}
	
	}
