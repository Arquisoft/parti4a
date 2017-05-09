package es.uniovi.asw.participationSystem.cucmber.steps;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.uniovi.asw.Application;
import es.uniovi.asw.domain.Citizen;
import es.uniovi.asw.participationSystem.util.SeleniumUtils;
import es.uniovi.asw.repository.CitizenRepository;
import es.uniovi.asw.repository.CommentRepository;
import es.uniovi.asw.repository.SuggestionRepository;

@SpringBootTest(classes = Application.class)
public class VoteSuggestionSteps extends SuperSteps {

	private SuggestionRepository suggestionRepository;

	private CommentRepository commentRepository;

	private CitizenRepository citizenRepository;

	@Autowired
	public void setSuggestionRepository(SuggestionRepository suggestionRepository) {
		this.suggestionRepository = suggestionRepository;
	}

	@Autowired
	public void setCommentRepository(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Autowired
	public void setCitizenRepository(CitizenRepository citizenRepository) {
		this.citizenRepository = citizenRepository;
	}

	private Citizen userLogged = null;
	private Long idSugerencia = null;

	@Given("^Inicion sesion en la aplicacion$")
	public void inicion_sesion_en_la_aplicacion() throws Throwable {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("pelayo@gmail.com");
		driver.findElement(By.id("inputPassword")).sendKeys("temporal");
		driver.findElement(By.name("botonlogin")).click();

	}

	@Given("^Existe al menos una sugerencia para votar$")
	public void existe_al_menos_una_sugerencia_para_votar() throws Throwable {
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[1]/td[1]/a")).getText(),
				"Marquesina Llamaquique");
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[1]/a")).getText(),
				"Nuevos arboles");

	}

	@When("^Voto positiva o negativamente$")
	public void voto_positiva_o_negativamente() throws Throwable {
		// votar positivo
		driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[6]/form/button")).click();
		SeleniumUtils.esperaCargaPaginaxpath(driver, "//*[@id=\"sugerencias\"]/tbody/tr[2]/td[2]", 3);
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[2]")).getText(),
				"Plantacion de nuevos arboles en el Campo San Francisco");
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[3]")).getText(), "14");
		// votar negativo
		driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[7]/form/button")).click();
		SeleniumUtils.esperaCargaPaginaxpath(driver, "//*[@id=\"sugerencias\"]/tbody/tr[2]/td[3]", 3);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Then("^Se contabiliza mi voto$")
	public void se_contabiliza_mi_voto() throws Throwable {
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[2]")).getText(),
				"Plantacion de nuevos arboles en el Campo San Francisco");
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[3]")).getText(), "14");
	}

}