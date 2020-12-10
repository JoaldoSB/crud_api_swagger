package br.com.sorveteria.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.sorveteria.mode.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
