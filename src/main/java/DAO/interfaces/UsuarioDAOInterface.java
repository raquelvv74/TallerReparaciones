package DAO.interfaces;

import DAO.MySQL.ArrayList;
import DAO.MySQL.Usuario;

public interface UsuarioDAOInterface {
	boolean login(String dni, String password);
	int insert(Usuario u);
	ArrayList<Usuario> findall();
	Usuario findByNombre(String nombre);
}

