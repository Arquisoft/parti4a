package hello.controllers;

import hello.KafkaManager.listeners.MessageListener;
import hello.KafkaManager.producers.KafkaProducer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static hello.KafkaManager.listeners.MessageListener.mensajes;


//import hello.listeners.MessageListenerNegative;


@Controller
public class MainController {

	private static final Logger logger = Logger.getLogger(MainController.class);
	public static List<SseEmitter> sseEmitters = Collections.synchronizedList(new ArrayList<>());
	public static List<SseEmitter> sseEmitters2 = Collections.synchronizedList(new ArrayList<>());
	@Autowired
	private KafkaProducer kafkaProducer = new KafkaProducer();

	@RequestMapping("/dashboard")
	public String login(Model model) {
		return "dashboardConcejal";
	}

	@RequestMapping("/votacion")
	public String votaciones() {
		return "ejemploVotacion";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String sseExamplePage(@RequestParam String username, @RequestParam String password,
			Map<String, Object> model) {
		String pagina = "index";
		if (username.equals("concejal") && password.equals("concejal")) {
			model.put("state", mensajes);
			// model.put("state2", MessageListener.state);
			pagina = "dashboardConcejal";
		} else if (username.equals("personal") && password.equals("personal")) {
			model.put("state", mensajes);
			// model.put("state2", MessageListener.state2);
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

	@RequestMapping(path = "/register2", method = RequestMethod.GET)
	public SseEmitter register2() throws IOException {
		logger.info("Registering a stream.");

		SseEmitter emitter = new SseEmitter();
		synchronized (sseEmitters2) {
			sseEmitters2.add(emitter);
		}

		emitter.onCompletion(() -> sseEmitters2.remove(emitter));
		return emitter;
	}

	// @RequestMapping(path = "/register2", method = RequestMethod.GET)
	// public SseEmitter register2() throws IOException {
	// logger.info("Registering a stream2.");
	//
	// SseEmitter emitter = new SseEmitter();
	// synchronized (sseEmitters2) {
	// sseEmitters2.add(emitter);
	// }
	// emitter.onCompletion(() -> sseEmitters2.remove(emitter));
	// return emitter;
	// }

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

	/**
	 * Se ejecuta en localhost:8090/ejemplo. Esto actualizara la pagina index
	 * con los mensajes de la lista
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/ejemplo")
	public String ejemplotest(Model model) {
		model.addAttribute("data", MessageListener.mensajes);
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

	@RequestMapping("/update")
	public String loadSuggestions(Model model) {
		kafkaProducer.send("update", "actualizando");
		return "ejemploVotacion";

	}

}