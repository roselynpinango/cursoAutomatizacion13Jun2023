package Edit.EducacionIT_64250;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Clase2Test {
	// (1) Variables: Valores que se van a utilizar
	/*
	 * Para definir una variable
	 * TipoDeDato nombreVariable = Valor;
	 * TipoDeDato nombreVariable;
	 * 
	 * TipoDeDato (String "Hola", int 35, Date "16-MAY-2023",
	 * 				Object ...)
	 * */
	String url = "http://automationpractice.pl/index.php";
	
	/*
	 * (2) Métodos de prueba: Lista de acciones que se van a ejecutar
	 * */
	@Test
	public void buscarPalabraFirefox() {
		// Acciones para poder buscar una palabra en Automationpractice.pl
		// Paso 1: Abrir el navegador
		WebDriver navegador = new FirefoxDriver();
		
		// Paso 2: Acceder a la página automationpractice.pl
		navegador.get(url);
		
		// Maximizar la ventana
		navegador.manage().window().maximize();
		
		// Borrar las cookies
		navegador.manage().deleteAllCookies();
		
		System.out.println("*******ANTES DE LA BUSQUEDA***********");
		System.out.println(navegador.getTitle());
		System.out.println(navegador.getCurrentUrl());
		System.out.println("***************************");
		
		// Paso 3: Escribir la palabra a buscar
		// Paso 3.1: Buscar el elemento que representa al campo de texto
		WebElement campoTexto = navegador.findElement(By.id("search_query_top"));
		
		// Paso 3.2: Escribir la palabra en ese elemento
		campoTexto.sendKeys("dress");
		
		// Paso 4: Hacer la búsqueda
		campoTexto.sendKeys(Keys.ENTER); // Simular que presionamos la tecla ENTER
		
		System.out.println("*******DESPUES DE LA BUSQUEDA***********");
		System.out.println(navegador.getTitle());
		System.out.println(navegador.getCurrentUrl());
		System.out.println("***************************");
		
		navegador.close(); // Cierra la pestaña (tab) del navegador 
		//navegador.quit(); // Cierra todas las pestañas (tabs) del navegador
	}
	
	@Test
	public void buscarPalabraChrome() {
		// Acciones para poder buscar una palabra en Automationpractice.pl
		// Paso 1: Abrir el navegador
		WebDriver navegador = new ChromeDriver();
		
		// Paso 2: Acceder a la página automationpractice.pl
		navegador.get(url);
		
		// Paso 3: Escribir la palabra a buscar
		// Paso 3.1: Buscar el elemento que representa al campo de texto
		WebElement campoTexto = navegador.findElement(By.id("search_query_top"));
		
		// Paso 3.2: Escribir la palabra en ese elemento
		campoTexto.sendKeys("dress");
		
		// Paso 4: Hacer la búsqueda
		campoTexto.sendKeys(Keys.ENTER); // Simular que presionamos la tecla ENTER
	}
}
