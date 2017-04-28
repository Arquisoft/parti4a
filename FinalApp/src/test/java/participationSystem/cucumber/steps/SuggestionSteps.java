package participationSystem.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import participationSystem.domain.Categoria;
import participationSystem.domain.Sugerencia;
import participationSystem.util.SeleniumUtils;
import repository.CategoryRepository;
import repository.SuggestionRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@WebAppConfiguration
public class SuggestionSteps extends SuperSteps {

	private SuggestionRepository sR;

	private Sugerencia currentSuggestion;
	private CategoryRepository catRep;

	@Autowired
	public void setsR(SuggestionRepository sR) {
		this.sR = sR;
	}

	@Autowired
	public void setCatRep(CategoryRepository catRep) {
		this.catRep = catRep;
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
			String catName = driver.findElement(By.xpath("//*[@id=\"categoriaSelect\"]")).getText();
			Categoria currentCat = catRep.findByNombre(catName);
			this.currentSuggestion = new Sugerencia("Las rotondas molan",
					"Queremos rotondas en todas las esquinas. Y descuentos en los cambios de neumaticos.", currentCat);
			driver.findElement(By.xpath("//*[@id=\"titulo-text-input\"]")).sendKeys(currentSuggestion.getNombre());
			driver.findElement(By.id("//*[@id=\"contenido-text-area\"]")).sendKeys(currentSuggestion.getContenido());
			driver.findElement(By.id("/html/body/div/div/div[2]/div[2]/form/div[4]/div/button")).click();

		} catch (Exception e) {
			assertEquals(true, false); // Casco
			return;
		}
	}

	@Then("^El sistema debe tener mi sugerencia$")
	public void el_sistema_debe_tener_mi_sugerencia() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		try {
			List<Sugerencia> mySugs = this.sR.findAll();
			assertEquals(true, mySugs.contains(this.currentSuggestion));
		} catch (Exception e) {
			assertEquals(true, false); // Casco
			return;
		}
	}
}
