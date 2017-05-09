package es.uniovi.asw.util.loggerAdmin;

public class SingletonLoggerAdmin {
	private static SingletonLoggerAdmin instance;
	private LoggerAdmin logger;

	
	public static SingletonLoggerAdmin getInstance(){
		if(instance == null){
			instance = new SingletonLoggerAdmin();
		}
		return instance;
	}
	
	public LoggerAdmin getLogger(){
		if(logger == null){
			logger = new LoggerAdmin();
		}
		return logger;
	}
}
