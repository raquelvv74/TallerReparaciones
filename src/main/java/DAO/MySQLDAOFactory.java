package DAO;

import java.sql.SQLException;

import DAO.MySQL.ClienteDAOMySQL;
import DAO.interfaces.ClienteDAOInterface;

public class MySQLDAOFactory implements DAOFactory {

	@Override
	public ClienteDAOInterface getClienteDAO() {
		// TODO Auto-generated method stub
		ClienteDAOInterface clienteDAO = null;
		try {
			clienteDAO = new ClienteDAOMySQL();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clienteDAO;
	}

}
