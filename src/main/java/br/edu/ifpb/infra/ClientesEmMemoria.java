package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Clientes;
import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.domain.Endereco;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/10/2018, 09:47:56
 */
public class ClientesEmMemoria implements Clientes {

    private static final List<Cliente> lista = new ArrayList<>(
            Arrays.asList(
                    new Cliente(1, "Chaves", "12345634598"),
                    new Cliente(2, "Kiko", "12412312321"),
                    new Cliente(3, "Madruga", "12533344456")
            )
    );
    private AtomicInteger conut = new AtomicInteger(3);

    public ClientesEmMemoria() {
    }

    @Override
    public List<Cliente> todosOsClientes() {
        return lista;
    }

    @Override
    public void novo(Cliente cliente) {
        cliente.setId(conut.incrementAndGet());
        lista.add(cliente);
    }

    @Override
    public void remover(Cliente cli) {
        lista.removeIf(c -> cli.getId() == c.getId());
    }

    @Override
    public void atualizar(Cliente cliente) {
        lista.removeIf(new Predicate<Cliente>() {
            @Override
            public boolean test(Cliente c) {
                return c.getId() == cliente.getId();
            }
        });
        lista.add(cliente);
//        this.lista.removeIf(c -> cliente.getId() == c.getId());
    }

    @Override
    public List<Endereco> todosOsEnderecos() {
        return Arrays.asList(
                new Endereco("Minha Rua", "Meu bairro", "Cz"),
                new Endereco("Segunda Rua", "Segunda bairro", "Cz"),
                new Endereco("Terceira Rua", "Terceira bairro", "Cz")
        );
    }

    @Override
    public Endereco localizarEnderecoComRua(String rua) {
        return this.todosOsEnderecos()
                .stream()
                .filter(end -> end.getRua().equalsIgnoreCase(rua))
                .findFirst()
                .orElse(new Endereco());
    }
}
