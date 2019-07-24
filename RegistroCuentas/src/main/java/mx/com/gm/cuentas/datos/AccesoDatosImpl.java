package mx.com.gm.cuentas.datos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import mx.com.gm.cuentas.domain.*;
import mx.com.gm.cuentas.excepciones.*;

public class AccesoDatosImpl implements AccesoDatos {

	@Override
	public boolean existe(String nombreArchivo) throws AccesoDatosEx {
		File archivo = new File(nombreArchivo);
		return archivo.exists();
	}

	@Override
	public void escribir(Cuenta cuenta, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
		File archivo = new File(nombreArchivo);
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
			salida.println(cuenta);
			salida.close();
			System.out.println("Se ha escrito correctamente al archivo");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public String buscar(String buscar, String nombreArchivo) throws LecturaDatosEx {
		File archivo = new File(nombreArchivo);
		String resultado = null;
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String linea = null;
			int i = 0;
			linea = entrada.readLine();
			while (linea != null) {
				if (buscar != null && buscar.equalsIgnoreCase(linea)){
					resultado = "Cuenta " + linea + " encontrada en indice " + i;
					break;
				}
				linea = entrada.readLine();
				i++;
			}
			entrada.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	@Override
	public void crear(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo));
			salida.close();
			System.out.println("Se ha creado el archivo correctamente");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void borrar(String nombreArchivo) throws AccesoDatosEx {
		File archivo = new File(nombreArchivo);
		archivo.delete();
		System.out.println("Se ha borrado el archivo correctamente");
	}

	@Override
	public List<Cuenta> listar(String nombreArchivo) throws LecturaDatosEx {
		File archivo = new File(nombreArchivo);
		List<Cuenta> cuenta = new ArrayList<Cuenta>();
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String linea = null;
			linea = entrada.readLine();
			while (linea != null) {
				Cuenta cuentas = new Cuenta(linea);
				
				cuenta.add(cuentas);
				linea = entrada.readLine();
			}
			entrada.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return cuenta;
	}

}