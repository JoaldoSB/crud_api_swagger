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
import br.com.sorveteria.mode.Fornecedor;
import br.com.sorveteria.service.FornecedorService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/fornecedores/api")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;

	@ApiOperation(
			value = "Salvar fornecedor:",
			response = ResponseEntity.class,
			notes = "Essa operação salva um registro de fornecedor.")
	@PostMapping("/v1")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Fornecedor> Salvar(@RequestBody Fornecedor fornecedor) {
		return ResponseEntity.ok().body(this.fornecedorService.salvar(fornecedor));
	}

	@ApiOperation(
			value = "Listar endereços:",
			response = ResponseEntity.class,
			notes = "Essa operação lista todo os registros de fornecedor.")
	@GetMapping("/v1")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Fornecedor>> Listar(){
		return ResponseEntity.ok().body(fornecedorService.listarFornecedor());
	}

	@ApiOperation(
			value = "Deletar fornecedor:",
			response = ResponseEntity.class,
			notes = "Essa operação deleta um registro de fornecedor.")
	@DeleteMapping("/v1/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String Remover(@PathVariable("id") Integer id) {
		this.fornecedorService.remover(this.fornecedorService.buscarPorId(id));
		return "Fornecedor informado deletado com sucesso!";
	}
	
	@ApiOperation(
			value = "Editar fornecedor:",
			response = ResponseEntity.class,
			notes = "Essa operação edita um resgistro de fornecedor.")
	@PutMapping("/v1/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Fornecedor> Editar(@PathVariable("id") Integer id, @RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorBD = this.fornecedorService.buscarPorId(id);
		BeanUtils.copyProperties(fornecedor, fornecedorBD, "id");
		return ResponseEntity.ok().body(this.fornecedorService.salvar(fornecedorBD));
	}
	
}
