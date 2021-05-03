package trabajoEntornos;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Vector;

public abstract class Cabina {
	private int num,contVehiculos;
	protected Cliente Cli;
	private boolean estado;
	private String tipo;
	private LocalTime Hapertura,Hcerrar;
	private long abierto;
	public Cabina(int num) {
		super();
		this.num = num;
		this.estado = false;
		Cli = new Cliente();
		this.contVehiculos = 0;
		this.abierto = abierto;
	}
	public double Cobrar(int kilometros) {
		return 0;
		
	}
	public int getNum() {
		return num;
	}
	
	public boolean isEstado() {
		return estado;
	}
	public String getTipo() {
		return tipo;
	}
	
	public void entrarCola(String matricula) {
		 Cli.añadir(matricula);
		 contVehiculos++;
	}
	public void mostrarCliente(int numero) {
		Cli.mostrar(numero);
	}
	public void EliminarCliente(){
		Cli.borrar();
	}
	public int getContVehiculos() {
		return contVehiculos;
	}
	public void abrir() {
		this.estado= true;
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
