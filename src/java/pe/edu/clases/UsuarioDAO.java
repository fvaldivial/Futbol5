package pe.edu.clases;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.bean.UsuarioBean;

public class UsuarioDAO implements Usuarios5IF {

    MongoClient mc = null;
    DB DB = null;
    DBCollection usuarios = null;

    private void inicializar() throws UnknownHostException {

        mc = new MongoClient("localhost", 27017);
        DB = mc.getDB("futbol5");
        usuarios = DB.getCollection("users");
        System.out.println("okokokk");
    }

    //que dijo de esto???
    
    @Override
    public boolean registrarUsuario(UsuarioBean u, String password) throws Exception {
        inicializar();
        //poner singleton aqui
      

        DBObject userc = usuarios.findOne(new BasicDBObject("_id", u.getDni()));

        if (userc == null) {

            Random randito = new SecureRandom();
            String passwordHash = Utilitarios.makePasswordHash(password, Integer.toString(randito.nextInt()));

            BasicDBObject user = new BasicDBObject();

            user.append("_id", u.getDni()).append("password", passwordHash).append("nombre", u.getNombre()).append("telf", u.getEmail());

            if (u.getEmail() != null && !u.getEmail().equals("")) {
                // Si es que el email no esta en blanco, lo graba
                user.append("email", u.getEmail());
            }

            usuarios.insert(user);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public DBObject Login(String password, String usuario) {
        try {
            inicializar();
        } catch (UnknownHostException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        DBObject user;
        System.out.println("1");
        user = usuarios.findOne(new BasicDBObject("_id", usuario));
        System.out.println("2");
        if (user == null) {
            System.out.println("Usuario no existe");
            return null;
        }

        String hashedAndSalted = user.get("password").toString();

        String salt = hashedAndSalted.split(",")[1];

        if (!hashedAndSalted.equals(Utilitarios.makePasswordHash(password, salt))) {
            //System.out.println("Contraseña incorrecta");
            return null;
        }

        //aca va a caer
        return user;

    }


}
