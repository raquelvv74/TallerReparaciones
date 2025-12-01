import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class UsuarioDAOTest {

	@Test
	void test() {
		MySQLDAOFactory factory = new MySQLDAOFactory();
		try (UsuarioDAOMySQL usuarioDAO = (UsuarioDAOMySQL) factory.getUsuarioDAO()) {
			Usuario usuario = new Usuario("111111111", "Gonzalo", "password", "Mecanico");
			int rc = usuarioDAO.insert(usuario);
			System.out.println(
					"Usuario " + usuario.getNombre() + " con dni " + usuario.getDni() + " creado. ID asignado:" + rc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
