package DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DBConnection {

    private static DBConnection instance;
    private Connection conexionMySQL = null;

    private DBConnection() {
        try {
            // Cargar los datos del archivo de propiedades
            Properties props = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("conexion.properties");
            props.load(input);

            // Configurar el datasource de MySQL
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL(props.getProperty("url"));
            dataSource.setUser(props.getProperty("user"));
            dataSource.setPassword(props.getProperty("password"));

            // Establecer la conexión
            conexionMySQL = dataSource.getConnection();
            System.out.println("> Conexión establecida correctamente");

        } catch (Exception e) {
            System.err.println("> Error al conectar con MySQL: " + e.getMessage());
        }
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return conexionMySQL;
    }
}
