<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String currentPage = request.getParameter("currentPage"); %>
<jsp:useBean id="empleado" scope="session" type="com.example.demo.beans.Empleado" class="com.example.demo.beans.Empleado"></jsp:useBean>
<nav class="navbar navbar-expand-md navbar-light bg-light">
  <div class="container col-10">
    <a class="navbar-brand">REPORTE</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
      <ul class="navbar-nav">
        <li class="nav-item" >
          <a class="nav-link" href="<%=request.getContextPath()%>/Login?action=logout">Bienvenido <%=empleado.getNombre()%> <%=empleado.getApellido()%> (Cerrar sesión)</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
