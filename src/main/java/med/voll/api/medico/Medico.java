package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name="medicos")
@Entity(name= "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;
    
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean active;

    public Medico(DadosCadastroMedico json) {
        this.nome = json.nome();
        this.email = json.email();
        this.telefone = json.telefone();
        this.crm = json.crm();
        this.especialidade = json.especialidade();
        this.endereco = new Endereco(json.endereco());
        this.active = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico json){
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
