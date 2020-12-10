package br.com.sorveteria.service;
import java.util.List;
import br.com.sorveteria.mode.Fornecedor;

public interface FornecedorService {
	
	Fornecedor salvar(Fornecedor fornecedor);
	List<Fornecedor> listarFornecedor();
	void remover(Fornecedor fornecedor);
	Fornecedor buscarPorId(Integer idFornecedor);
}
