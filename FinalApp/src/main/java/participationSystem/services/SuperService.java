package participationSystem.services;

import  kafka.producers.KafkaProducer;
import kafka.producers.SingletonKafkaProducer;
import kafka.producers.Topics;
import participationSystem.util.loggercutre.LoggerCutre;
import participationSystem.util.loggercutre.SingletonLoggerCutre;

public interface SuperService {
	KafkaProducer logger = SingletonKafkaProducer.getInstance().getProducer();
	LoggerCutre loggerCutre = SingletonLoggerCutre.getInstance().getLogger();
	String separator = Topics.SEPARATOR;
}
