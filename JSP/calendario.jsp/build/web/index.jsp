<%-- 
    Document   : calendariojsp
    Created on : 11 de set. de 2023, 14:03:45
    Author     : Carlos
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calendário</title>
</head>
<body>
    <h1>Calendário</h1>

    <form action="" method="GET">
        Ano: <input type="text" name="year">
        Mês: <input type="text" name="month">
        <input type="submit" value="Mostrar Calendário">
    </form>

    <%
        String yearParam = request.getParameter("year");
        String monthParam = request.getParameter("month");

        int year = 0;
        int month = 0;

        if (yearParam != null && !yearParam.isEmpty() && monthParam != null && !monthParam.isEmpty()) {
            try {
                year = Integer.parseInt(yearParam);
                month = Integer.parseInt(monthParam);
            } catch (NumberFormatException e) {
                
            }
        }

        if (year < 1 || year > 9999 || month < 1 || month > 12) {
    %>
        <p>Por favor, insira um ano e um mês válidos (em numero).</p>
    <%
        } else {
          
    %>
            <h2><%= month %>/<%= year %></h2>
            <table border="1">
                <tr>
                    <th>Dom</th>
                    <th>Seg</th>
                    <th>Ter</th>
                    <th>Qua</th>
                    <th>Qui</th>
                    <th>Sex</th>
                    <th>Sáb</th>
                </tr>
                <tr>
            <%
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.set(year, month - 1, 1);

                int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
                int firstDayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);

                for (int i = 1; i < firstDayOfWeek; i++) {
            %>
                    <td></td>
            <%
                }

                int dayOfMonth = 1;
                int currentDayOfWeek = firstDayOfWeek;
                while (dayOfMonth <= daysInMonth) {
            %>
                    <td><%= dayOfMonth %></td>
            <%
                    if (currentDayOfWeek == java.util.Calendar.SATURDAY) {
            %>
                        </tr><tr>
            <%
                    }

                    cal.add(java.util.Calendar.DAY_OF_MONTH, 1);
                    currentDayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
                    dayOfMonth++;
                }
            %>
                </tr>
            </table>
    <%
        }
    %>
</body>
</html>
