package DAO.MySQL;

import java.util.ArrayList;

import DAO.interfaces.UsuarioDAOInterface;
import entities.Usuario;

public class UsuarioDAOMySQL implements UsuarioDAOInterface {
	boolean login(String dni, String password){
		
	}

	int insert(Usuario u){
		
	}

	ArrayList<Usuario> findall();

	Usuario findByNombre(String nombre);
}
