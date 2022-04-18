package stepDefenitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;


public class PracticeExamStep {
	
	WebDriver driver;
	
	

@Given("User clicks on Sign-up link")
public void user_clicks_on_Sign_up_link() {
	
	WebDriverManager.chromedriver().setup();
	
     driver = new ChromeDriver();
     driver.get("http://elearningm1.upskills.in/index.php");
     driver.manage().window().maximize();
     driver.findElement(By.xpath("//a[contains(text(), 'Sign up!')]")).click();
  
}

@When("User enters the Registration details")
public void user_enters_the_Registration_details(DataTable dataTable)  {
	
	List<Map<String, String>> registrationDetails = dataTable.asMaps(String.class, String.class);
	for (Map<String, String> columns : registrationDetails) {
	
	driver.findElement(By.name("firstname")).sendKeys(columns.get("FirstName"));
	driver.findElement(By.name("lastname")).sendKeys(columns.get("LastName"));
	driver.findElement(By.name("email")).sendKeys(columns.get("E-mail"));
	driver.findElement(By.id("username")).sendKeys(columns.get("UserName"));
	driver.findElement(By.id("pass1")).sendKeys(columns.get("Pass"));
	driver.findElement(By.id("pass2")).sendKeys(columns.get("ConfirmPassword"));
	}

		
    
}

@When("clicks on Register button")
public void clicks_on_Register_button() {
	driver.findElement(By.name("submit")).click();
    
}


@Then("User receives success message {string}")
public void user_receives_success_message(String message) {
	
	String finalSuccessMessage = null;

	String actualMessage = driver.findElement(By.xpath("//*[@class='col-xs-12 col-md-12']/p")).getText();

    String[] successMessage = actualMessage.split(",", 5);
 
 for(String val : successMessage) {
	
	if(val.equalsIgnoreCase("Your personal settings have been registered.")) {
		
		finalSuccessMessage = val.trim();
		 assertEquals(message, finalSuccessMessage);
		
	}
}

}

@When("User clicks next button")
public void User_clicks_next_button() {
	driver.findElement(By.name("next")).click();
    
}

@Then("clicks Profile in the dropdown menu")
public void clicks_Profile_in_the_dropdown_menu(){
	driver.findElement(By.xpath("//*[@class = 'dropdown-toggle']")).click();
	driver.findElement(By.xpath("//*[contains(text(), 'Profile')]")).click();
    
}

@Then("user send messages")
public void user_send_messages() {
	driver.findElement(By.xpath("//*[@id='sn-sidebar-collapse']/div/ul/li[2]/a")).click();
	driver.findElement(By.xpath("//*[contains(@title, 'Compose message')]")).click();
	driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys("This is the test information");
	driver.findElement(By.xpath("//*[@name='compose']")).click();
	
    
}


}
