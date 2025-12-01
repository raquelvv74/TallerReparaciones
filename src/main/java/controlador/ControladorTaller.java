package controlador;

import java.util.ArrayList;

import DAO.MySQL.UsuarioDAOMySQL;
import DAO.MySQL.ReparacionDAOMySQL;
import DAO.MySQL.ClienteDAOMySQL;
import entities.Cliente;
import entities.Reparacion;

public class ControladorTaller {

	private static ControladorTaller instance;

	private ControladorTaller() {
	}

	public static ControladorTaller getInstance() {
		if (instance == null) {
			instance = new ControladorTaller();
		}
		return instance;
	}

	UsuarioDAOMySQL usuarioDAO = new UsuarioDAOMySQL();
	ReparacionDAOMySQL reparacionDAO = new ReparacionDAOMySQL();
	ClienteDAOMySQL clienteDAO = new ClienteDAOMySQL();

	// LOGIN
	public boolean iniciarSesion(String dni, String password) {
		return usuarioDAO.login(dni, password);
	}

	// REPARACIONES
	public ArrayList<Reparacion> obtenerReparacionesFinalizadas() {
		return reparacionDAO.findFinalizadas();
	}

	// CLIENTES
	public ArrayList<Cliente> listarClientes() {
		return clienteDAO.findAll();
	}

	public void insertarCliente(Cliente c) {
		clienteDAO.insert(c);
	}

	public Cliente buscarClientePorDni(String dni) {
		return clienteDAO.findByDni(dni);
	}
	
	// ----------------- USUARIOS -----------------
	public void insertarUsuario(entities.Usuario u) {
	    usuarioDAO.insert(u);
	}

	public ArrayList<entities.Usuario> listarUsuarios() {
	    return usuarioDAO.findall();
	}

	public entities.Usuario buscarUsuarioPorNombre(String nombre) {
	    return usuarioDAO.findByNombre(nombre);
	}

}
