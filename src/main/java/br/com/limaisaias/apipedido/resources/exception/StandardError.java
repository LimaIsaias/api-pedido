package br.com.limaisaias.apipedido.resources.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardError implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1179106176947695911L;
	private Integer status;
	private String msg;
	private Long timeStamp;

	public StandardError() {
	}

	public StandardError(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}

}
