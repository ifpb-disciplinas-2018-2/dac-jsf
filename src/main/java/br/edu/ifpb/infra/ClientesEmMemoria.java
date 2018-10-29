package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Clientes;
import br.edu.ifpb.domain.Cliente;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/10/2018, 09:47:56
 */
public class ClientesEmMemoria implements Clientes {

    private static final List<Cliente> lista = new ArrayList<>();

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
        this.lista.add(cliente);
    }
}
