package participationSystem.services;

import participationSystem.producers.KafkaProducer;
import participationSystem.producers.SingletonKafkaProducer;
import participationSystem.producers.Topics;
import participationSystem.util.loggercutre.LoggerCutre;
import participationSystem.util.loggercutre.SingletonLoggerCutre;

public interface SuperService {
	KafkaProducer logger = SingletonKafkaProducer.getInstance().getProducer();
	LoggerCutre loggerCutre = SingletonLoggerCutre.getInstance().getLogger();
	String separator = Topics.SEPARATOR;
}
