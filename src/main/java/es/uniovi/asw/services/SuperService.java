package es.uniovi.asw.services;


import es.uniovi.asw.KafkaManager.producers.KafkaProducer;
import es.uniovi.asw.KafkaManager.producers.SingletonKafkaProducer;
import es.uniovi.asw.KafkaManager.producers.Topics;
import es.uniovi.asw.util.loggercutre.LoggerCutre;
import es.uniovi.asw.util.loggercutre.SingletonLoggerCutre;

public interface SuperService {
	KafkaProducer logger = SingletonKafkaProducer.getInstance().getProducer();
	LoggerCutre loggerCutre = SingletonLoggerCutre.getInstance().getLogger();
	String separator = Topics.SEPARATOR;
}
