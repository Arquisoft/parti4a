package participationSystem.cucumber.steps;

import static org.junit.Assert.assertEquals;


import org.openqa.selenium.By;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import participationSystem.util.SeleniumUtils;

/**
 * Clase para probar lo que deberia pasar al insertar un comentario.
 * 
 * PD: No se si lo mas adecuado es lanzar excepciones....
 * 
 * 
 * @author Javier Castro
 *
 */

public class CommentSteps extends SuperSteps{

	
	@Before
	public void setUp() {
		driver.get(baseUrl);
//		driver.findElement(By.id("inputEmail")).sendKeys("pelayo@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("pelayo@gmail.com");
		driver.findElement(By.id("inputPassword")).sendKeys("temporal");
		driver.findElement(By.name("botonlogin")).click();

		SeleniumUtils.esperaCargaPaginaxpath(driver, "/html/body/div/div/div[2]/div[1]/h2", 4);
}
	
	@Given("^Debe haber una sugerencia que comentar$")
	public void debe_haber_una_sugerencia_que_comentar() throws Throwable {
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[1]/td[1]")).getText(), "Marquesina Llamaquique");
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[2]")).getText(), "Plantacion de nuevos arboles en el Campo San Francisco");
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[3]")).getText(), "13");		
	}

	@Given("^he iniciado sesion en la aplicacion$")
	public void he_iniciado_sesion_en_la_aplicacion() throws Throwable {
		// // Write code here that turns the phrase above into concrete actions
//		throw new PendingException();
		String currentURL = driver.getCurrentUrl();
		assertEquals(currentURL, "http://localhost:8080/home");
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
