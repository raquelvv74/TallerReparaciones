package DAO;

import DAO.MySQL.ClienteDAOMySQL;
import DAO.MySQL.UsuarioDAOMySQL;
import DAO.MySQL.ReparacionDAOMySQL;
import DAO.interfaces.ClienteDAOInterface;
import DAO.interfaces.UsuarioDAOInterface;
import DAO.interfaces.ReparacionDAOInterface;

public class MySQLDAOFactory implements DAOFactory {

	@Override
	public ClienteDAOInterface getClienteDAO() {
		return new ClienteDAOMySQL();
	}

	@Override
	public UsuarioDAOInterface getUsuarioDAO() {
		return new UsuarioDAOMySQL();
	}

	@Override
	public ReparacionDAOInterface getReparacionDAO() {
		return new ReparacionDAOMySQL();
	}
}
