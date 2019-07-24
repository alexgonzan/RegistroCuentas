package mx.com.gm.cuentas.datos;

import static org.junit.Assert.*;

import org.junit.Test;

import mx.com.gm.cuentas.negocio.CatalogoCuentasImpl;

public class CatalogoCuentasImplTest {

	CatalogoCuentasImpl catalogo = new CatalogoCuentasImpl();
	
	@Test
	public void iniciarArchivo() {
		
		String rutaArchivo = "C:\\Users\\agonzalez\\Documents\\AGG\\Tareas\\Curso\\cuentas.txt";
		catalogo.iniciarArchivo(rutaArchivo);
	}

}
