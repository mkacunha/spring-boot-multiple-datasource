package br.com.mkacunha.multiple.database.demomultipledatabase;

import br.com.mkacunha.multiple.database.demomultipledatabase.pedido.domain.Pedido;
import br.com.mkacunha.multiple.database.demomultipledatabase.pedido.repository.PedidoRepository;
import br.com.mkacunha.multiple.database.demomultipledatabase.pessoa.domain.Pessoa;
import br.com.mkacunha.multiple.database.demomultipledatabase.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoMultipleDatabaseApplication implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoMultipleDatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        pessoaRepository.save(new Pessoa("Maiko Cunha"));
        System.out.println(pessoaRepository.findAll());

        pedidoRepository.save(new Pedido("Casa"));
        System.out.println(pedidoRepository.findAll());
    }
}

