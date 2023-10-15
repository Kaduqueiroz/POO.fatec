<%-- 
    Document   : disciplinas
    Created on : 14 de out. de 2023, 23:42:44
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Minha Aplicação Web - Disciplinas</title>
</head>
<body>
    <jsp:include page="WEB-INF/jspf/header.jspf" />
    
    <h2>Disciplinas Cursadas:</h2>
    <ul id="disciplinas-list"></ul>

    <script src="https://cdn.jsdelivr.net/npm/alpinejs@2.8.2/dist/alpine.js" integrity="sha384-mXZg75aDv6vgzLN6AglydmU53JfEnY5p4F9cgFk4lJawg9oyEaV2mpa6jCiSFqkzy" crossorigin="anonymous"></script>
    <script>
        fetch('carlos.json')
            .then(response => response.json())
            .then(data => {
                const disciplinasList = document.getElementById('disciplinas-list');
                data.disciplinas.forEach(disciplina => {
                    const listItem = document.createElement('li');
                    listItem.textContent = disciplina;
                    disciplinasList.appendChild(listItem);
                });
            });
    </script>
</body>
</html>