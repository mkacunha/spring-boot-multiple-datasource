package br.com.mkacunha.multiple.database.demomultipledatabase.pessoa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table
public class Pessoa {

    @Id
    private UUID uuid = UUID.randomUUID();

    private String name;

    public Pessoa() {
    }

    public Pessoa(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                '}';
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}
