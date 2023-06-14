package Edit.EducacionIT_64250;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;


public class Clase5Test {
	String url = "http://automationpractice.pl";
	WebDriver driver;
	String dirEvidencias = "..\\EducacionIT-64250\\Evidencias\\";
	String nombreDocumento = "Documento de Evidencias.docx";
	File screen;
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01 - Buscar Palabra en AutomationPractice", priority=1)
	public void buscarPalabra() throws IOException {
		// Captura de Evidencia: Pagina Principal
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "01_PaginaPrincipal.jpg"));
		
		// Escribir palabra a buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Captura de Evidencia: Palabra a Buscar
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "02_PalabraABuscar.jpg"));
		
		// Hacer la búsqueda
		WebElement btnBuscar = driver.findElement(By.name("submit_search"));
		btnBuscar.click();

		// Captura de Evidencia: Resultado de la Busqueda
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "03_ResultadoDeLaBusqueda.jpg"));
		
		// Chequear que el título cambió a "Search - My Store"
		String tituloEsperado = "HOLA";//"Search - My Store";
		String tituloActual = driver.getTitle(); // devuelve el titulo
		
		Assert.assertEquals(tituloActual, tituloEsperado);
		
		/*
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tituloActual, tituloEsperado);
		
		Assert.assertFalse(false);
		Assert.assertTrue(tituloActual.equalsIgnoreCase(tituloEsperado));
		Assert.assertNotEquals(null, "");
		Assert.assertNull(null);
		Assert.assertNotNull(tituloEsperado);
		*/
	}
	
	@Test(priority=0, description="CP02 - Ir a Contactanos en AutomationPractice")
	public void irAContactanos() throws InvalidFormatException, IOException, InterruptedException {
		// Captura de Evidencia
		CapturaEvidencia.escribirTituloEnDocumento(
				dirEvidencias + nombreDocumento, 
				"Documento de Evidencias AutomationPractice", 
				20);
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				dirEvidencias + "img.jpg",
				dirEvidencias + nombreDocumento,
				"Pantalla Inicial del Sistema");				
		
		// Hacer clic en Contact us
		WebElement lnkContact = driver.findElement(By.linkText("Contact us"));
		lnkContact.click();
		
		// Captura de Evidencia
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				dirEvidencias + "img.jpg",
				dirEvidencias + nombreDocumento,
				"Paso 1 - Luego de hacer clic en Contact Us");
		
		// Completar el formulario
		Select selSubject = new Select(driver.findElement(By.name("id_contact")));
		selSubject.selectByVisibleText("Webmaster");
		
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys("correo01@gmail.com");
		
		WebElement txtOrder = driver.findElement(By.xpath("//input[@id='id_order']"));
		txtOrder.sendKeys("123ABC");
		
		WebElement filAdjunto = driver.findElement(By.cssSelector("#fileUpload"));
		filAdjunto.sendKeys("C:\\addIntegerData.txt"); // OJO El archivo tiene que existir
		
		WebElement txtMessage = driver.findElement(By.tagName("textarea"));
		txtMessage.sendKeys("mensaje de contacto");
		
		// Captura de Evidencia
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				dirEvidencias + "img.jpg",
				dirEvidencias + nombreDocumento,
				"Paso 2 - Después de completar el formulario");
		
		// Hacer clic en el botón 
		WebElement btnSend = driver.findElement(By.xpath("//button[@id='submitMessage']"));
		btnSend.click();
		
		// Captura de Evidencia
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				dirEvidencias + "img.jpg",
				dirEvidencias + nombreDocumento,
				"Paso 3 - Después de enviar el formulario de contacto");
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		//driver.close();
	}
}
