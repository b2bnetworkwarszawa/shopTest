package com.b2bnetwork.shopTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ShopTest {
	//do testowania zostanie użyta biblioteka selenium
		//w celu sterowania przeglądarka nalezy pobrać odpowiedni sterownik na dysk
		
		//do sterowania przeglądarka pomocny jest interface WebDriver
		//stwórzmy instancję klasy WebDriver
		//jest podkreślony na czerwony gdyż nie ma w projekcie biblioteki w której znajduje się wskazany interface
		private WebDriver webDriver;
		
		//przed wywołaniem każdej metody jest potrzebne dodanie sterownika do właściwości systemu oraz 
		//inicjalizacji odpowiedniego rodzaju przeglądarki
		//na potrzeby tego testu została wybrana przeglądarka chrome
		@Before
		public void init() throws MalformedURLException {
			//w celu uzyskania nazwy zmiennej środowiskowej możemy wywołać błąd podczas testu
//			String workingDirectory = System.getProperty("user.dir");
//			String separator = System.getProperty("file.separator");
//			String nameOfDriver = "";
//			if(System.getProperty("os.name").equalsIgnoreCase("Linux")) {
//				nameOfDriver ="chromedriver";
//			}
//			else {
//				nameOfDriver = "chromedriver.exe";
//			}
//			System.setProperty("webdriver.chrome.driver", workingDirectory+separator+"resources"+separator+nameOfDriver);
//			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
//			webDriver = new ChromeDriver();
			webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
			//na potrzeby tych testów zakładam że wszystkie testy rozpoczynam od strony startowej linkedin
			webDriver.get("http://automationpractice.com/index.php");
		}
		
		@Test
		public void sprawdzenie_czy_dziala_poprawnie_przekierowanie_do_logowania() {
			WebElement zaloguj = webDriver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
			zaloguj.click();
			
			
			
			Assert.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", webDriver.getCurrentUrl());
		}
		@After
		public void close() {
			webDriver.quit();
		}
}
