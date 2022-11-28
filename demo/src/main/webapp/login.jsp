<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
            crossorigin="anonymous"></script>
</head>

<body>
<div class="vh-100 d-flex justify-content-center align-items-center">
    <div class="col-md-4 p-5 shadow-sm border rounded-5 border-primary">
        <h2 class="text-center mb-4 text-primary">Inicio de Sesión</h2>
        <form method="POST" action="<%=request.getContextPath()%>/Login" >
            <div class="mb-3">
                <label for="nro_documento" class="form-label">Numero de Documento</label>
                <input type="number" class="form-control border border-primary" id="nro_documento" aria-describedby="emailHelp" name ="nro_documento" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Contraseña</label>
                <input type="password" class="form-control border border-primary" id="password" name="password" required>
                <%if(session.getAttribute("error")!=null){%>
                <b class="text-danger small">Datos erróneos</b>
                <% session.removeAttribute("error");
                }%>
            </div>

            <div class="d-grid">
                <button class="btn btn-primary" type="submit">Ingresar</button>
            </div>
        </form>

    </div>

</div>
</body>

</html>