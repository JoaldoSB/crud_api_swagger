package br.com.sorveteria.service;
import java.util.List;
import br.com.sorveteria.mode.Produto;

public interface ProdutoService {
	
	Produto salvar(Produto produto);
	List<Produto> listarProduto();
	void remover(Produto produto);
	Produto buscarPorId(Integer idProduto);
}
