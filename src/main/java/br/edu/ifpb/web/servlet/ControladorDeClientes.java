package br.edu.ifpb.web.servlet;

import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.domain.Clientes;
import br.edu.ifpb.infra.ClientesEmMemoria;
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
@WebServlet(name = "ControladorDeClientes", urlPatterns = {"/clientes"})
public class ControladorDeClientes extends HttpServlet {

    private Clientes clientes = new ClientesEmMemoria();
//    private Clientes clientes = new ClientesEmJDBC();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDeClientes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listagem de Clientes</h1>");
            imprimir(out);
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // tratamento da requisição
        String cpf = req.getParameter("cpf");
        String nome = req.getParameter("nome");

        Cliente cliente = new Cliente(nome, cpf);
        // executar a lógica de negocio
        this.clientes.novo(cliente);

        // redirecionar o usuario
        resp.sendRedirect(req.getRequestURI());
    }

    private void imprimir(PrintWriter out) {
        this.clientes.todosOsClientes()
                .forEach(
                        c -> out.println("<p>" + c.getNome() + "</p>")
                );

    }
}
