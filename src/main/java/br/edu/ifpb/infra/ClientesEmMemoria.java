package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Clientes;
import br.edu.ifpb.domain.Cliente;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/10/2018, 09:47:56
 */
public class ClientesEmMemoria implements Clientes {

    private static final List<Cliente> lista = new ArrayList<>();
    private AtomicInteger conut = new AtomicInteger(3);

    public ClientesEmMemoria() {
        lista.addAll(
                Arrays.asList(
                        new Cliente(1, "Chaves", "123"),
                        new Cliente(2, "Kiko", "124"),
                        new Cliente(3, "Madruga", "125")
                )
        );

    }

    @Override
    public List<Cliente> todosOsClientes() {
        return lista;
    }

    @Override
    public void novo(Cliente cliente) {
        cliente.setId(conut.incrementAndGet());
        this.lista.add(cliente);
    }

    @Override
    public void remover(Cliente cli) {
        this.lista.remove(cli);
    }

    @Override
    public void atualizar(Cliente cliente) {
        this.lista.removeIf(new Predicate<Cliente>() {
            @Override
            public boolean test(Cliente c) {
                return c.getId()==cliente.getId();
            }
        });
        this.lista.add(cliente);
//        this.lista.removeIf(c -> cliente.getId() == c.getId());
    }
}
