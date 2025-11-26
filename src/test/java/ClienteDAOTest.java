import org.junit.jupiter.api.Test;

import DAO.DAOFactory;
import DAO.MySQLDAOFactory;
import DAO.interfaces.ClienteDAOInterface;
import entities.Cliente;

class ClienteDAOTest {
	private DAOFactory factory;
	private ClienteDAOInterface  clienteDAO;
	
	public ClienteDAOTest() {
		factory = new MySQLDAOFactory();
		clienteDAO = factory.getClienteDAO();
	}
	
	@Test
	void testInsertar(Cliente c) {
		//fail("Not yet implemented");
		Cliente c = new Cliente();
		// Insertas cliente
		int res = clienteDAO.insert(c); 
		// Compruebas que el codigo retornado del DAO de cliente.insert es mayor que 0
		assertEqual( res, 1);
	}
	
	@Test
	void testBorrar(Cliente c) {
		//fail("Not yet implemented");
	}

}
