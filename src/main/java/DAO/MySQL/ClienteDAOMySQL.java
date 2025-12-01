package DAO.MySQL;

import java.sql.*;
import java.util.ArrayList;

import DAO.DBConnection;
import DAO.interfaces.ClienteDAOInterface;
import entities.Cliente;

public class ClienteDAOMySQL implements ClienteDAOInterface {

    @Override
    public int insert(Cliente c) {
        String sql = "INSERT INTO cliente (nombre, email, dni, telefono) VALUES (?, ?, ?, ?)";
        Connection con = DBConnection.getInstance().getConnection();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getDni());
            ps.setString(4, c.getTelefono());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(Cliente c) {
        String sql = "UPDATE cliente SET nombre=?, email=?, dni=?, telefono=? WHERE id_cliente=?";
        Connection con = DBConnection.getInstance().getConnection();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getDni());
            ps.setString(4, c.getTelefono());
            ps.setInt(5, c.getId_cliente());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(int id_cliente) {
        String sql = "DELETE FROM cliente WHERE id_cliente=?";
        Connection con = DBConnection.getInstance().getConnection();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id_cliente);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public ArrayList<Cliente> findAll() {
        String sql = "SELECT * FROM cliente";
        ArrayList<Cliente> lista = new ArrayList<>();
        Connection con = DBConnection.getInstance().getConnection();

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("dni"),
                        rs.getString("telefono")
                );
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Cliente findById(int id_cliente) {
        String sql = "SELECT * FROM cliente WHERE id_cliente=?";
        Cliente c = null;
        Connection con = DBConnection.getInstance().getConnection();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id_cliente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = new Cliente(
                            rs.getInt("id_cliente"),
                            rs.getString("nombre"),
                            rs.getString("email"),
                            rs.getString("dni"),
                            rs.getString("telefono")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }

    @Override
    public Cliente findByDni(String dni) {
        String sql = "SELECT * FROM cliente WHERE dni=?";
        Cliente c = null;
        Connection con = DBConnection.getInstance().getConnection();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = new Cliente(
                            rs.getInt("id_cliente"),
                            rs.getString("nombre"),
                            rs.getString("email"),
                            rs.getString("dni"),
                            rs.getString("telefono")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }
}
