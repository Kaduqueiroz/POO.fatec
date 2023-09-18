<%-- 
    Document   : juroscompostos
    Created on : 18 de set. de 2023, 15:03:40
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Juros Compostos</title>
</head>
<body>
    <%@include file="WEB-INF/jspf/menu.jspf" %>
    <h1>Juros Compostos</h1>
    
    <form method="post" action="">
        Capital (R$): <input type="text" name="capital"><br>
        Taxa de Juros (%): <input type="text" name="taxa"><br>
        Tempo (em anos): <input type="text" name="tempo"><br>
        Deposito: <input type="text" name="frequencia"><br>
        <input type="submit" value="Calcular">
    </form>

    <%
        String capitalStr = request.getParameter("capital");
        String taxaStr = request.getParameter("taxa");
        String tempoStr = request.getParameter("tempo");
        String frequenciaStr = request.getParameter("frequencia");

        if (capitalStr != null && taxaStr != null && tempoStr != null && frequenciaStr != null) {
            try {
                double capital = Double.parseDouble(capitalStr);
                double taxa = Double.parseDouble(taxaStr);
                double tempo = Double.parseDouble(tempoStr);
                int frequencia = Integer.parseInt(frequenciaStr);

                
                out.println("<table border='1'>");
                out.println("<tr><th>Período (meses)</th><th>Montante Acumulado</th></tr>");
                
                for (int i = 1; i <= tempo * frequencia; i++) {
                    double montante = capital * Math.pow(1 + (taxa / (100 * frequencia)), frequencia * (i / (double)frequencia));
                    String montanteFormatado = String.format("%.2f", montante);
                    out.println("<tr><td>" + i + "</td><td>R$ " + montante + "</td></tr>");
                }
                
                out.println("</table>");

            } catch (NumberFormatException e) {
                out.println("<p>Por favor, insira valores numéricos válidos.</p>");
            }
        }
    %>
</body>
</html>
