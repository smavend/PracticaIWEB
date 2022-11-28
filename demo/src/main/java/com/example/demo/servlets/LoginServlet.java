package com.example.demo.servlets;

import com.example.demo.beans.Cartelera;
import com.example.demo.beans.Empleado;
import com.example.demo.daos.DaoCartelera;
import com.example.demo.daos.DaoEmpleado;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login",""})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher vista;

        String action = request.getParameter("action") == null? "login":request.getParameter("action");

        switch (action){
            case "login":

                vista = request.getRequestDispatcher("login.jsp");
                vista.forward(request, response);

                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DaoEmpleado daoEmpleado = new DaoEmpleado();
        DaoCartelera daoCartelera = new DaoCartelera();
        RequestDispatcher vista;


        String dni = request.getParameter("usuario");
        double password = Double.parseDouble(request.getParameter("password"));

        if (daoEmpleado.validarEmpleado(dni, password)){

            Empleado empleado = daoEmpleado.buscarEmpleadoDni(dni);

            switch (empleado.getRol().getNombre()){
                case "admin":

                    break;

                case "gestor":

                    break;

                case "vendedor":

                    ArrayList<Cartelera> cartelera = daoCartelera.obtenerCartelera();
                    request.setAttribute("cartelera", cartelera);

                    vista = request.getRequestDispatcher("vendedor.jsp");
                    vista.forward(request, response);

                    break;
            }

        }else {

            HttpSession session = request.getSession();
            session.setAttribute("error", "Usuario o contraseña incorrecta(s)");
            response.sendRedirect(request.getContextPath()+"/");

        }

    }
}
