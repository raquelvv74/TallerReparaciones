package controlador;

import DAO.DBConnection;

public class TestConexion {
    public static void main(String[] args) {
        DBConnection.getInstance().getConnection();
    }
}

