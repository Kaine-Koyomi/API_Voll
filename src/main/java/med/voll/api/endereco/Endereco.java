package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizarEndereco(DadosEndereco json){
        if(json.logradouro() != null){
            this.logradouro = json.logradouro();
        }
        if(json.bairro() != null){
            this.bairro = json.bairro();
        }
        if(json.cep() != null){
            this.cep = json.cep();
        }
        if(json.numero() != null){
            this.numero = json.numero();
        }
        if(json.complemento() != null){
            this.complemento = json.complemento();
        }
        if(json.cidade() != null){
            this.cidade = json.cidade();
        }
        if(json.uf() != null){
            this.uf = json.uf();
        }
    }
}
