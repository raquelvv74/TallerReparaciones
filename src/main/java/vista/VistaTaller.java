package vista;

import java.util.ArrayList;
import java.util.Scanner;

import controlador.ControladorTaller;
import entities.Cliente;
import entities.Reparacion;
import entities.Usuario;

public class VistaTaller {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			menuNavegacionGeneral();
			System.out.print("Opción: ");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				verReparacionesFinalizadas();
				break;

			case 2:
				iniciarSesion(sc);
				break;

			case 3:
				menuClientes(sc);
				break;
			
			case 4:
				menuUsuarios(sc);
				break;

			case 0:
				System.out.println("Saliendo...");
				break;

			default:
				System.out.println("Opción no válida.");
			}

		} while (opcion != 0);

		sc.close();
	}

	// ----------------- LOGIN -----------------

	public static void iniciarSesion(Scanner sc) {
		ControladorTaller controlador = ControladorTaller.getInstance();

		System.out.print("DNI: ");
		String dni = sc.nextLine();

		System.out.print("Contraseña: ");
		String password = sc.nextLine();

		if (controlador.iniciarSesion(dni, password))
			System.out.println(">> Sesión iniciada");
		else
			System.out.println(">> Error en login");
	}

	// ----------------- REPARACIONES -----------------

	public static void verReparacionesFinalizadas() {
		ControladorTaller controlador = ControladorTaller.getInstance();

		ArrayList<Reparacion> lista = controlador.obtenerReparacionesFinalizadas();

		if (lista.isEmpty())
			System.out.println("No hay reparaciones finalizadas.");
		else {
			System.out.println("ID | Descripción | Fecha | Coste");
			for (Reparacion r : lista) {
				System.out.println(r.getId_reparacion() + " | " + r.getDescripcion() + " | " + r.getFecha_entrada()
						+ " | " + r.getCoste_estimado() + "€");
			}
		}
	}

	// ----------------- CLIENTES -----------------

	public static void menuClientes(Scanner sc) {

		ControladorTaller controlador = ControladorTaller.getInstance();
		int opcion;

		do {
			System.out.println("\n--- MENÚ CLIENTES ---");
			System.out.println("1. Listar clientes");
			System.out.println("2. Insertar cliente");
			System.out.println("3. Buscar por DNI");
			System.out.println("0. Volver");
			System.out.print("Opción: ");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {

			case 1:
				ArrayList<Cliente> lista = controlador.listarClientes();
				for (Cliente c : lista) {
					System.out.println(c.getId_cliente() + " | " + c.getNombre() + " | " + c.getEmail() + " | "
							+ c.getDni() + " | " + c.getTelefono());
				}
				break;

			case 2:
				System.out.print("Nombre: ");
				String nombre = sc.nextLine();
				System.out.print("Email: ");
				String email = sc.nextLine();
				System.out.print("DNI: ");
				String dni = sc.nextLine();
				System.out.print("Teléfono: ");
				String telefono = sc.nextLine();

				Cliente nuevo = new Cliente(0, nombre, email, dni, telefono);
				controlador.insertarCliente(nuevo);
				System.out.println("Cliente insertado.");
				break;

			case 3:
				System.out.print("Introduce DNI: ");
				String buscarDni = sc.nextLine();
				Cliente c = controlador.buscarClientePorDni(buscarDni);

				if (c != null)
					System.out.println("Encontrado: " + c.getNombre());
				else
					System.out.println("No existe ese cliente.");
				break;

			case 0:
				break;

			default:
				System.out.println("Opción no válida.");
			}

		} while (opcion != 0);
	}
	
	
	public static void menuUsuarios(Scanner sc) {
		ControladorTaller controlador = ControladorTaller.getInstance();
	    int opcion;

	    do {
	        System.out.println("\n--- MENÚ USUARIOS ---");
	        System.out.println("1. Crear usuario");
	        System.out.println("0. Volver");
	        System.out.print("Opción: ");
	        opcion = sc.nextInt();
	        sc.nextLine();

	        switch (opcion) {
	            case 1:
	                System.out.print("Nombre de usuario: ");
	                String nombre = sc.nextLine();
	                System.out.print("Contraseña: ");
	                String password = sc.nextLine();
	                System.out.print("Rol: ");
	                String rol = sc.nextLine();
	                System.out.print("DNI: ");
	                String dni = sc.nextLine();

	                Usuario nuevo = new Usuario();
	                nuevo.setNombre_usuario(nombre);
	                nuevo.setPassword(password);
	                nuevo.setRol(rol);
	                nuevo.setDni(dni);

	                controlador.insertarUsuario(nuevo);
	                System.out.println("Usuario creado correctamente.");
	                break;

	            case 0:
	                break;

	            default:
	                System.out.println("Opción no válida.");
	        }
	    } while (opcion != 0);
	}

	// ----------------- MENÚ GENERAL -----------------

	public static void menuNavegacionGeneral() {
		System.out.println("\n\\MENÚ DEL TALLER//");
	    System.out.println("0. Salir");
	    System.out.println("1. Ver reparaciones finalizadas (Invitado)");
	    System.out.println("2. Iniciar sesión");
	    System.out.println("3. Gestión de clientes");
	    System.out.println("4. Gestión de usuarios"); 
	}
}
