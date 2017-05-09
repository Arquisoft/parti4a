package es.uniovi.asw.participationSystem.cucmber.steps;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.uniovi.asw.domain.Sugerencia;
import es.uniovi.asw.participationSystem.util.SeleniumUtils;
import es.uniovi.asw.repository.SuggestionRepository;
import es.uniovi.asw.services.CategoryService;

@WebAppConfiguration

public class SuggestionSteps extends SuperSteps {

	private SuggestionRepository sR;

	private Sugerencia currentSuggestion;
	private CategoryService categoryService;

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Autowired
	public void setsR(SuggestionRepository sR) {
		this.sR = sR;
	}

	@Given("^Inicio sesion en la aplicacion$")
	public void inicio_sesion_en_la_aplicacion() throws Throwable {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("pelayo@gmail.com");
		driver.findElement(By.id("inputPassword")).sendKeys("temporal");
		driver.findElement(By.name("botonlogin")).click();

		SeleniumUtils.esperaCargaPaginaxpath(driver, "/html/body/div/div/div[2]/div[1]/h2", 4);
	}

	@Given("^Existe al menos una categoria en la que puedo meter mi sugerencia$")
	public void existe_al_menos_una_categoria_en_la_que_puedo_meter_mi_sugerencia() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/thead/tr/th[2]")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr/td[1]")).getText(),
				"Marquesina Llamaquique");
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr/td[3]")).getText(), "3");
	}

	@When("^Creo la sugerencia$")
	public void creo_la_sugerencia() throws Throwable {
		// // Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		try {
			driver.findElement(By.xpath("//*[@id=\"myNavbar\"]/ul[1]/li[2]/a")).click();

			this.currentSuggestion = new Sugerencia("AAAAAAAAAAAA", "aaaaaaaaaaaaaa", null);
			driver.findElement(By.xpath("//*[@id=\"titulo-text-input\"]")).sendKeys(currentSuggestion.getNombre());
			driver.findElement(By.xpath("//*[@id=\"contenido-text-area\"]")).sendKeys(currentSuggestion.getContenido());
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/form/div[4]/div/button")).click();

		} catch (Exception e) {
			assertEquals(true, false); // Casco
			return;

		}
	}

	@Then("^El sistema debe tener mi sugerencia$")
	public void el_sistema_debe_tener_mi_sugerencia() throws Throwable {
		SeleniumUtils.textoPresentePagina(driver, "AAAAAAAAAAAA");

	}
}
