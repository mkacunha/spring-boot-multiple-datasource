package br.com.mkacunha.multiple.database.demomultipledatabase.pedido.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table
public class Pedido {

    @Id
    private UUID id = UUID.randomUUID();

    private String produto;

    public Pedido() {
    }

    public Pedido(String produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", produto='" + produto + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public String getProduto() {
        return produto;
    }
}
