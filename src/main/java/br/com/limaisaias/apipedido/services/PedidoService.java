package br.com.limaisaias.apipedido.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.limaisaias.apipedido.domains.ItemPedido;
import br.com.limaisaias.apipedido.domains.PagamentoComBoleto;
import br.com.limaisaias.apipedido.domains.Pedido;
import br.com.limaisaias.apipedido.domains.enums.EstadoPagamento;
import br.com.limaisaias.apipedido.repository.ItemPedidoRepository;
import br.com.limaisaias.apipedido.repository.PagamentoRepository;
import br.com.limaisaias.apipedido.repository.PedidoRepository;
import br.com.limaisaias.apipedido.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private BoletoService boletoService;

	private ItemPedidoRepository itemPedidoRepository;

	public List<Pedido> findAll() {
		return repository.findAll();
	}

	public Pedido find(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> retorno = repository.findById(id);
		return retorno.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ! Id:" + id + " Tipo:" + Pedido.class.getName()));
	}

	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);

		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repository.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoService.findByID(ip.getProduto().getId()).getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}

}
