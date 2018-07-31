package br.com.limaisaias.apipedido.services.exceptions;

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = -212444212754757392L;

	public DataIntegrityException(String msg) {
		super(msg);
	}

	public DataIntegrityException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}
