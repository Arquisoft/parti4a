package participationSystem;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;

import participationSystem.util.SeleniumUtils;

@SuppressWarnings("deprecation")
@IntegrationTest
@WebAppConfiguration
public class SeleniumTest {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void inicia_sesion() throws Exception {
		driver = new HtmlUnitDriver();
		baseUrl = "http://localhost:8080/";
		driver.get(baseUrl);
		// SeleniumUtils.esperaCargaPagina(driver, baseUrl, "inputEmail", 10);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("inputEmail")).sendKeys("pelayo@gmail.com");
		driver.findElement(By.id("inputPassword")).sendKeys("temporal");
		driver.findElement(By.name("botonlogin")).click();

		SeleniumUtils.esperaCargaPaginaxpath(driver, "/html/body/div/div/div[2]/div[1]/h2", 4);
	}

	@Test
	public void testIniciarSesionUsuario() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("inputEmail")).sendKeys("pelayo@gmail.com");
		driver.findElement(By.id("inputPassword")).sendKeys("temporal");
		driver.findElement(By.xpath("/html/body/div[2]/form/h2"));

		driver.findElement(By.name("botonlogin")).click();
		SeleniumUtils.esperaCargaPaginaxpath(driver, "/html/body/div/div/div[2]/div[1]/h2", 3);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/h2"));
	}

	@Test
	public void testIniciarSesionConcejal() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("inputEmail")).sendKeys("concejal@gmail.com");
		driver.findElement(By.id("inputPassword")).sendKeys("temporal");
		driver.findElement(By.xpath("/html/body/div[2]/form/h2"));

		driver.findElement(By.name("botonlogin")).click();
		driver.findElement(By.id("Eventos"));
	}

}
