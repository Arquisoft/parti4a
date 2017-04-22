package productorPrueba;

import java.util.Date;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import hello.listeners.MessageListener;

@ManagedBean
public class MessageProducer {
	private static final Logger logger = Logger.getLogger(MessageProducer.class);

	@Autowired
	KafkaTemplate<String, String> template;

	// Para que se envie un mensaje cada 3 segundos
	@Scheduled(cron = "*/3 * * * * *")
	public void send() {
		// Mensaje sencillo para enviar
		String message = "MENSAJE PRUEBA " + new Date();
		System.out.println(message);

		ListenableFuture<SendResult<String, String>> future = template.send("exampleTopic", message);

		// Para saber cuando tiene exito enviandolo y cuando no
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onSuccess(SendResult<String, String> result) {
				logger.info("exito enviando el mensaje " + message);
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.error("error enviando el mensaje " + message);
			}
		});
	}
}
