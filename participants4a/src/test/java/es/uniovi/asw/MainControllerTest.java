package es.uniovi.asw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import es.uniovi.asw.Application;
import es.uniovi.asw.business.DBManagement;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.util.exception.CitizenException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class MainControllerTest {

	private DBManagement management;

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	// Test relacionados con la base de datos
	@Test
	public void usuarioExistente() throws CitizenException {
		management = new DBManagement("suisse_@hotmail.com", DigestUtils.sha512Hex("hola"));
		Citizen c1 = management.getPP();

		// Comprobamos que el mismo usuario existe en la base de datos
		assertEquals("dani", c1.getNombre());
		assertEquals("iglesias", c1.getApellidos());
		assertEquals("dani123", c1.getNumeroIdentificativo());
	}

	// @Test
	// public void usuarioNoExistente() throws CitizenException{
	// management = new DBManagement("Noexisto@hotmail.com","x");
	// Citizen c1 = management.getPP();
	//
	// //Comprobamos que el usuario no existe en la base de datos
	// assertNull(c1);
	// }

	// Tests relacionados con el contenido web y la navegación
	@Before
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
//!!MIRAR!! No funciona, no sé si porque no se puede poner los dos parámetros en el login
//	// Introducimos usuario y contraseña correctos
//	@Test
//	public void showParticipantInfoCorrecto() throws Exception {
//
//		mockMvc.perform(post("/showParticipantInfo").param("login", "suisse_@hotmail.com","hola"))
//				.andExpect(status().isOk()).andExpect(model().attributeExists("atributes"))
//				.andExpect(view().name("InfoPage"));
//	}

}
// package hello;
//
// import static org.hamcrest.Matchers.containsString;
// import static org.junit.Assert.assertThat;
//
// import java.net.URL;
//
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.test.IntegrationTest;
// import org.springframework.boot.test.SpringApplicationConfiguration;
// import org.springframework.boot.test.TestRestTemplate;
// import org.springframework.http.ResponseEntity;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// import org.springframework.test.context.web.WebAppConfiguration;
// import org.springframework.web.client.RestTemplate;
//
// import es.uniovi.asw.Application;
//
// @RunWith(SpringJUnit4ClassRunner.class)
// @SpringApplicationConfiguration(classes = Application.class)
// @WebAppConfiguration
// @IntegrationTest({"server.port=0"})
// public class MainControllerTest {
//
// @Value("${local.server.port}")
// private int port;
//
// private URL base;
// private RestTemplate template;
//
// @Before
// public void setUp() throws Exception {
// this.base = new URL("http://localhost:" + port + "/");
// template = new TestRestTemplate();
// }
//
// @Test
// public void getLanding() throws Exception {
// String userURI = base.toString() + "/user";
// ResponseEntity<String> response = template.getForEntity(base.toString(),
// String.class);
// assertThat(response.getBody(), containsString("Hola"));
// }
//
// @Test
// public void getUser() throws Exception {
// String userURI = base.toString() + "/user";
// ResponseEntity<String> response = template.getForEntity(userURI,
// String.class);
// UserInfo expected = new UserInfo("pepe",0);
// }
//
// }