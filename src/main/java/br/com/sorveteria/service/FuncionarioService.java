package br.com.sorveteria.service;
import java.util.List;
import br.com.sorveteria.mode.Funcionario;

public interface FuncionarioService {
	
	Funcionario salvar(Funcionario funcionario);
	List<Funcionario> listarFuncionario();
	void remover(Funcionario funcionario);
	Funcionario buscarPorId(Integer idFuncionario);
}
