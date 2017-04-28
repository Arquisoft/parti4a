package dashboard.listener;

import dashboard.MainController;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

/**
 * Created by herminio on 28/12/16.
 */
@ManagedBean
public class MessageListener {

	private static final Logger logger = Logger.getLogger(MessageListener.class);
	// se guardan los mensajes recibidos en una lista
	public static List<String> mensajes = new ArrayList<String>();
	public static State state = new State("0",0,"0",0);
	/** Counters for state changes. */
	private int counter = 1;
	private int counter2 = 1;
 
	@KafkaListener(topics = "exampleTopic")
	public void listenPositiveVote(String data) {
		synchronized (MainController.sseEmitters) {
			state.setTextPositivo(String.valueOf(counter));
			state.setNumberPositivo(counter);
			MainController.sseEmitters.forEach((SseEmitter emitter) -> {
				try {
					emitter.send(state, MediaType.APPLICATION_JSON);
				} catch (IOException e) {
					emitter.complete();
					MainController.sseEmitters.remove(emitter);
				}
			});
		}
		// se añade el mensaje recibido a la lista
		mensajes.add(data);
		counter++;
		logger.info("New message received: \"" + data + "\"");
	}
	
	@KafkaListener(topics = "negativeVote")
	public void listenNegativeVote(String data) {
		synchronized (MainController.sseEmitters) {
			state.setNumberNegativo(counter2);
			state.setTextNegativo(String.valueOf(counter2));
			MainController.sseEmitters.forEach((SseEmitter emitter) -> {
				try {
					emitter.send(state, MediaType.APPLICATION_JSON);
				} catch (IOException e) {
					emitter.complete();
					MainController.sseEmitters.remove(emitter);
				}
			});
		}
		// se añade el mensaje recibido a la lista
		mensajes.add(data);
		counter2++;
		logger.info("New message received: \"" + data + "\"");
}
	
}
