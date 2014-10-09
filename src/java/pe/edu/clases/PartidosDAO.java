/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.clases;

import java.util.ArrayList;
import java.util.List;
import pe.edu.bean.PartidoBean;

/**
 *
 * @author GooMoonRyong
 */
public class PartidosDAO implements PartidosIF{

    @Override
    public void solidaria() {
        //inscribirlo en la lista de solidarios
        //no tengo idea como sera la lista en la BD por eso no pongo logica
        //*****fabrizzio hazlo******
        
        
    }

    @Override
    public List<PartidoBean> normal() {
        
        List l = new ArrayList<PartidoBean>();
        PartidoBean p = null;
        int nump = 0;
        //conexion con base de datos
        
        //sacar las cosas de la bd 
        
        //poner los datos a cada partidoBean
        //poner un contador para saber cuantos partidos hay
        for(int i = 0 ; i<=nump ;i++){
            l.add(p);
        }
        
        
        return l;
    }
    
}
