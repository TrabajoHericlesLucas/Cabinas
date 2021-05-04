package trabajoEntornos;

import java.util.Vector;
import java.time.*;

public class normal extends Cabina {
	private int numero,contVehiculos;
	private double precio;
	private String tipo;
	private Vector vehiculo;
	
	public normal(int numero) {
		super(numero);
		this.precio = precio;
		this.tipo = "normal" ;
		// TODO Auto-generated constructor stub
	}
	
public double Cobrar(int kilometros) {
		if (kilometros < 2.5) 
			precio = 5;
		if (kilometros >2.5 || kilometros < 30) 
			precio = 4;
		if (kilometros > 30)
			precio = kilometros*0.25;
		Cli.borrar();
		return precio;
	}


public String getTipo() {
	return tipo;
}

public int getNum() {
	return num;
}

public boolean isEstado() {
	return estado;
}

public void entrarCola(String matricula) {
	Cli.añadir(matricula);
	contVehiculos++;
}

public void mostrarCliente(int numero) {
	Cli.mostrar(numero);
}

public void EliminarCliente() {
	Cli.borrar();
}

public int getContVehiculos() {
	return contVehiculos;
}

public void abrir() {
	this.estado = true;
	Hapertura = LocalTime.now();
}

public void cerrar() {
	this.estado = false;
	Hcerrar = LocalTime.now();
}
}
