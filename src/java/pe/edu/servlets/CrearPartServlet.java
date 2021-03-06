/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.servlets;

import com.mongodb.BasicDBObject;
import edu.pe.clases.PartidosDAO;
import edu.pe.clases.PartidosIF;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.bean.PartidoBean;

/**
 *
 * @author GooMoonRyong
 */
@WebServlet(name = "InscServlet", urlPatterns = {"/InscServlet"})
public class CrearPartServlet extends HttpServlet {

    //Viene de usuario.jsp de la pestaña crear partido
    //saca las canchas de la BD y envia las a partidos.jsp
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Paso 1: recuperar sesion
        HttpSession s = request.getSession(true);

        //El DAO de partidos debe tener un metodo para sacar la lista de canchas que estan en la BD
        PartidosDAO p = new PartidosDAO();

        //Deberia ser
        //List l = p.canchas();
        List l = p.buscarCanchas();

        request.setAttribute("usuario", request.getParameter("usuario"));
        request.setAttribute("canchas", l);

        RequestDispatcher rd = request.getRequestDispatcher("partidos.jsp");
        rd.forward(request, response);
    }

    //viene de partidos.jsp al hacer click en crear
    //guarda los datos del partido en la BD y redirige a usuario.jsp
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession s = request.getSession(true);
        PartidosDAO p = new PartidosDAO();
        PartidoBean p1 = new PartidoBean();

        p1.setCancha(request.getParameter("canchas"));
        p1.setFechai(request.getParameter("fecha"));
        p1.setAdmin(request.getParameter("usuario"));
        p1.setTurno(Integer.parseInt(request.getParameter("turnos")));

//       
//        ArrayList jug = new ArrayList();
//
//        //metele los jugadores aqui

        
       
            
           
        

        p.crearPartido(p1);

        request.setAttribute("usuario", request.getParameter("usuario"));
        request.setAttribute("servlet", "algo");

        RequestDispatcher rd = request.getRequestDispatcher("LoginServlet");
        rd.forward(request, response);
    }
}
