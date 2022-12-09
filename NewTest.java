package Quiz3;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void step1() throws InterruptedException 
  {
	  System.setProperty("webdriver.chrome.driver", 
			  "C:\\Users\\4379\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("http://release01.curemd.com/curemdy/datlogin.asp");
	  Thread.sleep(3000);
	  driver.findElement(By.name("vchLogin_Name")).sendKeys("ChargePatientie");
	  Thread.sleep(1000);
	  driver.findElement(By.name("vchPassword")).sendKeys("SuPPort.2014");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[text()='Login']")).click();
	  Thread.sleep(1000);
	  
      Set<String> s1 = driver.getWindowHandles();
      Iterator<String> i1 = s1.iterator();
      String mainwindow = i1.next();
      String mainwindow1 = i1.next();
      driver.switchTo().window(mainwindow1);
	  Thread.sleep(1000);

	  
	  driver.switchTo().frame(driver.findElement(By.id("fra_Menu_CureMD")));
	  driver.findElement(By.id("patientBtn")).click();
	  Thread.sleep(1000);
	  Set<String> s2 = driver.getWindowHandles();
      Iterator<String> i2 = s2.iterator();
      String window = i2.next();
      String mainwindow2 = i2.next();
      driver.switchTo().window(mainwindow2);
      
	  driver.switchTo().frame(driver.findElement(By.id("fraCureMD_Body")));
      driver.findElement(By.name("txtLast_Name")).sendKeys("Aaa");
	  Thread.sleep(1000);
      driver.findElement(By.name("txtFirst_Name")).sendKeys("ZIXHEENOQK");
      Thread.sleep(1000);
      driver.findElement(By.name("txtDOB")).sendKeys("01/01/2002");
      driver.findElement(By.xpath("//td[@title='Search Patient']")).click();
      Thread.sleep(2000);
      
      driver.findElement(By.xpath("//div[@id='divPatientName136529']")).click();
      Thread.sleep(2000);
      
      WebElement ddown = driver.findElement(By.name("ddlCountry"));
      Select select = new Select(ddown);
      select.selectByVisibleText("United States of America");
      System.out.println();
      
      Select dropdown = new Select(driver.findElement(By.id("cmbvstatus")));

      //Get all options
      List<WebElement> dd = dropdown.getOptions();

      //Get the length
      System.out.println(dd.size());

      // Loop to print one by one
      for (int j = 0; j < dd.size(); j++) {
          System.out.println(dd.get(j).getText());

      }
      
      

      
      


  }
}
