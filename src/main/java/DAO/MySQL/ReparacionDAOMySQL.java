package DAO.MySQL;

import java.sql.*;
import java.util.ArrayList;

import DAO.DBConnection;
import DAO.interfaces.ReparacionDAOInterface;
import entities.Reparacion;

public class ReparacionDAOMySQL implements ReparacionDAOInterface {

	@Override
	public ArrayList<Reparacion> findFinalizadas() {
		String sql = "SELECT * FROM reparacion WHERE estado = 'finalizada'";
		ArrayList<Reparacion> lista = new ArrayList<>();
		Connection con = DBConnection.getInstance().getConnection();

		try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Reparacion r = new Reparacion();
				r.setId_reparacion(rs.getInt("id_reparacion"));
				r.setDescripcion(rs.getString("descripcion"));
				r.setFecha_entrada(rs.getDate("fecha_entrada"));
				r.setCoste_estimado(rs.getDouble("coste_estimado"));
				r.setEstado(rs.getString("estado"));
				r.setVehiculo_id(rs.getInt("vehiculo_id"));
				r.setUsuario_id(rs.getInt("usuario_id"));
				lista.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
}
