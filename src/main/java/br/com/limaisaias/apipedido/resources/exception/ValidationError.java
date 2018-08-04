package br.com.limaisaias.apipedido.resources.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1564667771599487042L;

	@Getter
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
	}

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	public void addError(String fieldName, String msg) {
		errors.add(new FieldMessage(fieldName, msg));

	}
}
