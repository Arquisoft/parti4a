package es.uniovi.asw.services;


import es.uniovi.asw.KafkaManager.producers.KafkaProducer;
import es.uniovi.asw.KafkaManager.producers.SingletonKafkaProducer;
import es.uniovi.asw.KafkaManager.producers.Topics;
import es.uniovi.asw.util.loggerAdmin.LoggerAdmin;
import es.uniovi.asw.util.loggerAdmin.SingletonLoggerAdmin;

public interface SuperService {
	KafkaProducer logger = SingletonKafkaProducer.getInstance().getProducer();
	LoggerAdmin loggerCutre = SingletonLoggerAdmin.getInstance().getLogger();
	String separator = Topics.SEPARATOR;
}
