package ajax_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/Actionservlet")
public class Actionservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ArrayList<Persona> personas = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=iso-8859-1");
        PrintWriter salida = response.getWriter();

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido"); // Corregido el nombre del parámetro
        String edad = request.getParameter("edad");

        if (!nombre.equals("") && !apellido.equals("") && !edad.equals("")) {
            Persona persona = new Persona(nombre, apellido, edad);
            personas.add(persona);
        }

        salida.println("<table style='border-collapse: collapse; border: 1px solid black;'>");
        salida.println("<tr>");
        salida.println("<th>Nombre</th>");
        salida.println("<th>Apellido</th>");
        salida.println("<th>Edad</th>");
        salida.println("</tr>");
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            salida.println("<tr>");
            salida.println("<td>" + persona.getNombre() + "</td>");
            salida.println("<td>" + persona.getApellido() + "</td>");
            salida.println("<td>" + persona.getEdad() + "</td>");
            salida.println("</tr>");
        }
        salida.println("</table>");
    }
}



