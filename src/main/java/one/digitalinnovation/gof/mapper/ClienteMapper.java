package one.digitalinnovation.gof.mapper;

import one.digitalinnovation.gof.dto.ClienteRequestDto;
import one.digitalinnovation.gof.dto.ClienteResponseDto;
import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.Endereco;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ClienteMapper {

    /**
     * Converte um DTO de requisição em uma entidade Cliente.
     */
    public Cliente toEntity(ClienteRequestDto requestDto) {
        Endereco endereco = new Endereco();
        endereco.setCep(requestDto.getCep());

        return Cliente.builder()
                .nome(requestDto.getNome())
                .endereco(endereco)
                .build();
    }

    /**
     * Converte uma entidade Cliente em um DTO de resposta.
     */
    public ClienteResponseDto toResponseDto(Cliente cliente) {
        ClienteResponseDto responseDto = new ClienteResponseDto();
        responseDto.setId(cliente.getId());
        responseDto.setNome(cliente.getNome());
        responseDto.setEndereco(cliente.getEndereco());
        return responseDto;
    }

    /**
     * Converte uma lista de entidades Cliente em uma lista de DTOs de resposta.
     */
    public Iterable<ClienteResponseDto> toResponseDtoList(Iterable<Cliente> clientes) {
        return StreamSupport.stream(clientes.spliterator(), false)
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }
}
