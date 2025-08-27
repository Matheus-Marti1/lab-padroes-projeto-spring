package one.digitalinnovation.gof.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Endereco endereco;

    protected Cliente() {}

    public static ClienteBuilder builder() {
        return new ClienteBuilder();
    }

    public static class ClienteBuilder {
        private String nome;
        private Endereco endereco;

        private ClienteBuilder() {}

        public ClienteBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ClienteBuilder endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public Cliente build() {
            Cliente cliente = new Cliente();
            cliente.setNome(this.nome);
            cliente.setEndereco(this.endereco);
            return cliente;
        }
    }
}
