/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.factory;

import pe.edu.servlets.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.bean.PartidoBean;
import pe.edu.bean.UsuarioBean;
import pe.edu.clases.*;

public class Servlet_Inspart_factory extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession s = request.getSession(true);
         
         List<PartidoBean> l = null;
         
         String tipo = request.getParameter("tipo");
         Inspart p = FactoryPartido.getPartido(tipo);
         String nombre = request.getParameter("nombre");
         
         
         /*
          * se puede usar un contorl por tipo 
          * cada uno con su logica de redireccion
          * 
          * if(p.instaceof(normalDAO))
          *
          * else if(p.instaceof(solidarioDAO))
          * 
          * else
          */
         
             
             
             //sacar toda los partidos disponibles de la BD
             //mostrar los partidos en la pagina donde se puede inscribir
             
             String[] a = {"1","2"};
            UsuarioBean user = new UsuarioBean("74027507"," Titanes@Armin.Mikasa", "Eren jeager", "945982081", a); 
            request.setAttribute("usuario", user);
             request.setAttribute("partidos", l);
       
         RequestDispatcher rd = request.getRequestDispatcher("partidos.jsp");
         rd.forward(request, response);
             
             
         
         
         
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    

 
}
