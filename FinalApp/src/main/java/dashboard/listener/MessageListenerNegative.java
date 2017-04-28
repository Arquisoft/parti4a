//package dashboard.listeners;
//
//import dashboard.MainController;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.ManagedBean;
//
///**
// * Created by herminio on 28/12/16.
// */
//@ManagedBean
//public class MessageListenerNegative {
//
//	private static final Logger logger = Logger.getLogger(MessageListenerNegative.class);
//	// se guardan los mensajes recibidos en una lista
//	public static List<String> mensajes = new ArrayList<String>();
//	public static State state2 = new State("0",0);
//	/** Counter for state changes. */
//	private int counter = 1;

//	@KafkaListener(topics = "negativeVote")
//	public void listen(String data) {
//		synchronized (MainController.sseEmitters2) {
//			state2 = new State(String.valueOf(counter++),counter);
//			MainController.sseEmitters2.forEach((SseEmitter emitter) -> {
//				try {
//					emitter.send(state2, MediaType.APPLICATION_JSON);
//				} catch (IOException e) {
//					emitter.complete();
//					MainController.sseEmitters2.remove(emitter);
//				}
//			});
//		}
//		// se añade el mensaje recibido a la lista
//		mensajes.add(data);
//		logger.info("New message received: \"" + data + "\"");
//	}

//}
