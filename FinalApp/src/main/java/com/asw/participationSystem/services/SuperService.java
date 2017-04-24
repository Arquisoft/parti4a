package com.asw.participationSystem.services;

import com.asw.participationSystem.producers.KafkaProducer;
import com.asw.participationSystem.producers.SingletonKafkaProducer;
import com.asw.participationSystem.producers.Topics;
import com.asw.participationSystem.util.loggercutre.LoggerCutre;
import com.asw.participationSystem.util.loggercutre.SingletonLoggerCutre;

public interface SuperService {
	KafkaProducer logger = SingletonKafkaProducer.getInstance().getProducer();
	LoggerCutre loggerCutre = SingletonLoggerCutre.getInstance().getLogger();
	String separator = Topics.SEPARATOR;
}
