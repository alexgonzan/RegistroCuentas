package rpcreportecuentas;

import java.util.Scanner;

import mx.com.gm.cuentas.negocio.*;

public class ReporteCuentas {

	private static final Scanner scanner = new Scanner(System.in);
	private static int opcion = -1;
	private static final String nombreArchivo = "C:\\Users\\agonzalez\\Documents\\AGG\\Tareas\\Curso\\cuentas.txt";
	private static final CatalogoCuentas catalogoCuentas = new CatalogoCuentasImpl();

	public static void main(String[] args) {

		/** Mientras la opcion elegida sea 0, preguntamos al usuario */
		while (opcion != 0) {
			try {
				System.out.println("Elige opcion:\n1.- Iniciar catalogo cuentas" + "\n2.- Agregar Cuenta\n"
						+ "3.- Listar Cuentas\n" + "4.- Buscar Cuenta\n" + "0.- Salir");

				opcion = Integer.parseInt(scanner.nextLine());

				/** Ejemplo de switch case en Java */
				switch (opcion) {
				case 1:
					/** 1. Creamos el objeto que administra el catalogo de cuentas
					  * La creacion del archivo es opcional, de todas maneras se creara
					  * al escribir por primera vez en el archivo
					  */
					
					catalogoCuentas.iniciarArchivo(nombreArchivo);
					break;
				case 2:
					/** 2. agregar informacion archivo */
					System.out.println("Introduce el numero de una cuenta a agregar:");
					String numCuenta = scanner.nextLine();
					
					catalogoCuentas.agregarCuenta(numCuenta, nombreArchivo);
					break;
				case 3:
					/** 3. listar catalogo completo*/
					catalogoCuentas.listarCuentas(nombreArchivo);
					break;
				case 4:
					/** 4. Buscar cuenta */
					System.out.println("Introduce el numero de una cuenta a buscar:");
					String buscar = scanner.nextLine();
					catalogoCuentas.buscarCuenta(nombreArchivo, buscar);
					break;
				case 0:
					System.out.println("!Hasta pronto!");
					break;
				default:
					System.out.println("Opcion no reconocida");
					break;
				}
				System.out.println("\n");

			} catch (Exception e) {
				System.out.println("Error!");
			}
		}
	}
}
