package br.com.sorveteria.service;
import java.util.List;
import br.com.sorveteria.mode.Cliente;

public interface ClienteService {
	
	Cliente salvar(Cliente cliente);
	List<Cliente> listarClientes();
	void remover(Cliente cliente);
	Cliente buscarPorId(Integer idCliente);
}
