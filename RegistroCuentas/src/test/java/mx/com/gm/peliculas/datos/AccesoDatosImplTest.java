package mx.com.gm.peliculas.datos;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import mx.com.gm.cuentas.datos.AccesoDatos;
import mx.com.gm.cuentas.datos.AccesoDatosImpl;
import mx.com.gm.cuentas.domain.Cuenta;
import mx.com.gm.cuentas.excepciones.AccesoDatosEx;
import mx.com.gm.cuentas.excepciones.EscrituraDatosEx;
import mx.com.gm.cuentas.excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;




public class AccesoDatosImplTest {
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}

	
	AccesoDatos datos = new AccesoDatosImpl();
		
	@Mock
	File mockFile = new File("");

	@Test
	public void giveValidateFileOkWhenExisteThenReturnTrue() throws AccesoDatosEx{
		
		boolean expectedResponse = true;
		String rutaArchivo = "C:\\Users\\agonzalez\\Documents\\AGG\\Tareas\\Curso\\cuentas.txt";
		Mockito.when(mockFile.exists()).thenReturn(expectedResponse);
		boolean response = datos.existe(rutaArchivo);
		
		assertEquals(expectedResponse, response );
	}
	
	@Test
	public void giveInvalidateFileWhenExisteThenReturnTrue() throws AccesoDatosEx{
		
		boolean expectedResponse = false;
		String rutaArchivo = "C:\\Users\\agonzalez\\Documents\\AGG\\Tareas\\Curso\\cuenticas.txt";
		
		boolean response = datos.existe(rutaArchivo);
		
		assertEquals(expectedResponse, response );
		
	}
	
	@Test(expected = Exception.class)
	public void giveValidateFileNullWhenExisteThenReturnException() throws AccesoDatosEx {
		// Given 
		// ExpectedResponse
		String rutaArchivo = null;		
		// When 
		 datos.existe(rutaArchivo);

		// Then 
	
	}
	
	@Test
	public void giveInvalidateFileEmpyWhenExisteThenReturnFalse() throws AccesoDatosEx{
		// Given 
		// ExpectedResponse
		boolean expectedResponse = false;
		String rutaeArchivo = "";
		// When 
		boolean response = datos.existe(rutaeArchivo);
		// Then
		assertEquals(expectedResponse, response );
		
	}
	
	@Test 
	public void giveEmpyFileInValidWhenBuscarThenReturnnULL() throws LecturaDatosEx {
		// Given 
		// ExpectedResponse
		String rutaArchivo = "";
		String buscar = "";
		String expectedResponse = null;
		
		// When 
			
		// Then 	
		assertEquals(expectedResponse, datos.buscar(buscar, rutaArchivo));
		
	}
	
	
	
	@Test 
	public void giveFileEmpyFileValidWhenBuscarThenReturnNull() throws LecturaDatosEx {
		// Given
		// ExpectedResponse
		String rutaArchivo = "C:\\Users\\agonzalez\\Documents\\AGG\\Tareas\\Curso\\cuentas.txt";
		String buscar = " ";
		String expectedResponse = null;
		
		// When 
			
		// Then 	
		assertEquals(expectedResponse, datos.buscar(buscar, rutaArchivo));
		
	}
	
	@Test 
	public void giveFileInValidWhenBuscarThenReturnNull() throws LecturaDatosEx {
		// Given
		// ExpectedResponse
		String rutaArchivo = "";
		String buscar = "123456789";
		String expectedResponse = null;
		
		// When 
			
		// Then 	
		assertEquals(expectedResponse, datos.buscar(buscar, rutaArchivo));
		
	}
	
	@Test 
	public void giveFileValidWhenBuscarThenReturnString() throws LecturaDatosEx {
		// Given
		// ExpectedResponse
		String rutaArchivo = "C:\\Users\\agonzalez\\Documents\\AGG\\Tareas\\Curso\\Escritura.txt";
		String buscar = "123456";
		String expectedResponse = "Cuenta " +buscar+ " encontrada en indice "+ "0";
		
		// When 
			
		// Then 	
		assertEquals(expectedResponse, datos.buscar(buscar, rutaArchivo));
		
	}
	
	@Test
	public void giveFileValidWhenCrearThenReturnTrue() throws AccesoDatosEx {
		// Given 
		// ExpectedResponse
		String rutaArchivo = "C:\\Users\\agonzalez\\Documents\\AGG\\Tareas\\Curso\\cuentasPruebas.txt";
		boolean expected = true;
		
		// When 
		datos.crear(rutaArchivo);
		
        boolean actualResponse = datos.existe(rutaArchivo);
		
        // Then 		
		assertEquals(expected, actualResponse);
		
	}
	
	@Test
	public void giveFileInValidoWhenCrearThenReturnFalse() throws AccesoDatosEx {
		// Given 
		// ExpectedResponse
		String rutaArchivo = "";
		boolean expected = false;
		
		// When 
		datos.crear(rutaArchivo);
		
        boolean actualResponse = datos.existe(rutaArchivo);
		
        // Then 		
		assertEquals(expected, actualResponse);
		
	}
	
	@Test (expected = Exception.class)
	public void giveFileNullWhenCrearThenReturnException() throws AccesoDatosEx {
		// Given 
		// ExpectedResponse
		String rutaArchivo = null;
		// When 
		datos.crear(rutaArchivo);
		// Then 		
			
	}
	

	@Test
	public void giveFileValidWhenBorrarThenReturnFalse() throws AccesoDatosEx {
		// Given 
		// ExpectedResponse false porque el archivo se elimina se valida que no existe despues de la ejecucion del metodo
		
		String rutaArchivo = "C:\\Users\\agonzalez\\Documents\\AGG\\Tareas\\Curso\\cuentasPruebas.txt";
		boolean expected = false;
		
		// When 
		datos.borrar(rutaArchivo);	
        boolean actualResponse = datos.existe(rutaArchivo);
		
        // Then 	
		assertEquals(expected, actualResponse);
		
	}
	
	
	@Test
	public void giveFileNameEmpyInValidoWhenBorrarThenReturnFalse() throws AccesoDatosEx {
		// Given 
		// ExpectedResponse false porque el archivo se elimina se valida que no existe despues de la ejecucion del metodo
		
		String rutaArchivo = "";
		boolean expected = false;
		
		// When 
		datos.borrar(rutaArchivo);	
        boolean actualResponse = datos.existe(rutaArchivo);
		
        // Then 	
		assertEquals(expected, actualResponse);
		
	}
	
	@Test (expected = Exception.class)
	public void giveFileNullInValidWhenBorrarThenReturnException() throws AccesoDatosEx {
		// Given 
		// ExpectedResponse false porque el archivo se elimina se valida que no existe despues de la ejecucion del metodo
		
		String rutaArchivo = null;
				
		// When 
		datos.borrar(rutaArchivo);	
       
		// Then 	
			
	}
	
	@Test
	public void giveArgValidFileValidWhenEscribirThenReturnInt() throws EscrituraDatosEx, IOException {
		// Given 
		// ExpectedResponse
		String rutaArchivo = "C:\\Users\\agonzalez\\Documents\\AGG\\Tareas\\Curso\\Escritura.txt";
		boolean anexar = true;
		File archivo = new File(rutaArchivo);
		String expected = "123456";
		Cuenta cuenta = new Cuenta(expected);
		
		// When
		datos.escribir(cuenta, rutaArchivo, anexar);
		
		//Lee la linea escrita en el archivo 
		BufferedReader entrada = new BufferedReader(new FileReader(archivo));
        String actualResponse = null;
        actualResponse = entrada.readLine();
		
        // Then 
		assertEquals(expected, actualResponse);
		entrada.close();
	}
	
	
	
	@Test(expected = Exception.class)
	public void giveFileNullWhenEscribirThenReturnException() throws EscrituraDatosEx, IOException {
		// Given 
		// ExpectedResponse
		String rutaArchivo = null;
		boolean anexar = true;
		String expected = "123456";
		Cuenta pelicula = new Cuenta(expected);
		
		// When
		datos.escribir(pelicula, rutaArchivo, anexar);
		
		// Then 
		
	}
	
	
	@Mock
	List<Cuenta> mockedList;
	@Test
	public void giveFileValidateWhenListarThenReturnInt() throws AccesoDatosEx{
		String rutaArchivo = "C:\\Users\\agonzalez\\Documents\\AGG\\Tareas\\Curso\\cuentas.txt";
		Cuenta cuenta = new Cuenta("98765431");
		mockedList.add(cuenta);
		
		Mockito.when(mockedList.size()).thenReturn(5);
		
		datos.listar(rutaArchivo);
		
		assertEquals(5, mockedList.size());
	
		
	}
	

	

}
