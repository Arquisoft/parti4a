package hello.productorPrueba;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@ManagedBean
public class MessageProducer {
	private static final Logger logger = Logger.getLogger(MessageProducer.class);

	// @Autowired
	// static
	// KafkaTemplate<String, String> template;
	//
	// // Para que se envie un mensaje cada 3 segundos
	// //@Scheduled(cron = "*/3 * * * * *")
	// public static void send(String topic, String data) {
	// // Mensaje sencillo para enviar
	// String message = data + new Date();
	// System.out.println(message);
	//
	// ListenableFuture<SendResult<String, String>> future =
	// template.send("exampleTopic", message);
	//
	// // Para saber cuando tiene exito enviandolo y cuando no
	// future.addCallback(new ListenableFutureCallback<SendResult<String,
	// String>>() {
	// @Override
	// public void onSuccess(SendResult<String, String> result) {
	// logger.info("exito enviando el mensaje " + message);
	// }
	// @Override
	// public void onFailure(Throwable ex) {
	// logger.error("error enviando el mensaje " + message);
	// }
	// });
	// }

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String topic, String data) {
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, data);
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onSuccess(SendResult<String, String> result) {
				logger.info("Success on sending message \"" + data + "\" to topic " + topic);
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.error("Error on sending message \"" + data + "\", stacktrace " + ex.getMessage());
			}
		});
	}
}
