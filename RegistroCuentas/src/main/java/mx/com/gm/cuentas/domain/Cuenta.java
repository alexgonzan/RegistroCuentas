package mx.com.gm.cuentas.domain;

public class Cuenta {

    String numero;
    

    public Cuenta(String numeroCuenta) {
        this.numero = numeroCuenta;
        
    }

    public String getNombre() {
        return numero;
    }

    public void setNombre(String numero) {
        this.numero = numero;
    }

	@Override
	public String toString() {
		return "" + numero + "";
	}

	


	

    
}
