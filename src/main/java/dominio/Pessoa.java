package dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    //@Column(name="nomecompleto") usado para poder alterar o nome da coluna na tabela, ao invés de nome, nomecompleto
    private String nome;
    private String email;

    public Pessoa(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Pessoa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
