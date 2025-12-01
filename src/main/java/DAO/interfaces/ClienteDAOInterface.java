package DAO.interfaces;

import java.util.ArrayList;

import entities.Cliente;

public interface ClienteDAOInterface {
	int insert(Cliente c);
    int update(Cliente c);
    int delete(int id_cliente);
    ArrayList<Cliente> findAll();
    Cliente findById(int id_cliente);
    Cliente findByDni(String dni);
}
