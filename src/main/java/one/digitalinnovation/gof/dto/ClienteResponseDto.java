package one.digitalinnovation.gof.dto;

import lombok.Getter;
import lombok.Setter;
import one.digitalinnovation.gof.model.Endereco;

@Getter
@Setter
public class ClienteResponseDto {
    private Long id;
    private String nome;
    private Endereco endereco;
}
