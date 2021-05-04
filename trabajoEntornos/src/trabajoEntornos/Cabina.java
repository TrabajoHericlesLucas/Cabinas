package trabajoEntornos;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Vector;

public abstract class Cabina {
	protected int num, contVehiculos;
	protected Cliente Cli;
	protected boolean estado;
	protected String tipo;
	protected LocalTime Hapertura, Hcerrar;
	protected long abierto;

	public Cabina(int num) {
		super();
		this.num = num;
		this.estado = false;
		Cli = new Cliente();
		this.contVehiculos = 0;
		this.abierto = ChronoUnit.MINUTES.between(Hcerrar, Hapertura);
	}

	public double Cobrar(int kilometros) {
		return 0;

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

	public String toString() {
		return "Cabina [num=" + num + ", contVehiculos=" + contVehiculos + ", Cli=" + Cli + ", estado=" + estado
				+ ", tipo=" + tipo + ", abierto=" + abierto + "]";
	}

}
