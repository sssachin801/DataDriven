package com.abc.magento;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginValidation {

	public static void main(String[] args) throws Exception{
		
		FileInputStream fis=new FileInputStream("D:\\MYWORKSPACE\\DataDrivenFramework\\src\\com\\abc\\utilities\\datadriven.properties");
		Properties p=new Properties();
		p.load(fis);
		String urlKeys=p.getProperty("url");
		String emailKeys=p.getProperty("email");
		String passKeys=p.getProperty("password");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(urlKeys);
		
		WebElement myAcct=driver.findElement(By.xpath("//*[text()='Account']/ancestor::a"));
		myAcct.click();
		
		WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys(emailKeys);
		
		WebElement pwd=driver.findElement(By.xpath("//input[@id='pass']"));
		pwd.sendKeys(passKeys);
		
		WebElement login=driver.findElement(By.xpath("//button[@id='send2']"));
		login.click();
		
		WebElement logout=driver.findElement(By.linkText("Log Out"));
		logout.click();	
	}
}
