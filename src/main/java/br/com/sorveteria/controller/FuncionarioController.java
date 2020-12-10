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
import br.com.sorveteria.mode.Funcionario;
import br.com.sorveteria.service.FuncionarioService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/funcionarios/api/")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@ApiOperation(
			value = "Cadastrar funcionario:",
			response = ResponseEntity.class,
			notes = "Essa operação salva um registro de funcionario.")
	@PostMapping("/v1")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
		return ResponseEntity.ok().body(this.funcionarioService.salvar(funcionario));
	}	

	@ApiOperation(
			value = "Listar funcionarios:",
			response = ResponseEntity.class,
			notes = "Essa operação lista todos os registros de funcionario.")
	@GetMapping("/v1")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Funcionario>> listar(){
		return ResponseEntity.ok().body(this.funcionarioService.listarFuncionario());
	}

	@ApiOperation(
			value = "Deletar funcionario:",
			response = ResponseEntity.class,
			notes = "Essa operação deleta um registro de funcionario.")
	@DeleteMapping("/v1/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String remover(@PathVariable("id") Integer id) {
		this.funcionarioService.remover(this.funcionarioService.buscarPorId(id));
		return "Funcionario informado deletado com sucesso!";
	}

	@ApiOperation(
			value = "Editar funcionario:",
			response = ResponseEntity.class,
			notes = "Essa operação edita um registro de funcionario.")
	@PutMapping("/v1/{id}")
	public ResponseEntity<Funcionario> editar(@PathVariable("id") Integer id, @RequestBody Funcionario funcionario) {
		Funcionario funcionarioBD = this.funcionarioService.buscarPorId(id);
		BeanUtils.copyProperties(funcionario, funcionarioBD, "id");
		return ResponseEntity.ok().body(this.funcionarioService.salvar(funcionarioBD));
	}
	

}
