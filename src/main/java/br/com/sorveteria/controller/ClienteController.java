package br.com.sorveteria.controller;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.sorveteria.mode.Cliente;
import br.com.sorveteria.service.ClienteService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes/api/")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@ApiOperation(
			value = "Cadastrar cliente:",
			response = ResponseEntity.class,
			notes = "Essa operação salva um registro de cliente.")
	@PostMapping("/v1")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		return ResponseEntity.ok().body(this.clienteService.salvar(cliente));
	}	

	@ApiOperation(
			value = "Listar clientes:",
			response = ResponseEntity.class,
			notes = "Essa operação lista todos os registros de cliente.")
	@GetMapping("/v1")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Cliente>> listar(){
		return ResponseEntity.ok().body(this.clienteService.listarClientes());
	}

	@ApiOperation(
			value = "Deletar cliente:",
			response = ResponseEntity.class,
			notes = "Essa operação deleta um registro de cliente.")
	@DeleteMapping("/v1/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String remover(@PathVariable("id") Integer id) {
		this.clienteService.remover(this.clienteService.buscarPorId(id));
		return "Cliente informado deletado com sucesso!";
	}

	@ApiOperation(
			value = "Editar cliente:",
			response = ResponseEntity.class,
			notes = "Essa operação edita um registro de cliente.")
	@PutMapping("/v1/{id}")
	public ResponseEntity<Cliente> editar(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
		Cliente clienteBD = this.clienteService.buscarPorId(id);
		BeanUtils.copyProperties(cliente, clienteBD, "id");
		return ResponseEntity.ok().body(this.clienteService.salvar(clienteBD));
	}
	

}
