package DAO.interfaces;

import java.util.List;

import entities.Vehiculo;

public interface VehiculoDAO {
	int insert(Vehiculo vehiculo);
	int update(Vehiculo vehiculo);
	List<Vehiculo> findall();
	
	boolean deleteByMatricula(String matricula);
	Vehiculo findByMatricula(String matricula);
	
	boolean deleteByIdCliente(int idCliente);
	Vehiculo findByIdCliente(int idCliente);
}
