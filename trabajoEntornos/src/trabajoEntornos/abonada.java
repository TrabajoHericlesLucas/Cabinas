package trabajoEntornos;

import java.util.Vector;
import java.time.*;

public class abonada extends Cabina {
	private int numero, contVehiculos;
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
		Cli.borrar();
		return precio;
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
