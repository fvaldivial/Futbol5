/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.servlets;

import com.mongodb.DBObject;
import edu.pe.clases.PartidosDAO;
import edu.pe.clases.UsuarioDAO;
import edu.pe.clases.UsuarioIF;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
public class PartInsServlet extends HttpServlet {

    
    //este sera para inscripcion solidaria
    //SE debe tener un metodo del DAO que ponga a los usuarios en una lista solidaria
    //el tema del tiempo maximo lo vemos despues
    //como funcione tambien, con que los grabe esta bien por ahora    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //aca comienza   
        HttpSession s = request.getSession(true);
        
        //con el metodo del dao ya creado voy a sacar toda la info del usuario
        
        UsuarioBean u;
        
        UsuarioIF ui = new UsuarioDAO();
        
        //Poner info2 en un utilitario si es necesario
        u = ui.getInfo2(request.getParameter("usuario"));
        
//        //con el metodo del DAO deberia ponerse al usuario en la lista de solidarios
//        algoIF a = new algoDAO();
//        a.insolidaria(u);
//                
//       //No deberia haber errores de inscripcion aca     
//         
//         RequestDispatcher rd = request.getRequestDispatcher("LoginServlet");
//         rd.forward(request, response);
            
    }

    //por ahora solo sirve el inscribirse
    //El metodo DAO tiene que sacar la lista de jugadores para saber si ya esta inscrito y no inscribir doble
    //El metodo DAO(otro) tambien tiene que poder dejar inscribirlo
    //Te lo manda desde lista partido al hacer click en inscribirse
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //aca comienza
        HttpSession s = request.getSession(true);
        
        PartidoBean p = (PartidoBean)request.getAttribute("partido");
        
        UsuarioBean u = (UsuarioBean) request.getAttribute("usuario");
        
        boolean inscrito = false;
        
//        //Para fabrizzio y rafael ( MAS PARA FABRIZZIO) : PAR DE IMBECILES ALGUNA SIQUIERA SABE COMO DIABLOS SE USA UN DAO CON
//        //UNA INTERFAZ? HAS LAS COSAS BIEN 1 VEZ FABRIZZIO Y USA LA INTERFAZ Y NO HAGAS WEVADAS.
//        
//        AlgoIF a = new AlgoDAO();
//        
//        //aca debe ir el metodo del DAO que saque una lista con los usuarios inscritos para el partido
//        List l = a.getUsuarios();
//        
//        for(int i = 0 ; i < l.size ; i++){
//            if(l.get(i).equals(u.getUsuario())){
//                inscrito = true;
//            }
//        }
//        
//        if(inscrito == false){
//            //Usando el metodo del DAO que inscribe al partido
//            a.inscribir(u.getUsuario());
//            //luego lo mandas a su pagina
//            RequestDispatcher rd = request.getRequestDispatcher("LoginServlet");
//            rd.forward(request, response);
//        }else{
//            //Pagina de no puedes intentalo nuevamente
//            PrintWriter out = response.getWriter();
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>!!!Ya estas inscrito!!!</title>");
//            out.println("<link href=\"css/landing-page.css\" rel=\"stylesheet\">");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<div class=\"intro-header\">");
//            out.println("<h1> Ya estas inscrito en este partido y no puedes inscribirte nuevamente </h1>");
//            out.println("<h1> regrese al listado de partidos </h1>");
//            out.println("<a href= 'PartidoServlet?usuario=" + u.getUsuario() + "'>Intentarlo de nuevo</a>");
//            out.println("</div>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//        
//        
        
        
        
    }

}
