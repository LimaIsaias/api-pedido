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

import br.com.limaisaias.apipedido.domains.Categoria;
import br.com.limaisaias.apipedido.dto.CategoriaDTO;
import br.com.limaisaias.apipedido.repository.CategoriaRepository;
import br.com.limaisaias.apipedido.services.exceptions.DataIntegrityException;
import br.com.limaisaias.apipedido.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria find(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> retorno = repository.findById(id);
		return retorno.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ! Id:" + id + " Tipo:" + Categoria.class.getName()));
	}

	@Transactional
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	@Transactional
	public Categoria update(Categoria obj) {
		Categoria objNew = find(obj.getId());
		updateData(objNew, obj);
		return repository.save(objNew);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Categoria fromDTO(CategoriaDTO categoriaDTO) {
		return new Categoria(categoriaDTO.getId(), categoriaDTO.getNome());
	}

	private void updateData(Categoria objNew, Categoria obj) {
		objNew.setNome(obj.getNome());
	}
}
