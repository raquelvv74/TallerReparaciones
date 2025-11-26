package vista;

import java.util.Scanner;

public class VistaTaller {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int opcion;
		do {
			menuNavegacionGeneral();
			opcion = leer.nextInt();
			// ESTO SE USABA PARA LIMPIAR EL BUFFER
			leer.nextLine();
			switch (opcion) {
			case 1:
				iniciarSesion(leer);
				break;
			case 2:
				verReparacionesFinalizadas();
				break;
			default:
				System.out.println("Opción inválida. Inténtalo de nuevo.");
			}

		} while (opcion != 0);
		System.out.println("Saliendo...");
		leer.close();

	}

	public static void iniciarSesion(Scanner sc) {

	}

	public static void verReparacionesFinalizadas() {

	}

	public static void menuNavegacionGeneral() {
		System.out.println("MENÚ");
		System.out.println("Escoge qué quieres hacer: ");
		System.out.println("0. Salir.");
		System.out.println("1. Iniciar sesión");
		System.out.println("2. Ver reparaciones finalizadas");
	}
}
