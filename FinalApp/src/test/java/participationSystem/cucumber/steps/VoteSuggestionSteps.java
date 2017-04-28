package participationSystem.cucumber.steps;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import participationSystem.domain.Citizen;
import participationSystem.domain.Sugerencia;
import participationSystem.repository.CitizenRepository;
import participationSystem.repository.CommentRepository;
import participationSystem.repository.SuggestionRepository;
import participationSystem.util.SeleniumUtils;

@Service
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
		try {
			userLogged = citizenRepository.findByEmail("pelayo@gmail.com");

		} catch (Exception e) {
			assertEquals(true, false);
		}

		SeleniumUtils.esperaCargaPaginaxpath(driver, "/html/body/div/div/div[2]/div[1]/h2", 4);
	}

	@Given("^Existe al menos una sugerencia para votar$")
	public void existe_al_menos_una_sugerencia_para_votar() throws Throwable {
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[1]/td[1]")).getText(),
				"Marquesina Llamaquique");
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[2]")).getText(),
				"Plantacion de nuevos arboles en el Campo San Francisco");
		this.idSugerencia = Long
				.parseLong(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[3]")).getText());
		assertEquals(idSugerencia, "13");
	}

	@Given("^No he votado ya esa sugerencia$")
	public void no_he_votado_ya_esa_sugerencia() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Sugerencia sugActual = suggestionRepository.findOne(idSugerencia);
		if (userLogged != null) {
			assertEquals(true, !userLogged.getSugerenciasQueVota().contains(sugActual));
		} else {
			assertEquals(true, false);
		}
	}

	@When("^Voto positiva o negativamente$")
	public void voto_positiva_o_negativamente() throws Throwable {
		// votar positivo
		driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[5]/form/button")).click();
		SeleniumUtils.esperaCargaPaginaxpath(driver, "//*[@id=\"sugerencias\"]/tbody/tr[2]/td[2]", 3);
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[2]")).getText(),
				"Plantacion de nuevos arboles en el Campo San Francisco");
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[3]")).getText(), "14");
		// votar negativo
		driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[5]/form/button")).click();
		SeleniumUtils.esperaCargaPaginaxpath(driver, "//*[@id=\"sugerencias\"]/tbody/tr[2]/td[3]", 3);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Then("^Se contabiliza mi voto$")
	public void se_contabiliza_mi_voto() throws Throwable {
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[2]")).getText(),
				"Plantacion de nuevos arboles en el Campo San Francisco");
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[3]")).getText(), "14");
	}

	@Then("^no puedo volver a votar$")
	public void no_puedo_volver_a_votar() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		try {
			Sugerencia sugActual = suggestionRepository.findOne(idSugerencia);
			if (userLogged != null) {
				assertEquals(true, userLogged.getSugerenciasQueVota().contains(sugActual));
			} else {
				assertEquals(true, false);
			}
		} catch (Exception e) {
			assertEquals(true, false);
		}

	}
}