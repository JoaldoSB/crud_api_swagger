package br.com.sorveteria.service;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sorveteria.mode.Endereco;
import br.com.sorveteria.repository.EnderecoRepository;

@Service
public class EnderecoServiceImpl implements EnderecoService{

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	@Transactional
	public Endereco salvar(Endereco endereco) {
		return this.enderecoRepository.save(endereco);
	}

	@Override
	public List<Endereco> listarEndereco() {
		return this.enderecoRepository.findAll();
	}

	@Override
	@Transactional
	public void remover(Endereco endereco) {
		this.enderecoRepository.delete(endereco);
	}

	@Override
	public Endereco buscarPorId(Integer idEndereco) {
		return this.enderecoRepository.findById(idEndereco).get();
	}

}
