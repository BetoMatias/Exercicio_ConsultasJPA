/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultasjpa;

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author beto
 */
@Entity
@SequenceGenerator(name = "VENDA_SEQ", sequenceName = "VEN_SEQ", initialValue = 1, allocationSize = 1)
        @NamedQueries({
            @NamedQuery(name = "Venda.consultarPorCliente", 
                    query = "SELECT v FROM Venda v " + 
                            " WHERE v.cliente.id = :cliente"),//Retorna Lista
            @NamedQuery(name = "Venda.consultarPorProduto", 
                    query = "SELECT v FROM Venda v " + 
                            " WHERE v.produto.id = :produto"),//Retorna Lista
            @NamedQuery(name = "Venda.consultarVenda", 
                    query = "SELECT v FROM Venda v " +
                            " WHERE v.id = :id"),//Retorna single
            @NamedQuery(name = "Venda.consultar", query = "SELECT e FROM Venda e"),//Retorna lista
            
            @NamedQuery(name = "Produto.consultarQuantidade", query = "SELECT count(v) FROM Venda v " + " WHERE v.produto.id = :cod")
})
public class Venda implements Serializable {

    private static final long serialVersionUID = 3779308215097856576L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VENDA_SEQ")
    private Long id;
    @ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
    private Cliente cliente;
    @ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
    private Produto produto;
    private Long quantidade;
  
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

   

  

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

}
