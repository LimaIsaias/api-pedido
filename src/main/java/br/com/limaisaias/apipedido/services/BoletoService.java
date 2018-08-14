package br.com.limaisaias.apipedido.services;

import java.util.Calendar;
import java.util.Date;

import br.com.limaisaias.apipedido.domains.PagamentoComBoleto;

public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instante) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(instante);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}

}
