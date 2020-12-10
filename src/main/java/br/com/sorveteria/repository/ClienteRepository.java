package br.com.sorveteria.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.sorveteria.mode.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
