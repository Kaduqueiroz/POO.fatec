package ApiCarlos;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List; // Importe a classe List correta

@WebServlet(name = "Servlet", urlPatterns = {"/carlos.json"})
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String ra = "1290482212003";
        String nome = "Carlos Queiroz";

        List<String> disciplinas = new ArrayList<>();
        disciplinas.add("POO");
        disciplinas.add("SO");
        disciplinas.add("Banco");
        disciplinas.add("Ingles");

        String json = "{";
        json += "\"ra\":\"" + ra + "\",";
        json += "\"nome\":\"" + nome + "\",";
        json += "\"disciplinas\":[";
        for (int i = 0; i < disciplinas.size(); i++) {
            json += "\"" + disciplinas.get(i) + "\"";
            if (i < disciplinas.size() - 1) {
                json += ",";
            }
        }
        json += "]}";

        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}
