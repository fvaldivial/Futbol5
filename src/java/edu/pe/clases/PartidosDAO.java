/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pe.clases;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.bean.PartidoBean;

public class PartidosDAO implements PartidosIF {

    MongoClient mc = null;
    DB DB = null;
    DBCollection usuarios = null;

    private void inicializar() throws UnknownHostException {

        mc = new MongoClient("localhost", 27017);
        DB = mc.getDB("futbol5");
        usuarios = DB.getCollection("users");
        //System.out.println("okokokk");
    }

    @Override
    public List<PartidoBean> normal() {
        List l = new ArrayList<PartidoBean>();
        PartidoBean p = null;
        int nump = 0;

        try {
            //conexion con base de datos
            inicializar();
            //sacar las cosas de la bd
        } catch (UnknownHostException ex) {
            Logger.getLogger(PartidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        //poner los datos a cada partidoBean
        //poner un contador para saber cuantos partidos hay
        for (int i = 0; i <= nump; i++) {
            l.add(p);
        }

        return l;
    }

    public void crearPartido(PartidoBean pb) throws UnknownHostException {
        inicializar();
        

    }

    public void listarPartidos() throws UnknownHostException {
        inicializar();

        DBCursor cursor = usuarios.find();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }

    }

    public void listarPartidosXUsuario() throws UnknownHostException {
        inicializar();

    }

    public void cancelarPartido() throws UnknownHostException {
        inicializar();

    }

}
