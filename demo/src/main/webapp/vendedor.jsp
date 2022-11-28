<%@ page import="com.example.demo.beans.Cartelera" %><%--
  Created by IntelliJ IDEA.
  User: Labtel
  Date: 28/11/2022
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="cartelera" scope="request" type="java.util.ArrayList<com.example.demo.beans.Cartelera>"></jsp:useBean>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
    </head>
    <body>
        <jsp:include page="includes/navbarAdmin.jsp">
            <jsp:param name="currentPage" value="datos"/>
        </jsp:include>
        <div class='container'>
            <div class="row mb-5 mt-4">
                <div class="col-lg-6">
                    <h1 class=''>Cartelera</h1>
                </div>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="row">Cadena</th>
                        <th scope="row">Cine</th>
                        <th scope="row">Película</th>
                        <th scope="row">Horario</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (Cartelera c: cartelera){%>
                    <tr>
                        <td><%=c.getCine().getCadena().getNombreComercial()%></td>
                        <td><%=c.getCine().getNombre()%></td>
                        <td><%=c.getPelicula().getNombre()%> -

                            <%if (c.getTresD()==1){%>
                            3D
                            <%}%>

                            <%if (c.getSubtitulada()==1){%>
                            Subtitulada
                            <%}%>

                            <%if (c.getDoblada()==1){%>
                            Doblada
                            <%}%>

                        </td>
                        <td><%=c.getHorario()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                crossorigin="anonymous"></script>

    </body>
</html>
