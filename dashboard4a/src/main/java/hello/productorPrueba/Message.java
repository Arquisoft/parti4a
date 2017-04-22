package hello.productorPrueba;

public class Message {
	// Mensajes a enviar
	private String message;

	public Message() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return message;
	}

}