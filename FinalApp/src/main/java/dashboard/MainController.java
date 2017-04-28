package dashboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import dashboard.listener.MessageListener;
import kafka.producers.KafkaProducer;
//import dashboard.listeners.MessageListenerNegative;
import kafka.producers.SingletonKafkaProducer;


@Controller
public class MainController {

	private static final Logger logger = Logger.getLogger(MainController.class);
	public static List<SseEmitter> sseEmitters = Collections.synchronizedList(new ArrayList<>());
	//public static List<SseEmitter> sseEmitters2 = Collections.synchronizedList(new ArrayList<>());
	@Autowired
	private KafkaProducer kafkaProducer = SingletonKafkaProducer.getInstance().getProducer();

	@RequestMapping("/")
	public String login(Model model) {
		return "index";
	}
	
	@RequestMapping("/votacion")
	public String votaciones() {
		return "ejemploVotacion";
	}

	@RequestMapping(value= "/login", method = RequestMethod.POST )
	public String sseExamplePage(@RequestParam String username, @RequestParam String password ,Map<String, Object> model) {
		String pagina="index";
		if(username.equals("concejal") && password.equals("concejal")){
			model.put("state", MessageListener.state);
			//model.put("state2", MessageListener.state);
			pagina = "dashboardConcejal";
		}else if(username.equals("personal") && password.equals("personal")){
			model.put("state", MessageListener.state);
			//model.put("state2", MessageListener.state2);
			pagina = "dashboardPersonal";
		}
		return pagina;
	}

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public SseEmitter register() throws IOException {
		logger.info("Registering a stream.");

		SseEmitter emitter = new SseEmitter();
		synchronized (sseEmitters) {
			sseEmitters.add(emitter);
		}
		
		emitter.onCompletion(() -> sseEmitters.remove(emitter));
		return emitter;
	}

//	@RequestMapping(path = "/register2", method = RequestMethod.GET)
//	public SseEmitter register2() throws IOException {
//		logger.info("Registering a stream2.");
//
//		SseEmitter emitter = new SseEmitter();
//		synchronized (sseEmitters2) {
//			sseEmitters2.add(emitter);
//		}
//		emitter.onCompletion(() -> sseEmitters2.remove(emitter));
//		return emitter;
//	}

	@RequestMapping("/updates")
	SseEmitter subscribeUpdates() {
		SseEmitter sseEmitter = new SseEmitter();
		synchronized (sseEmitters) {
			sseEmitters.add(sseEmitter);
			sseEmitter.onCompletion(() -> {
				synchronized (sseEmitters) {
					sseEmitters.remove(sseEmitter);
				}
			});
		}
		return sseEmitter;
	}

	// @RequestMapping(path = "/", method = RequestMethod.POST)
	//
	// public String showMessage(String data) {
	//
	// for (SseEmitter sseEmitter : sseEmitters) {
	// try {
	// sseEmitter.send(data);
	// } catch (Exception e) {
	// logger.error("Se ha cerrado el navegador");
	// }
	// }
	//
	// return data;
	// }
	/**
	 * Se ejecuta en localhost:8090/ejemplo. Esto actualizara la pagina index
	 * con los mensajes de la lista
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/ejemplo")
	public String ejemplotest(Model model) {
		model.addAttribute("data", dashboard.listener.MessageListener.mensajes);
		return "index";
	}

	@RequestMapping("/votoPositivo")
	public String loadData(Model model) {
		kafkaProducer.send("exampleTopic", "test");
		return "ejemploVotacion";
	}

	@RequestMapping("/votoNegativo")
	public String loadDataNegative(Model model) {
		kafkaProducer.send("negativeVote", "negativetest");
		return "ejemploVotacion";
	}

}