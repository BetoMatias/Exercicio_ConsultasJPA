/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultasjpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author beto
 */
@Entity
@SequenceGenerator(name = "CLIENTE_SEQ", sequenceName = "CLI_SEQ", initialValue = 1, allocationSize = 1)
 @NamedQueries({
            @NamedQuery(name = "Cliente.pesquisar", query = "SELECT c FROM Cliente c " + " WHERE c.id = :clienteId")
                
})

public class Cliente implements Serializable {

    private static final long serialVersionUID = 2857623098641748810L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
    private Long id;
    private String nome;
    private String cpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
