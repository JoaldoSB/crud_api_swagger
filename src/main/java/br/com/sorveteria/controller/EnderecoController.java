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
import br.com.sorveteria.mode.Endereco;
import br.com.sorveteria.service.EnderecoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/enderecos/api")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;

	@ApiOperation(
			value = "Cadastrar endereço:",
			response = ResponseEntity.class,
			notes = "Essa operação salva um resgistro de endereço.")
	@PostMapping("/v1")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Endereco> Salvar(@RequestBody Endereco endereco) {
	return ResponseEntity.ok().body(this.enderecoService.salvar(endereco));
	}
	
	@ApiOperation(
			value = "Listar endereços:",
			response = ResponseEntity.class,
			notes = "Essa operação lista todos os resgistros de endereço.")
	@GetMapping("v1")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Endereco>> Listar(){
		return ResponseEntity.ok().body(this.enderecoService.listarEndereco());
	}
	
	@ApiOperation(
			value = "Deletar endereço:",
			response = ResponseEntity.class,
			notes = "Essa operação deleta um resgistro de endereço.")
	@DeleteMapping("/v1/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String remover(@PathVariable("id") Integer id) {
		this.enderecoService.remover(this.enderecoService.buscarPorId(id));
		return "Endereço informado deletado com sucesso!";
	}
	
	@ApiOperation(
			value = "Editar endereço:",
			response = ResponseEntity.class,
			notes = "Essa operação deleta um resgistro de endereço.")
	@PutMapping("/v1/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Endereco> editar(@PathVariable("id") Integer id, @RequestBody Endereco endereco) {
		Endereco enderecoBD = this.enderecoService.buscarPorId(id);
		BeanUtils.copyProperties(endereco, enderecoBD, "id");
		return ResponseEntity.ok().body(this.enderecoService.salvar(enderecoBD));
		}

}
