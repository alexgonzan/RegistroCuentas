package mx.com.gm.cuentas.negocio;


public interface CatalogoCuentas {

    public void agregarCuenta(String numCuenta, String nombreArchivo);

    public void listarCuentas(String nombreArchivo);

    public void buscarCuenta(String nombreArchivo, String buscar);

    public void iniciarArchivo(String nombreArchivo);

}
