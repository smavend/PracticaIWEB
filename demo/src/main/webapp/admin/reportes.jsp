<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="reporte" scope="session" type="com.example.demo.dtos.Reporte" class="com.example.demo.dtos.Reporte"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
        <title>Mis Datos</title>
    </head>
    <body>
        <jsp:include page="../includes/navbarAdmin.jsp">
            <jsp:param name="currentPage" value="datos"/>
        </jsp:include>
        <div class='container'>
            <div class="row mb-5 mt-4">
                <div class="col-lg-6">
                    <h1 class=''>REPORTE</h1>
                </div>
            </div>
            <table class="table">
                <tbody>
                    <tr>
                        <th scope="row">Cantidad de empleados sin jefe</th>
                        <td><%=reporte.getCantEmpreadosSinJefes()%></td>
                    </tr>
                    <tr>
                        <th scope="row">Cantidad de películas en 3D</th>
                        <td><%=reporte.getCantPeli3D()%></td>
                    </tr>
                    <tr>
                        <th scope="row">Cantidad de cines br</th>
                        <td><%=reporte.getCantCinesSalario9700()%></td>
                    </tr>
                    <tr>
                        <th scope="row"> Cadena de cine con mas <br> películas en cartelera</th>
                        <td><%=reporte.getCineConMasCartelera()%></td>
                    </tr>

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
