package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.dto.ClienteRequestDto;
import one.digitalinnovation.gof.dto.ClienteResponseDto;
import one.digitalinnovation.gof.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.service.ClienteService;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 * 
 * @author falvojr
 */
@RestController
@RequestMapping("clientes")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;
    @Autowired
    private ClienteMapper clienteMapper;

	@GetMapping
    public ResponseEntity<Iterable<ClienteResponseDto>> buscarTodos() {
        // Busca os clientes e converte para DTO antes de retornar
        Iterable<Cliente> clientes = clienteService.buscarTodos();
        return ResponseEntity.ok(clienteMapper.toResponseDtoList(clientes));
    }

	@GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> buscarPorId(@PathVariable Long id) {
        // Busca o cliente e converte para DTO
        Cliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(clienteMapper.toResponseDto(cliente));
    }

	@PostMapping
    public ResponseEntity<ClienteResponseDto> inserir(@RequestBody ClienteRequestDto requestDto) {
        // Converte o DTO de requisição para entidade usando o Builder
        Cliente cliente = clienteMapper.toEntity(requestDto);
        clienteService.inserir(cliente);
        // Converte a entidade salva para DTO de resposta
        return ResponseEntity.ok(clienteMapper.toResponseDto(cliente));
    }

	@PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> atualizar(@PathVariable Long id, @RequestBody ClienteRequestDto requestDto) {
        // Converte o DTO para entidade
        Cliente cliente = clienteMapper.toEntity(requestDto);
        clienteService.atualizar(id, cliente);
        // Retorna o DTO do cliente atualizado
        Cliente clienteAtualizado = clienteService.buscarPorId(id);
        return ResponseEntity.ok(clienteMapper.toResponseDto(clienteAtualizado));
    }

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
