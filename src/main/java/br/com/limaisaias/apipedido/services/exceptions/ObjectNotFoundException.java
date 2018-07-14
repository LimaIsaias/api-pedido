package br.com.limaisaias.apipedido.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7779905021291371488L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

	public ObjectNotFoundException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}
