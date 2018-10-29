 package br.edu.ifpb.domain;

import br.edu.ifpb.domain.Cliente;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/10/2018, 10:27:30
 */
public interface Clientes {

    void novo(Cliente cliente);

    List<Cliente> todosOsClientes();
    
}
