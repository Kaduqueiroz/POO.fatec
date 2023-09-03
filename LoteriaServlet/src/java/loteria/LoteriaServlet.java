package loteria;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "LoteriaServlet", urlPatterns = {"/loteria.html"})
public class LoteriaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            List<Integer> numerosSorteados = sortearNumeros(6, 1, 60);

            out.println("<html>");
            out.println("<body>");
            out.println("<h1>Números da Loteria</h1>");
            out.println("<table>");
            out.println("<tr><th>Números Sorteados</th></tr>");

            for (int numero : numerosSorteados) {
                out.println("<tr><td>" + numero + "</td></tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private List<Integer> sortearNumeros(int quantidade, int minimo, int maximo) {
        List<Integer> numeros = new ArrayList<>();
        List<Integer> candidatos = new ArrayList<>();

        
        for (int i = minimo; i <= maximo; i++) {
            candidatos.add(i);
        }

        
        Collections.shuffle(candidatos);

                for (int i = 0; i < quantidade; i++) {
            numeros.add(candidatos.get(i));
        }

        return numeros; 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
