/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.modelo;

import co.edu.sena.util.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario extends Persona{
    private String clave;
    private int estado;
    
    public Usuario login(Usuario usuario){
       ResultSet r= null;
       Connection con =Conexion.getConexion();
       String sql="SELECT roles_id FROM usuarios WHERE correo=? and clave=?";
       
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getClave());
            
            r=ps.executeQuery();
            if(r.next()){
                usuario.setRol(r.getInt(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
    }
    
    
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
