package participationSystem.cucumber.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import participationSystem.domain.Sugerencia;
import repository.CommentRepository;
import repository.SuggestionRepository;

public class VoteCommentSteps extends SuperSteps{
	@Autowired
	private SuggestionRepository suggestionRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Given("^Soy un usuario registrado$")
	public void soy_un_usuario_registrado() throws Throwable {
//		driver.get(baseUrl);
//		driver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("pelayo@gmail.com");
//		driver.findElement(By.id("inputPassword")).sendKeys("temporal");
//		driver.findElement(By.name("botonlogin")).click();
//
//		SeleniumUtils.esperaCargaPaginaxpath(driver, "/html/body/div/div/div[2]/div[1]/h2", 4);
		throw new PendingException();
	}

	@Given("^Existe al menos una sugerencia$")
	public void existe_al_menos_una_sugerencia() throws Throwable {
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[1]/td[1]")).getText(), "Marquesina Llamaquique");
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[2]")).getText(), "Plantacion de nuevos arboles en el Campo San Francisco");
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[3]")).getText(), "13");		
	}

	@Given("^Esa sugerencia tiene al menos un comentario$")
	public void esa_sugerencia_tiene_al_menos_un_comentario() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
		boolean todoOK = true;
		Long id = Long.parseLong(driver.findElement(By.xpath("//*[@id=\"sugerencias\"]/tbody/tr[2]/td[3]")).getText());
		Sugerencia sugerenciaActual = null;
		try{
			sugerenciaActual = suggestionRepository.findOne(id);
		}catch(Exception e){
			if(sugerenciaActual == null)
				todoOK = false;
			assertEquals(true, todoOK); //Para que avise de que ha cascado
			return;
		}
		//assertEquals(true, todoOK);
		if(sugerenciaActual.getComentarios().size() < 1)
			todoOK = false;
		assertEquals(true, todoOK);
	}

	@When("^Voto positiva o negativamente mi voto$")
	public void voto_positiva_o_negativamente_mi_voto() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^S contabiliza el voto$")
	public void s_contabiliza_el_voto() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^No se sabe lo que he votado$")
	public void no_se_sabe_lo_que_he_votado() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	
	@Given("^Existen al menos dos sugerencia para ordenar$")
	public void existen_al_menos_dos_sugerencia_para_ordenar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@When("^Le doy a ordenar por Titulo$")
	public void le_doy_a_ordenar_por_Titulo() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^Se ordena por Titulo$")
	public void se_ordena_por_Titulo() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@When("^Le doy a ordenar por Votos$")
	public void le_doy_a_ordenar_por_Votos() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^Se ordena por votos$")
	public void se_ordena_por_votos() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@When("^Le doy a ordenar por Contenido$")
	public void le_doy_a_ordenar_por_Contenido() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^Se ordena por contenido$")
	public void se_ordena_por_contenido() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
