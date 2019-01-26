package br.com.mkacunha.multiple.database.demomultipledatabase.pedido.repository;

import br.com.mkacunha.multiple.database.demomultipledatabase.pedido.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}
