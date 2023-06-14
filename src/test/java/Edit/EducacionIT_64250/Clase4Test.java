package Edit.EducacionIT_64250;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class Clase4Test {
	String url = "http://automationpractice.pl/index.php";
	
	@Test
	public void registrarUsuario() throws InterruptedException {
		// Abrir el navegador en la URL indicada
		WebDriver driver = new FirefoxDriver();
		//driver.get(url); 
		driver.navigate().to(url);
		driver.manage().window().maximize();
				
		// Hacer clic en 'Sign In'
		WebElement lnkSign = driver.findElement(By.partialLinkText("Sign"));
		lnkSign.click();
		
		// Escribir el correo y hacer clic en el botón
		WebElement txtEmail = driver.findElement(By.name("email_create"));
		txtEmail.sendKeys("correo23may2023@gmail.com");
		
		WebElement btnCreate = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
		btnCreate.click();
		
		// Espera
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender1")));
		
		// Completar el formulario
		Faker faker = new Faker();
		
		WebElement radTitle = driver.findElement(By.cssSelector("#id_gender1"));
		radTitle.click();
		
		String nombre = faker.name().firstName(); // Carlos, Ana, Maria...
		String apellido = faker.name().lastName();
		
		WebElement txtFirstname = driver.findElement(By.id("customer_firstname"));
		txtFirstname.sendKeys(nombre);
		
		WebElement txtLastname = driver.findElement(By.name("customer_lastname"));
		txtLastname.sendKeys(apellido);
		
		//String correoAutilizar = "correo" + Math.random() + "@gmail.com";
		
		String correoAutilizar = faker.internet().emailAddress();
		
		System.out.println("Correo Generado: "+ correoAutilizar);
		
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.clear();
		email.sendKeys(correoAutilizar);
		
		WebElement txtPassword = driver.findElement(By.cssSelector("#passwd"));
		txtPassword.sendKeys("1q2w34r5t");
		
		Select listDays = new Select(driver.findElement(By.id("days")));
		listDays.selectByVisibleText("18  ");
		
		Select listMonths = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		listMonths.selectByValue("6");
		
		Select listYears = new Select(driver.findElement(By.cssSelector("#years")));
		listYears.selectByIndex(30);
		
		WebElement chkNewsletter = driver.findElement(By.name("newsletter"));
		chkNewsletter.click();
		
		WebElement chkOptin = driver.findElement(By.xpath("//input[@id='optin']"));
		chkOptin.click();
		
		Thread.sleep(5*1000); // 5 segundos (no obligatorio)
		
		// Hacer clic en 'Register'
		WebElement btnRegister = driver.findElement(By.id("submitAccount"));
		btnRegister.click();
	}
}
