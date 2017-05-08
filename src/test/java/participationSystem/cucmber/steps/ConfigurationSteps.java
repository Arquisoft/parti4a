package participationSystem.cucmber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import hello.Application;
import org.openqa.selenium.By;
import org.springframework.boot.test.context.SpringBootTest;
import participationSystem.util.SeleniumUtils;

@SpringBootTest(classes = Application.class)
public class ConfigurationSteps extends SuperSteps{
	@Given("^Inicio sesion$")
	public void inicio_sesion() throws Throwable {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("admin@gmail.com");
		driver.findElement(By.id("inputPassword")).sendKeys("temporal");
		driver.findElement(By.name("botonlogin")).click();

		SeleniumUtils.esperaCargaPaginaxpath(driver, "/html/body/div/div/div[2]/div[1]/h2", 4);
	}

	@Given("^Soy un usuario administrador$")
	public void soy_un_usuario_administrador() throws Throwable {
	    SeleniumUtils.textoPresentePagina(driver,"admin@gmail.com");
	}

	@When("^Añado una palabrea prohida$")
	public void añado_una_palabrea_prohida() throws Throwable {
	   SeleniumUtils.esperaCargaPaginaxpath(driver,"//*[@id=\"myNavbar\"]/ul[1]/li[2]/a",10)
			   .get(0).click();
		driver.findElement(By.xpath("//*[@id=\"word-text-input\"]")).sendKeys("caca");
		SeleniumUtils.esperaCargaPaginaxpath(driver,"/html/body/div/div/div[2]/div[2]/form/div[2]/div/button",10)
				.get(0).click();


	}


}
