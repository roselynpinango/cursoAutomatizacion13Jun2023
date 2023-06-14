package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;



public class Clase8Test {
	String url = "http://automationpractice.pl";
	WebDriver driver;
	String dirDatos = "..\\EducacionIT-64250\\Datos\\";
	String nombreDocumento = "DatosLogin_08Jun2023.xlsx";
	String nombreHoja = "Hoja1";
	
	@BeforeSuite
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void login(String email, String password) {
		// Variables de la ruta y archivo (email + password) .docx
		// Captura de Evidencia
		
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		
		// Captura de Evidencia
		
		login.hacerClicEnLogin();
		
		// Captura de Evidencia
		
		// Chequear si se inició sesión
		// Si se inició sesión
		// 		Debemos volver a la posición inicial > Log Out
		// Si no inició sesión
		// 		Dar como fallida la prueba
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		Object[][] datos = null;
		
		// Llenar la matriz datos con la información de un Excel
		datos = DatosExcel.leerExcel(dirDatos + nombreDocumento, nombreHoja);
		
		return datos;
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[3][2];
		
		datos[0][0] = "a@mail.com";
		datos[0][1] = "3wer43wr4";
		
		datos[1][0] = "b@mail.com";
		datos[1][1] = "w43r3wr34";
		
		datos[2][0] = "c@mail.com";
		datos[2][1] = "w34rewfr4e";
		
		return datos;
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
