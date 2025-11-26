package DAO.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.DBConnection;
import DAO.interfaces.ClienteDAOInterface;
import entities.Cliente;

public class ClienteDAOMySQL implements ClienteDAOInterface {

	// CONEXION CON LA BASE DE DATOS
	private Connection conexion;

	public ClienteDAOMySQL() throws SQLException {
		conexion = DBConnection.getInstance().getConnection();
	}

	@Override
	public int insert(Cliente c) {
		int res = 0;
		try {
			String sql = "INSERT INTO cliente (id_cliente, nombre, email, dni) VALUES(?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, 1);
			pst.setString(2, c.getNombre());
			pst.setString(3, c.getEmail());
			pst.setString(4, c.getDni());
			
			res = pst.executeUpdate();
			System.out.println("resultado de inserccion:" + res);
		}catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}
		return res;
	}

	@Override
	public int update(Cliente c) {
		return 0;
	}

	@Override
	public int delete(int id_cliente) {
		return 0;
	}

	@Override
	public ArrayList<Cliente> findAll() {
		return new ArrayList<Cliente>();	}

	@Override
	public Cliente findById(int id_cliente) {
		return null;
	}

	@Override
	public Cliente findByDni(String dni) {
		return null;
	}
}
