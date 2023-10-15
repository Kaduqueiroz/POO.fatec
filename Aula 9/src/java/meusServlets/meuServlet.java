/*
 * Clique em nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para alterar esta licença
 * Clique em nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java para editar este modelo
 */
package meusServlets; 

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/carlos.json") 
public class meuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        
        PrintWriter writer = resp.getWriter();
        writer.print("{\"RA\":\"1290482212003\", \"nome\":\"Carlos Queiroz\", \"disciplinas\":[\"Banco de Dados\",\"Engenharia de Software III\",\"Programacao Orientada a Objetos\", \"Sistemas Operacionais II\"]}");
        writer.flush();
    }
}
