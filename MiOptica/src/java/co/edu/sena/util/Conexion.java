package co.edu.sena.util;

import java.sql.*;


public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/mioptica?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private static Connection conexion = null;

    // Constructor privado para evitar instanciación externa
    private Conexion() {
    }

    // Método público estático para obtener la conexión
    public static Connection getConexion() {
        if (conexion == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver de MySQL
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                try (Statement st = conexion.createStatement()) {
                    st.execute("SET NAMES 'utf8mb4'");
                }
            } catch (ClassNotFoundException e) {
                System.err.println("❌ Error: No se encontró el driver de MySQL.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("❌ Error al conectar con la base de datos.");
                e.printStackTrace();
            }
        }
        return conexion;
    }

    // Método para cerrar la conexión (opcional)
    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null;
                System.out.println("🔒 Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println("⚠️ Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
}
