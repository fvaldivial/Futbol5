/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.factory;

public class FactoryPartido {
    
    public static Inspart getPartido(String tamano){
          
    if ( tamano.equals("pequeno") )
      return new normalDAO();
   
    else if ( tamano.equals("grande") )
      return new solidarioDAO();
    
  
    return null;
    
    
  }
    
}
