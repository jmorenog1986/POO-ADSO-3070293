/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.modelo;

import co.edu.sena.util.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Paciente extends Persona {

    public boolean guardarPaciente(Paciente paciente) {

        boolean r = false;
        Connection con = Conexion.getConexion();
        String sql = "INSERT INTO `mioptica`.`pacientes` "
                + "(`documento`, `nombre`, `apellido`, `correo`, `telefono`, `fechaNacimiento`, `genero`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            try (Statement st = con.createStatement()) {
                st.execute("SET NAMES 'utf8mb4'");
            }
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getDocumento());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getApellido());
            ps.setString(4, paciente.getCorreo());
            ps.setString(5, paciente.getTelefono());
            ps.setObject(6, paciente.getFechaNaciemiento());
            ps.setString(7, paciente.getGenero());

            r = ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return r;
    }

    public boolean existePacientePorDocumento(String documento) {
        return false;
    }
}
