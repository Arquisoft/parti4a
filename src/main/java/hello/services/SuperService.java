package hello.services;


import hello.KafkaManager.producers.KafkaProducer;
import hello.KafkaManager.producers.SingletonKafkaProducer;
import hello.KafkaManager.producers.Topics;
import hello.util.loggercutre.LoggerCutre;
import hello.util.loggercutre.SingletonLoggerCutre;

public interface SuperService {
	KafkaProducer logger = SingletonKafkaProducer.getInstance().getProducer();
	LoggerCutre loggerCutre = SingletonLoggerCutre.getInstance().getLogger();
	String separator = Topics.SEPARATOR;
}
