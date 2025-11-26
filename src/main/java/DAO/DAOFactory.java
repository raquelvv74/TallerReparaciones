package DAO;

import DAO.interfaces.ClienteDAOInterface;

public interface DAOFactory {
	ClienteDAOInterface getClienteDAO();
}
