package DAO.MySQL;

import java.sql.*;
import java.util.ArrayList;

import DAO.DBConnection;
import DAO.interfaces.UsuarioDAOInterface;
import entities.Usuario;

public class UsuarioDAOMySQL implements UsuarioDAOInterface {

	@Override
	public boolean login(String dni, String password) {
		String sql = "SELECT * FROM usuario WHERE dni = ? AND password = ?";
		Connection con = DBConnection.getInstance().getConnection();

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, dni);
			ps.setString(2, password);

			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public int insert(Usuario u) {
		String sql = "INSERT INTO usuario (nombre_usuario, password, rol, dni) VALUES (?, ?, ?, ?)";
		Connection con = DBConnection.getInstance().getConnection();

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, u.getNombre_usuario());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getRol());
			ps.setString(4, u.getDni());

			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public ArrayList<Usuario> findall() {
		String sql = "SELECT * FROM usuario";
		ArrayList<Usuario> lista = new ArrayList<>();
		Connection con = DBConnection.getInstance().getConnection();

		try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId_usuario(rs.getInt("id_usuario"));
				u.setNombre_usuario(rs.getString("nombre_usuario"));
				u.setPassword(rs.getString("password"));
				u.setRol(rs.getString("rol"));
				u.setDni(rs.getString("dni"));
				lista.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Usuario findByNombre(String nombre) {
		String sql = "SELECT * FROM usuario WHERE nombre_usuario = ?";
		Usuario u = null;
		Connection con = DBConnection.getInstance().getConnection();

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, nombre);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					u = new Usuario();
					u.setId_usuario(rs.getInt("id_usuario"));
					u.setNombre_usuario(rs.getString("nombre_usuario"));
					u.setPassword(rs.getString("password"));
					u.setRol(rs.getString("rol"));
					u.setDni(rs.getString("dni"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}
}
