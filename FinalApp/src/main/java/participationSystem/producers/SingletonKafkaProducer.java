package participationSystem.producers;

public class SingletonKafkaProducer {
	private static SingletonKafkaProducer instance;
	private KafkaProducer producer;
	
	private SingletonKafkaProducer() {
	}
	
	public static SingletonKafkaProducer getInstance(){
		if(instance == null){
			instance = new SingletonKafkaProducer();
		}
		return instance;
	}
	
	public KafkaProducer getProducer(){
		if(this.producer == null){
			this.producer = new KafkaProducer();
		}
		return producer;
	}
}
