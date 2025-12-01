package DAO;

import DAO.interfaces.ClienteDAOInterface;
import DAO.interfaces.UsuarioDAOInterface;
import DAO.interfaces.ReparacionDAOInterface;

public interface DAOFactory {

	ClienteDAOInterface getClienteDAO();

	UsuarioDAOInterface getUsuarioDAO();

	ReparacionDAOInterface getReparacionDAO();

}
