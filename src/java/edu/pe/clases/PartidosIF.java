package edu.pe.clases;

import java.util.List;
import pe.edu.bean.PartidoBean;


public interface PartidosIF {
    
    public List<PartidoBean> normal();
    
    public List listarPartidosXUsuario(String admin);
    
    public void cancelarPartido(String id);
    
    public List buscarCanchas();
    
    
}
