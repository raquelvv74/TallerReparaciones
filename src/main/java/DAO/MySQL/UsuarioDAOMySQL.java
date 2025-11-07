package DAO.MySQL;

public class UsuarioDAOMySQL implements UsuarioDAOInterface{
	boolean login(String dni, String password);
	int insert(Usuario u);
	ArrayList<Usuario> findall();
	Usuario findByNombre(String nombre);
}
