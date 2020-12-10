package br.com.sorveteria.service;
import java.util.List;
import br.com.sorveteria.mode.Endereco;

public interface EnderecoService {
	
	Endereco salvar(Endereco endereco);
	List<Endereco> listarEndereco();
	void remover(Endereco endereco);
	Endereco buscarPorId(Integer idEndereco);
}
