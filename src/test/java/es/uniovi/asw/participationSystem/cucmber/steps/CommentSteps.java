package es.uniovi.asw.participationSystem.cucmber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.uniovi.asw.Application;
import es.uniovi.asw.participationSystem.util.SeleniumUtils;

import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Clase para probar lo que deberia pasar al insertar un comentario.
 * 
 * PD: No se si lo mas adecuado es lanzar excepciones....
 * 
 * 
 * @author Javier Castro
 *
 */

@SpringBootTest(classes = Application.class)
public class CommentSteps extends SuperSteps{



	@AfterClass
	static public void end() {
		// Espera para que la última prueba borre las cookies
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.quit();
	}

	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	@Given("^Inicio sesion en la aplicacionn$")
	public void inicio_sesion_en_la_aplicacion() throws Throwable {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("pelayo@gmail.com");
		driver.findElement(By.id("inputPassword")).sendKeys("temporal");
		driver.findElement(By.name("botonlogin")).click();

		SeleniumUtils.esperaCargaPaginaxpath(driver, "/html/body/div/div/div[2]/div[1]/h2", 4);
	}


	
	@Given("^Debe haber una sugerencia que comentar$")
	public void debe_haber_una_sugerencia_que_comentar() throws Throwable {
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[1]/a")).getText(), "Nuevos arboles");

	}



	@When("^creo un comentario$")
	public void creo_un_comentario() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[1]/a")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div/form/textarea")).sendKeys("Mola");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div/form/button")).click();
	
	}

	@Then("^la sugerencia debe tener mi comentario$")
	public void la_sugerencia_debe_tener_mi_comentario() throws Throwable {
		//Si esta, false
	//	SeleniumUtils.esperaCargaPaginaNoTexto(driver, texto, timeout);
		assertEquals(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div[2]/div/div[2]/p")).getText(),
				"Por un Oviedo verde");
	}

}
