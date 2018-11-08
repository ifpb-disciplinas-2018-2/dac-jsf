package br.edu.ifpb.web.servlet;

import br.edu.ifpb.domain.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Job
 */
//http://localhost:8080/dac-jsf/listarClientes.do
//http://localhost:8080/dac-jsf/novoCliente.do
//http://localhost:8080/dac-jsf/removerCliente.do
@WebServlet(name = "FrontController", urlPatterns = {"/.do"})
public class FrontController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // tratamento da requisição
        // executar a lógica de negocio
        // redirecionar o usuario
        // url -> command
//        Command command = new ListarClientes();
//        Command command = new NovoCliente();
        Command command = buildCommand(request.getPathInfo());
        String redirect = command.execute(
                request, response
        );
        response.sendRedirect(redirect);

    }

    public Command buildCommand(String url) {
        return new NovoCliente();
    }
}

interface Command {

    public String execute(
            HttpServletRequest request,
            HttpServletResponse response);
}

class ListarClientes implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        // tratamento da requisição
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        Cliente cliente = new Cliente(nome, cpf);
        // executar a lógica de negocio
        ///
        return "listar.jsp";
    }

}

class NovoCliente implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        // tratamento da requisição
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        Cliente cliente = new Cliente(nome, cpf);
        // executar a lógica de negocio
        ///
        return "editar.jsp";
    }

}
