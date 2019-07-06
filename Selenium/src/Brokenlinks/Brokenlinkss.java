package Brokenlinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlinkss {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		List<WebElement> links = (List<WebElement>) driver.findElement(By.tagName("a"));
		System.out.println("Total links"+links.size());
		for(int i=0;i<links.size();i++) {
			WebElement element =links.get(i);
			String url = element.getAttribute("href");
			verifylinkActive(url);
		
			
		}
	}
		private static void verifylinkActive(String urlLink) {
			try {
				 URL url = new URL(urlLink);
	 HttpURLConnection urlconnect = (HttpURLConnection)url.openConnection();
	 
	                    urlconnect.setConnectTimeout(5000);
	                    urlconnect.connect();
	      if(urlconnect.getResponseCode()==200)
	      {
	    	  System.out.println("valid link:"+urlLink +" :: " + urlconnect.getResponseMessage()+"--"+urlconnect.getResponseCode());
	    	  
	      }
	      else {
	    	  System.out.println("Broken link:"+urlLink+" :: "+urlconnect.getResponseMessage()+"--"+urlconnect.getResponseCode());
	    	  
	      
	      }
			
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		}
}


