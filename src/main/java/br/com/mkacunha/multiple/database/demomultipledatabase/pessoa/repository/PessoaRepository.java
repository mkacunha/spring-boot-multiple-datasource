package br.com.mkacunha.multiple.database.demomultipledatabase.pessoa.repository;

import br.com.mkacunha.multiple.database.demomultipledatabase.pessoa.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
}
