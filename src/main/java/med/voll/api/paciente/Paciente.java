package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name="pacientes")
@Entity(name="Paciente")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
   
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;
    private Boolean active;

    public Paciente(DadosCadastroPaciente json){
        this.nome = json.nome();
        this.email = json.email();
        this.cpf = json.cpf();
        this.telefone = json.telefone();
        this.endereco = new Endereco(json.endereco());
        this.active = true;
    }

    public void atualizarPaciente(DadosAtualizacaoPaciente json){
        if(json.nome() != null){
            this.nome = json.nome();
        }
        if(json.telefone() != null){
            this.telefone = json.telefone();
        }
        if(json.endereco() != null){
            this.endereco.atualizarEndereco(json.endereco());
        }
    }

    public void excluir(){
        this.active = false;
    }
}
