package ApiCarlos;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@WebServlet(name = "Loteria", urlPatterns = {"/loteria.json"})
public class Loteria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Date dataHoraAtual = new Date();

        
        List<Integer> numeros = gerarNumerosAleatorios(6);

        
        StringBuilder json = new StringBuilder("{");
        json.append("\"dataHora\":\"").append(dataHoraAtual.toString()).append("\",");
        json.append("\"numeros\":[");
        for (int i = 0; i < numeros.size(); i++) {
            json.append(numeros.get(i));
            if (i < numeros.size() - 1) {
                json.append(",");
            }
        }
        json.append("]}");

        PrintWriter out = response.getWriter();
        out.print(json.toString());
        out.flush();
    }

    private List<Integer> gerarNumerosAleatorios(int quantidade) {
        List<Integer> numeros = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < quantidade; i++) {
            int numero = rand.nextInt(60) + 1; 
            numeros.add(numero);
        }
        return numeros;
    }
}
