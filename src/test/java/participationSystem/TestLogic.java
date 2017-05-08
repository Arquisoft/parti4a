package participationSystem;

import hello.KafkaManager.producers.SingletonKafkaProducer;
import hello.Message;
import hello.controllers.CitizenController;
import hello.domain.Categoria;
import hello.domain.Comentario;
import hello.domain.Configuration;
import hello.domain.Sugerencia;
import hello.services.CategoryService;
import hello.services.CommentService;
import hello.services.Services;
import hello.services.SuggestionService;
import hello.util.exception.CitizenException;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestLogic {

	private CategoryService categoryService = Services.getCategoryService();
	private CommentService commentService = Services.getCommentService();
	private SuggestionService suggestionService = Services.getSuggestionService();
	
	@Test
	public void testCreateSugerencia(){
		System.out.println(DigestUtils.sha512Hex("temporal"));
		
		String nombre = "Sugerencia de prueba";
		String contenido = "Que nos pongan un 10 en mayo.";
		Categoria cat = new Categoria("Notas ASW"); //Obviamente esta categoria aun no existe
		boolean todoOK = true;
				try{
			Sugerencia s = new Sugerencia(nombre, contenido, cat);
			categoryService.createCategoria(cat);
			suggestionService.createSugerencia(s);
		}catch (CitizenException e){
			System.out.println("No se puede crear la sugerencia: "+nombre);
			todoOK = false;
		}catch (Exception e2){
			System.out.println("Ha cascado algo internamente al crear la sugerencia: "+nombre);
			todoOK = false;
		}
		assertFalse(todoOK); 
	}
	
	@Test
	public void testCreateComment(){
		String nombre = "Sugerencia de prueba";
		String contenido = "Que nos pongan un 10 en mayo.";
		Categoria cat = new Categoria("Notas ASW");
		Sugerencia sugerencia = new Sugerencia(nombre, contenido, cat);
		boolean todoOK = true;
		try{
			String contenidoComment = "Comentario de prueba";
			Comentario c = new Comentario(contenidoComment, sugerencia);
			commentService.createComentario(c);
			
			if(sugerencia.getComentarios().size() == 0){
				todoOK = false;
			}
			
			boolean estaDentro = false;
			
			if(todoOK)
			for(Comentario c2 : sugerencia.getComentarios()){
				if(c2.getContenido().equals("Comentario de prueba")){
					estaDentro = true;
				}
			}
			todoOK = estaDentro ? todoOK : false;
		}catch (CitizenException e){
			System.out.println("No se puede crear la sugerencia: "+nombre);
			todoOK = false;
		}catch (Exception e2){
			System.out.println("Ah cascado algo internamente al crear la sugerencia: "+nombre);
			todoOK = false;
		}
		assertFalse(todoOK);

	}
	

	@Test
	public void testGetCategoriasDisponibles(){
		Categoria cat = new Categoria("PruebaCategoriasDisponibles");
		assertEquals(cat, cat);
		
	}
	
	
	@Test
	public void testMessage(){
		Message m= new Message();
		m.setMessage("mensaje");
		assertEquals(m.getMessage(),"mensaje");
	}
	
	@Test
	public void testSingletonKafkaProducer(){
		SingletonKafkaProducer s1= SingletonKafkaProducer.getInstance();
		s1.getProducer();
		SingletonKafkaProducer s2= SingletonKafkaProducer.getInstance();
		assertEquals(s1, s2);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testClasesModelo(){
		CitizenController cc= new CitizenController();
		cc.setCategoryService(new Services().getCategoryService());
		cc.setCitizenService(new Services().getCitizenServices());
		cc.setSuggestionService(new Services().getSuggestionService());
	
		Categoria c= new Categoria("nombre");
		Sugerencia s1=new Sugerencia("s1", "contenido1", c);
		Sugerencia s2=new Sugerencia("s2", "contenido2", c);
		Sugerencia s3=new Sugerencia("s3", "contenido3", c);
		Sugerencia s4=new Sugerencia("s4", "contenido4", c);
		Sugerencia s5=new Sugerencia("s5", "contenido5", c);
		Set<Sugerencia> suger= new HashSet<>();
		suger.add(s5);
		suger.add(s4);
		suger.add(s3);
		suger.add(s2);
		suger.add(s1);
		c.setSugerencias(suger);
		assertEquals(c.getSugerencias(), suger);
		
		Comentario c1= new Comentario("comentario1", s1);
		Comentario c2= new Comentario("comentario2", s2);
		Comentario c3= new Comentario("comentario3", s3);
		Comentario c4= new Comentario("comentario4", s4);
		
		
		Long id=c.getId();
		assertEquals(c.getNombre(), "nombre");
		assertEquals(c.getId(), id);
		assertEquals(c.getSugerencias(), suger);
		assertEquals(s1.getCategoria(), c);
		assertEquals(s2.getCategoria(), c);
		assertEquals(s3.getCategoria(), c);
		assertEquals(s4.getCategoria(), c);
		assertEquals(s5.getCategoria(), c);
		assertEquals(s1.getContenido(), "contenido1");
		assertEquals(s2.getContenido(), "contenido2");
		assertEquals(s3.getContenido(), "contenido3");
		assertEquals(s4.getContenido(), "contenido4");
		assertEquals(s5.getContenido(), "contenido5");
		assertEquals(s1.getNombre(), "s1");
		assertEquals(s2.getNombre(), "s2");
		assertEquals(s3.getNombre(), "s3");
		assertEquals(s4.getNombre(), "s4");
		assertEquals(s5.getNombre(), "s5");
		assertEquals(s1.getVotosPositivos(), 0);
		assertEquals(s2.getVotosPositivos(), 0);
		assertEquals(s3.getVotosPositivos(), 0);
		assertEquals(s4.getVotosPositivos(), 0);
		assertEquals(s5.getVotosPositivos(), 0);
		
		assertEquals(c1.getContenido(), "comentario1");
		assertEquals(c2.getContenido(), "comentario2");
		assertEquals(c3.getContenido(), "comentario3");
		assertEquals(c4.getContenido(), "comentario4");

		assertEquals(c1.getSugerencia(), s1);
		assertEquals(c2.getSugerencia(), s2);
		assertEquals(c3.getSugerencia(), s3);
		assertEquals(c4.getSugerencia(), s4);
		
		s1.incrementarVotosPositivos();
		assertEquals(s1.getVotosPositivos(), 1);
		s1.incrementarVotosPositivos();;
		assertEquals(s1.getVotosPositivos(), 2);
		s1.incrementarVotosPositivos();;
		assertEquals(s1.getVotosPositivos(), 3);
//		s1.decrementarVotos;
//		assertEquals(s1.getVotos(), 2);
//		s1.decrementarVotos();
//		assertEquals(s1.getVotos(), 1);
//		s1.decrementarVotos();
//		assertEquals(s1.getVotos(), 0);
//		
		Configuration co= new Configuration("mierda");
		assertEquals(co.getPalabraNoPermitida(), "mierda");
	}
	
}
