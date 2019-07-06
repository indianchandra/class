package Programms;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicDrivers {
	public static void main(String[] args) {
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\LENOVO\\Downloads\\slmdrivers\\geckodriver-v0.24.0-win64.zip ");
	//	ChromeDriver driver = new ChromeDriver();
		 FirefoxDriver driver = new FirefoxDriver();
		 driver.get("https://www.google.com/ ");
	}
	 
}

