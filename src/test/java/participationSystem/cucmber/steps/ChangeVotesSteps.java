package participationSystem.cucmber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hello.Application;
import org.openqa.selenium.By;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import participationSystem.util.SeleniumUtils;
@SuppressWarnings("deprecation")
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class ChangeVotesSteps extends SuperSteps {

    @Given("^Estoy en sesion admin$")
    public void estoy_en_sesion_admin() throws Throwable {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("admin@gmail.com");
        driver.findElement(By.id("inputPassword")).sendKeys("temporal");
        driver.findElement(By.name("botonlogin")).click();

        SeleniumUtils.esperaCargaPaginaxpath(driver, "/html/body/div/div/div[2]/div[1]/h2", 4);
    }

    @When("^cambio el numero minimo de votos$")
    public void cambio_el_numero_minimo_de_votos() throws Throwable {
        SeleniumUtils.esperaCargaPaginaxpath(driver,"//*[@id=\"myNavbar\"]/ul[1]/li[2]/a",10)
                .get(0).click();
        driver.findElement(By.xpath("//*[@id=\"votes-num-input\"]")).sendKeys("199");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/form/div[2]/div/button")).click();


    }

    @Then("^se debe mostrar el cambio$")
    public void se_debe_mostrar_el_cambio() throws Throwable {
        SeleniumUtils.textoPresentePagina(driver,"199");

    }



}
