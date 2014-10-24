/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.servlets;

import edu.pe.clases.PartidosDAO;
import edu.pe.clases.PartidosIF;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.bean.PartidoBean;
import pe.edu.bean.UsuarioBean;

/**
 *
 * @author GooMoonRyong
 */
@WebServlet(name = "InscServlet", urlPatterns = {"/InscServlet"})
public class InscServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InscServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InscServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Paso 1: recuperar sesion
        HttpSession s = request.getSession(true);
        
        //Paso 2: recuperar datos        
        //UsuarioBean u = new UsuarioBean();
        
        //era canchas weon
        PartidosIF p = new PartidosDAO();
                
                
        
        List l = p.normal();
        
        request.setAttribute("usuario", request.getParameter("usuario"));
        System.out.println("este es el usuario " +request.getParameter("usuario"));
        request.setAttribute("partidos", l);
        
        RequestDispatcher rd = request.getRequestDispatcher("partidos.jsp");
        rd.forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession s = request.getSession(true);
         
         PartidosDAO p = new PartidosDAO();
         
         PartidoBean p1 = new PartidoBean();
         
         System.out.println("lee esto " + request.getParameter("turnos"));
         
         p1.setCancha(request.getParameter("canchas"));
         
         p1.setFechai(request.getParameter("fecha"));
         
         p1.setTurno(Integer.parseInt(request.getParameter("turnos")));
         
         p.crearPartido(p1);
         
                      
                
        
        List l = p.listarPartidos();
        
        request.setAttribute("usuario", request.getParameter("usuario"));
        System.out.println("este es el usuario " + request.getParameter("usuario"));
        request.setAttribute("partidos", l);
        
        RequestDispatcher rd = request.getRequestDispatcher("listapartidos.jsp");
        rd.forward(request, response);
        
         
        
    }

}
