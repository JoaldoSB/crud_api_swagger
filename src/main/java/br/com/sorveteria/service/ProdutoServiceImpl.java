package br.com.sorveteria.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sorveteria.exception.EntidadeNãoEncontradaException;
import br.com.sorveteria.mode.Produto;
import br.com.sorveteria.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService{

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	@Transactional
	public Produto salvar(Produto produto) {
		return this.produtoRepository.save(produto);
	}

	@Override
	public List<Produto> listarProduto() {
		return this.produtoRepository.findAll();
	}

	@Override
	@Transactional
	public void remover(Produto produto) {
		this.produtoRepository.delete(produto);
	}

	@Override
	public Produto buscarPorId(Integer idProduto) {
		Optional<Produto> produto = this.produtoRepository.findById(idProduto);
		if(produto.get()==null) {
			throw new EntidadeNãoEncontradaException("Não foi possível localizar o produto pesquisado!");
		} else
		return produto.get();
	}

}
