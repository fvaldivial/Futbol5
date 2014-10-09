/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.servlets;

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

public class Servlet_Inspart extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession s = request.getSession(true);
         
         List<PartidoBean> l = null;
         PartidosIF p = new PartidosDAO();
         String tipo = request.getParameter("tipo");
         String nombre = request.getParameter("nombre");
         
         
         
         if(tipo.equals("normal")){
             
             
             //sacar toda los partidos disponibles de la BD
             //mostrar los partidos en la pagina donde se puede inscribir
             l =  p.normal();
             String[] a = {"1","2"};
            UsuarioBean user = new UsuarioBean("74027507"," Titanes@Armin.Mikasa", "Eren jeager", "945982081", a); 
            request.setAttribute("usuario", user);
             request.setAttribute("partidos", l);
       
         RequestDispatcher rd = request.getRequestDispatcher("partidos.jsp");
         rd.forward(request, response);
             
             
         }else{
              //ingresar en la lista solidaria nomas
             p.solidaria();
         }
         
         
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    

 
}
