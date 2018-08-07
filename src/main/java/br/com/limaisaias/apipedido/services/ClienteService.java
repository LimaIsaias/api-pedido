package br.com.limaisaias.apipedido.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.limaisaias.apipedido.domains.Cidade;
import br.com.limaisaias.apipedido.domains.Cliente;
import br.com.limaisaias.apipedido.domains.Endereco;
import br.com.limaisaias.apipedido.domains.enums.TipoCliente;
import br.com.limaisaias.apipedido.dto.ClienteDTO;
import br.com.limaisaias.apipedido.dto.ClienteNewDTO;
import br.com.limaisaias.apipedido.repository.CidadeRepository;
import br.com.limaisaias.apipedido.repository.ClienteRepository;
import br.com.limaisaias.apipedido.repository.EnderecoRepository;
import br.com.limaisaias.apipedido.services.exceptions.DataIntegrityException;
import br.com.limaisaias.apipedido.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	@Autowired
	private CidadeRepository cidadeRepo;
	@Autowired
	private EnderecoRepository enderecoRepo;

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente find(Integer id) throws ObjectNotFoundException {
		Optional<Cliente> retorno = repository.findById(id);
		return retorno.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ! Id:" + id + " Tipo:" + Cliente.class.getName()));
	}

	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repository.save(obj);
		enderecoRepo.saveAll(obj.getEnderecos());
		return obj;
	}

	@Transactional
	public Cliente update(Cliente obj) {
		Cliente objNew = find(obj.getId());
		updateData(objNew, obj);
		return repository.save(objNew);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDTO) {
		return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null);
	}

	public Cliente fromDTO(ClienteNewDTO objDTO) {
		Integer tipo = objDTO.getTipo();
		Cliente cliente = new Cliente(null, objDTO.getNome(), objDTO.getEmail(), objDTO.getCpfCnpj(),
				TipoCliente.toEnum(tipo));
		Cidade cidade = cidadeRepo.findById(objDTO.getCidadeID()).orElse(null);
		Endereco endereco = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(),
				objDTO.getBairro(), objDTO.getCep(), cliente, cidade);
		cliente.getEnderecos().add(endereco);
		cliente.getTelefones().add(objDTO.getTelefone1());
		if (objDTO.getTelefone2() != null)
			cliente.getTelefones().add(objDTO.getTelefone2());
		if (objDTO.getTelefone3() != null)
			cliente.getTelefones().add(objDTO.getTelefone3());
		return cliente;
	}

	private void updateData(Cliente objNew, Cliente obj) {
		objNew.setNome(obj.getNome());
		objNew.setEmail(obj.getEmail());
	}
}
