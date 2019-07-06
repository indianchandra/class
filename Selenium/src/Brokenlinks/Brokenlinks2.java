package Brokenlinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

  
public class Brokenlinks2 {

		public static void main(String[] args) throws InterruptedException {
		//	System.setProperty("webdriver.chrome.driver", "E:\\common\\drivers\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			//driver.get("https://www.facebook.com");
			driver.get("https://edition.cnn.com/");
	         Thread.sleep(5000);
			 List<WebElement> links = driver.findElements(By.tagName("a")); 
			 System.out.println("Total links are "+links.size()); 
			 for(int i=0; i<links.size(); i++) {
			 WebElement element = links.get(i);
			//By using "href" attribute, we could get the url of the requried link
	        String url=element.getAttribute("href");
			 verifyLink(url); 
			 } 
			 }
		
	        public static void verifyLink(String urlLink) {
				 try {
		
					 URL url = new URL(urlLink);
						HttpURLConnection urlconnect = (HttpURLConnection) url.openConnection();
						                  urlconnect.setConnectTimeout(5000);
						                  urlconnect.connect();
						  if(urlconnect.getResponseCode()==200)
						  {
							  System.out.println("valid Link :"+urlLink+" :: "+urlconnect.getResponseMessage()+" -- "+urlconnect.getResponseCode());
						  }
						  else {
							  System.out.println("Broken Link :"+urlLink+" :: "+urlconnect.getResponseMessage()+" -- "+urlconnect.getResponseCode());

						  }
					}
					catch(Exception e) {
						e.printStackTrace();
					}
	  
		}
		
}


