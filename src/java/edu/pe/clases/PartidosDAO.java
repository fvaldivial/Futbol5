/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pe.clases;

import com.mongodb.BasicDBObject;
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
import pe.edu.bean.CanchaBean;
import pe.edu.bean.PartidoBean;

public class PartidosDAO implements PartidosIF {

    MongoClient mc = null;
    DB DB = null;
    DBCollection partidos = null;
    DBCollection canchas = null;

    private void inicializar() throws UnknownHostException {

        mc = new MongoClient("localhost", 27017);
        DB = mc.getDB("futbol5");
        partidos = DB.getCollection("partidos");
        canchas = DB.getCollection("canchas");
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
        BasicDBObject partido = new BasicDBObject();
        //verificar si la lista de jugadores se inserta correctamente
        partido.append("cancha", pb.getCancha()).append("admin", pb.getAdmin()).append("jugadores", pb.getJugadores()).append("turno", pb.getTurno()).append("fechai", pb.getFechai()).append("pago", pb.getPago());
        partidos.insert(partido);
    }

    public List listarPartidos() throws UnknownHostException {
        inicializar();

        List<PartidoBean> PB = new ArrayList<PartidoBean>();

        DBCursor cursor = partidos.find();
        try {
            while (cursor.hasNext()) {
                DBObject partido = new BasicDBObject();
                partido = cursor.next();
                PartidoBean u = new PartidoBean();
                u.setAdmin((String) partido.get("admin"));
                u.setCancha((String) partido.get("cancha"));
                //u.setCont(Integer.parseInt((String) partido.get("cont")));
                u.setFechai((String) partido.get("fechai"));
                u.setFechap((String) partido.get("fechap"));
                u.setId("" + partido.get("_id"));
                PB.add(u);
            }
        } finally {
            cursor.close();
        }

        return PB;
    }

    public List listarPartidosXUsuario(String admin) throws UnknownHostException {
        inicializar();

        List<PartidoBean> PB = new ArrayList<PartidoBean>();

        BasicDBObject query = new BasicDBObject("admin", admin);

        DBCursor cursor = partidos.find(query);
        try {
            while (cursor.hasNext()) {
                DBObject partido = new BasicDBObject();
                partido = cursor.next();
                PartidoBean u = new PartidoBean();
                u.setAdmin((String) partido.get("admin"));
                u.setCancha((String) partido.get("cancha"));
                //u.setCont(Integer.parseInt((String) partido.get("cont")));
                u.setFechai((String) partido.get("fechai"));
                u.setFechap((String) partido.get("fechap"));
                u.setId("" + partido.get("_id"));
                PB.add(u);

            }
        } finally {
            cursor.close();
        }

        return PB;

    }

    public void cancelarPartido(String id) throws UnknownHostException {
        //como se va a determinar que partido se cancela? bajo que pk?
        inicializar();
        BasicDBObject query = new BasicDBObject();
	query.put("_id", id);
	partidos.remove(query);
        

    }
    
    
    public List buscarCanchas()throws UnknownHostException {
        inicializar();

        List<CanchaBean> PB = new ArrayList<CanchaBean>();

        DBCursor cursor = canchas.find();
        try {
            while (cursor.hasNext()) {
                DBObject partido = new BasicDBObject();
                partido = cursor.next();
                CanchaBean u = new CanchaBean();
                u.setId(partido.get("_id") + "");
                u.setLocal((String) partido.get("local"));
                PB.add(u);

            }
        } finally {
            cursor.close();
        }

        return PB;
    }

}
