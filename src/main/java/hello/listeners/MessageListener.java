package hello.listeners;

import hello.controllers.MainController;
//import hello.domain.Categoria;
//import hello.domain.Sugerencia;
//import hello.services.SuggestionService;
//import hello.services.impl.SuggestionServiceImpl;
import hello.domain.Sugerencia;
import hello.services.SuggestionService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * Created by herminio on 28/12/16.
 */

@ManagedBean
public class MessageListener {

	private SuggestionService suggestionService;
	List<Sugerencia> ss;

	@Autowired
	public void setSuggestionService(SuggestionService suggestionService) {
		this.suggestionService = suggestionService;
	}

	private static final Logger logger = Logger
			.getLogger(MessageListener.class);
	// se guardan los mensajes recibidos en una lista
	public static List<String> mensajes = new ArrayList<String>();
	// public static State state = new State("0", 0, "0", 0);
	/** Counters for state changes. */

	private State[] lista;

	@KafkaListener(topics = "update")
	public void listenUpdate(String data) {
		// Sugerencia s = new Sugerencia("sug1", "sug1", new Categoria());
		// s.incrementarVotos();
		// sugerencias.add(s);
		ss = suggestionService.findAll();// FUNCIONAAAAA
		lista = new State[ss.size()];
		for (int i = 0; i < lista.length; i++) {
			lista[i] = new State(ss.get(i).getNombre(), ss.get(i).getVotos(),
					ss.get(i).getVotos());
		}
		synchronized (MainController.sseEmitters) {
			MainController.sseEmitters.forEach((SseEmitter emitter) -> {
				try {
					emitter.send(lista, MediaType.APPLICATION_JSON);
				} catch (IOException e) {
					emitter.complete();
					MainController.sseEmitters.remove(emitter);
				}
			});
		}
		// se añade el mensaje recibido a la lista
		mensajes.add(data);
		logger.info("New message received: \"" + data + "\"");
	}
	
	@KafkaListener(topics = "nuevoComentario")
	public void listenAddComment(String data){
		synchronized (MainController.sseEmitters2) {
			MainController.sseEmitters2.forEach((SseEmitter emitter) -> {
				try {
					emitter.send(data, MediaType.APPLICATION_JSON);
				} catch (IOException e) {
					emitter.complete();
					MainController.sseEmitters2.remove(emitter);
				}
			});
		}
		// se añade el mensaje recibido a la lista
		mensajes.add(data);
		logger.info("New message received: \"" + data + "\"");
		
	}

}
