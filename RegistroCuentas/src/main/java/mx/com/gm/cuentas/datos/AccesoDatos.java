package mx.com.gm.cuentas.datos;

import java.util.List;

import mx.com.gm.cuentas.domain.*;
import mx.com.gm.cuentas.excepciones.*;

public interface AccesoDatos {
	
	boolean existe(String nombreArchivo) throws AccesoDatosEx;

	void escribir(Cuenta cuenta, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

	public String buscar(String buscar, String nombreArchivo) throws LecturaDatosEx;

	public void crear(String nombreArchivo) throws AccesoDatosEx;

	public void borrar(String nombreArchivo) throws AccesoDatosEx;
	
	public List<Cuenta> listar(String nombreArchivo) throws LecturaDatosEx;
}