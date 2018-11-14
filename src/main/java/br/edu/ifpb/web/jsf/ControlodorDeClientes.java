package br.edu.ifpb.web.jsf;

import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.domain.Clientes;
import br.edu.ifpb.domain.Endereco;
import br.edu.ifpb.infra.ClientesEmMemoria;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 08/11/2018, 07:58:46
 */
@Named
@SessionScoped
public class ControlodorDeClientes implements Serializable {

    private Clientes clientes = new ClientesEmMemoria();
//    private Clientes clientes = new ClientesEmJDBC();
    private Cliente cliente = new Cliente();
    private boolean editando = false;

//    private List<Cliente> todos = clientes.todosOsClientes();
    public List<Cliente> todos() {
        return clientes.todosOsClientes();
    }

    public String salvar() {
        this.clientes.novo(
                this.cliente
        );
        this.cliente = new Cliente();
        return null;
//        return "list.xhtml"; // forward
//        return "list.xhtml?faces-redirect=true"; // sendRedirect
    }

    public String remover(Cliente cli) {
        this.clientes.remover(cli);
        return null;
    }

    public String editar(Cliente cli) {
        this.cliente = cli;
        this.editando = true;
        return null;
    }

    public String cancelar() {
        this.cliente = new Cliente();
        this.editando = false;
        return null;
    }

    public String atualizar() {
        this.clientes.atualizar(
                this.cliente
        );
        this.cliente = new Cliente();
        this.editando = false;
        return null;
    }

    public List<Endereco> listarTodosOsEnderecos() {
        return this.clientes.todosOsEnderecos();
    }

    public Cliente getCliente() {
        return cliente;
    }
//

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

}
