package hello.services;

import hello.producers.KafkaProducer;
import hello.producers.SingletonKafkaProducer;
import hello.producers.Topics;
import hello.util.loggercutre.LoggerCutre;
import hello.util.loggercutre.SingletonLoggerCutre;

public interface SuperService {
	KafkaProducer logger = SingletonKafkaProducer.getInstance().getProducer();
	LoggerCutre loggerCutre = SingletonLoggerCutre.getInstance().getLogger();
	String separator = Topics.SEPARATOR;
}
