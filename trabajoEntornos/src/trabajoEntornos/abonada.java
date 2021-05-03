package trabajoEntornos;

import java.util.Vector;
import java.time.*;

public class abonada extends Cabina {
	private int numero,contVehiculos;
	private double precio;
	private String tipo;
	private Vector vehiculo;
	
	public abonada(int numero) {
		super(numero);
		this.precio = precio;
		this.tipo = "abonada";
		// TODO Auto-generated constructor stub
	}
	public String getTipo() {
		return tipo;
	}
	public double Cobrar(int kilometros) {
		if (kilometros < 30) 
			precio = 2;
		else
			precio = 5;
		return precio;
	}
	

}
