package edu.training.testingPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebTables {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.get("https://www.railyatri.in/time-table");
		String firstText = driver.findElement(By.xpath("//table[@class=\"table table-condensed\"]//tr[1]/th[1]")).getText();
		driver.close();
		if(!firstText.isEmpty())
			System.out.println("First text in the webtable is : " + firstText);
		else
			System.out.println("Unable to retrieve the firsttext in the webtable");

	}

}
