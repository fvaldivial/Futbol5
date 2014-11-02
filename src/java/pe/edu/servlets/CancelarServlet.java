/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.servlets;

import edu.pe.clases.PartidosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.bean.UsuarioBean;

/**
 *
 * @author Rafael
 */
public class CancelarServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession s = request.getSession(true);
        
        String id = (String) request.getAttribute("id");
          
        PartidosDAO p = new PartidosDAO();
              
        p.cancelarPartido(id);
        
        request.setAttribute("usuario", request.getParameter("usuario"));
        System.out.println("este es el usuario " +request.getParameter("usuario"));
        
        RequestDispatcher rd = request.getRequestDispatcher("listpartusu.jsp");
        rd.forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
