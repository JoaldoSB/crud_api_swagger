package br.com.sorveteria.service;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sorveteria.mode.Funcionario;
import br.com.sorveteria.repository.FuncionarioRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	@Transactional
	public Funcionario salvar(Funcionario funcionario) {
		return this.funcionarioRepository.save(funcionario);
	}

	@Override
	public List<Funcionario> listarFuncionario() {
		return this.funcionarioRepository.findAll();
	}

	@Override
	@Transactional
	public void remover(Funcionario funcionario) {
		this.funcionarioRepository.delete(funcionario);
	}

	@Override
	public Funcionario buscarPorId(Integer idFuncionario) {
		return this.funcionarioRepository.findById(idFuncionario).get();
	}

}
