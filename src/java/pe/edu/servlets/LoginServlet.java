/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.servlets;

import com.mongodb.DBObject;
import edu.pe.clases.UsuarioDAO;
import edu.pe.clases.UsuarioIF;
import edu.pe.clases.Utilitarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.bean.UsuarioBean;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Paso 1: recuperar sesion
        HttpSession s = request.getSession(true);

        //Paso 2: recuperar datos
        UsuarioBean u = new UsuarioBean();
        u.setUsuario(request.getParameter("usuario"));
        String pass = request.getParameter("password");

        //Paso 3: logica
               
        UsuarioIF ui = new UsuarioDAO();
        DBObject d = ui.getInfo(u);
        
        //Paso 4: pasar datos a la pagina
        
        //Paso 5: enviar a la pagina

        
//        System.out.println(Utilitarios.password(pass,u,d));
        
        if(d != null && Utilitarios.password(pass,u,d)){
        
//        if(d != null && pass.equals(d.get("password"))){
            u.setUsuario((String) d.get("_id"));
            u.setDni((String) d.get("dni"));
            u.setEmail((String) d.get("email"));
            u.setNombre((String) d.get("nombre"));
            u.setTelefono((String) d.get("telf"));
            u.setDireccion((String) d.get("direccion"));
            String[] a = {"1", "2"};
            u.setPartidos(a);
            
             request.setAttribute("usuario", u);

            System.out.println(u.getDni());
            System.out.println(u.getNombre());
            System.out.println(u.getTelefono());
            
            
            RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
            rd.forward(request, response);
        
        }else{
        
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>!!!Error!!!</title>");
            out.println("<link href=\"css/landing-page.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"intro-header\">");
            out.println("<h1> Ingreso mal la contraseña o el usuario </h1>");
            out.println("<h1> Intentelo nuevamente </h1>");
            out.println("<a href= 'loguin.html'>Intentarlo de nuevo</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
        }

        
        
        
        
        
    }

    
}
