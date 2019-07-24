package mx.com.gm.cuentas.negocio;

import java.util.List;

import mx.com.gm.cuentas.datos.*;
import mx.com.gm.cuentas.domain.*;
import mx.com.gm.cuentas.excepciones.*;

public class CatalogoCuentasImpl implements CatalogoCuentas {

	private final AccesoDatos datos;

	public CatalogoCuentasImpl() {
		this.datos = new AccesoDatosImpl();
	}

	@Override
	public void agregarCuenta(String numeroCuenta, String rutaArchivo) {
		Cuenta cuenta = new Cuenta(numeroCuenta);
		boolean anexar = false;
		try {
			anexar = datos.existe(rutaArchivo);
			datos.escribir(cuenta, rutaArchivo, anexar);
		} catch (AccesoDatosEx ex) {
			System.out.println("Error de acceso a datos");
			ex.printStackTrace();
		}
	}

	@Override
	public void listarCuentas(String rutaArchivo) {
		try {
			List<Cuenta> cuentas = datos.listar(rutaArchivo);
			for (Cuenta cuenta : cuentas) {
				System.out.println(cuenta);
			}
		} catch (AccesoDatosEx ex) {
			System.out.println("Error de acceso a datos");
			ex.printStackTrace();
		}
	}

	@Override
	public void buscarCuenta(String rutaArchivo, String buscar) {
		String resultado = null;
		try {
			resultado = datos.buscar(buscar, rutaArchivo);
			if (resultado != null) {
				System.out.println("Resultado busqueda : " + resultado);

			} else {
				System.out.println(
						"No se encontro " + buscar + " En la BD No fue Encontrado verifique el numero de cuenta");
			}
		} catch (LecturaDatosEx ex) {
			System.out.println("Error al buscar la cuenta");
			ex.printStackTrace();
		}

	}

	@Override
	public void iniciarArchivo(String rutaArchivo) {
		try {
			if (datos.existe(rutaArchivo)) {
				datos.borrar(rutaArchivo);
				datos.crear(rutaArchivo);
			} else {
				// creamos archivo
				datos.crear(rutaArchivo);
			}
		} catch (AccesoDatosEx ex) {
			System.out.println("Error de acceso a datos");
			ex.printStackTrace();
		}
	}
}
