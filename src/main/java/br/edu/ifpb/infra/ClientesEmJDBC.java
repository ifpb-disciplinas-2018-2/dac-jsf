package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Clientes;
import br.edu.ifpb.domain.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/10/2018, 10:26:28
 */
public class ClientesEmJDBC implements Clientes {

    private Connection connection;

    public ClientesEmJDBC() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://host-banco:5432/clientes",
                    "job", "123"
            );
        } catch (Exception ex) {
            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void novo(Cliente cliente) {
        try {
            PreparedStatement createStatement = this.connection.prepareStatement(
                    "INSERT INTO clientes VALUES (?,?);"
            );
            createStatement.setString(1, cliente.getNome());
            createStatement.setString(2, cliente.getCpf());
            createStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Cliente> todosOsClientes() {
        List<Cliente> lista = new ArrayList<>();
        try {
            Statement createStatement = this.connection.createStatement();
            ResultSet result = createStatement.executeQuery("SELECT * FROM Clientes;");
            iterarComClientes(result, lista);

        } catch (SQLException ex) {
            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    private void iterarComClientes(ResultSet result, List<Cliente> lista) throws SQLException {
        while (result.next()) {
            lista.add(
                    criarCliente(result)
            );
        }
    }

    private Cliente criarCliente(ResultSet result) throws SQLException {
        String nome = result.getString("nome");
        String cpf = result.getString("cpf");
        int id = result.getInt("id");

        return new Cliente(id, nome, cpf);

    }

    @Override
    public void remover(Cliente cli) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
