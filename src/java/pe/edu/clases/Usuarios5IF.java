
package pe.edu.clases;

import com.mongodb.DBObject;
import pe.edu.bean.UsuarioBean;


public interface Usuarios5IF {
    
    public boolean registrarUsuario(UsuarioBean u, String password) throws Exception;
    
    public DBObject Login(String password,String usuario);
    
    
}
