package trabajoEntornos;

import java.util.*;
import java.time.*;
import static java.nio.file.StandardOpenOption.APPEND;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String resultado[];
		Path file = Paths.get("entrada.txt");
		Path file2 = Paths.get("log.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;
		String matricula, tipo, linea;
		int numCabina, contCabina = 0, opc, contCabinaA = 0, pos, numero, contCabinaT = 0, cabina = 1, kilometros;
		double precio;
		boolean abierta;
		Cabina[] cabinas = new Cabina[4];

		do {
			for (int i = 0; i < 4; i++) {
				numero = (int) (Math.random() * 2 + 1);
				if (numero == 1) {
					if (contCabina < 3) {
						cabinas[contCabinaT] = new normal(cabina);
						contCabina++;
						contCabinaT++;
						cabina++;
					} else {
						cabinas[contCabinaT] = new abonada(cabina);
						contCabinaA++;
						contCabinaT++;
						cabina++;
					}
				}
				if (numero == 2) {
					if (contCabinaA < 3) {
						cabinas[contCabinaT] = new abonada(cabina);
						contCabinaA++;
						contCabinaT++;
						cabina++;
					} else {
						cabinas[contCabinaT] = new normal(cabina);
						contCabina++;
						contCabinaT++;
						cabina++;
					}
				}
			}
		} while (contCabinaT < 4);

		do {
			System.out.println(
					"Elige opcion 1/Abrir cabina.2/Ponerse a la cola.3/Cobrar en cabina.4/Mostrar informacion.5/Cerrar cabina.6/Leer archivo de vehiculos");
			opc = sc.nextInt();
			switch (opc) {
			case 1:
				System.out.println("dime el numero de la cabina que abrir");
				numCabina = sc.nextInt();
				if (numCabina < 1 || numCabina > 4) {
					System.out.println("La cabina no existe");
				} else {
					pos = buscarCabina(numCabina, cabinas);
					cabinas[pos].abrir();
				}
				break;
			case 2:
				sc.nextLine();
				System.out.println("dime la matricula del vehiculo");
				matricula = sc.nextLine();
				System.out.println("dime el tipo de cliente");
				tipo = sc.nextLine();
				try {
					comprobarTipo(tipo);
				} catch (tipoClienteIncorrecto e) {
					System.out.println("tipo de cliente incorrecto");
					linea = "error de tipo cliente";
					try {
						BufferedWriter writer = Files.newBufferedWriter(file, charset, APPEND);
						writer.write(linea);
						writer.newLine();
					} catch (IOException x) {
						System.err.format("IOException: %s%n", x);
					}

				}
				pos = asignarVehiculo(cabinas, tipo);
				cabinas[pos].entrarCola(matricula);
				break;
			case 3:
				System.out.println("Dime la cabina en la que vamos a cobrar");
				numCabina = sc.nextInt();
				if (comprobarCabina(numCabina, cabinas) == true) {
					pos = buscarCabina(numCabina, cabinas);
					cabinas[pos].mostrarCliente(0);
					System.out.println("dime cuantos kilometros ha recorrido");
					kilometros = sc.nextInt();
					precio = cabinas[pos].Cobrar(kilometros);
					System.out.println("el precio ha sido de: " + precio + "€");
					cabinas[pos].EliminarCliente();
				} else
					System.out.println("La cabina no esta abierta");
				break;
			case 4:
				for (int i = 0; i < cabinas.length; i++)
					System.out.println(cabinas[i].toString());
				break;
			case 5:
				System.out.println("dime el numero de la cabina a cerrar");
				numCabina = sc.nextInt();
				pos = buscarCabina(numCabina, cabinas);
				cabinas[pos].cerrar();
				break;
			case 6:
				try {
					reader = Files.newBufferedReader(file, charset);
					String line = null;
					while ((line = reader.readLine()) != null) {
						System.out.println(line);
						resultado = line.split(",");
						pos = asignarVehiculo(cabinas, resultado[1]);
						cabinas[pos].entrarCola(resultado[0]);
					}
				} catch (IOException x) {
					System.err.format("IOException: %s%n", x);
					break;
				}
			}
		} while (opc != 7);

	}

	public static boolean comprobarTipo(String tipo) throws tipoClienteIncorrecto {
		if (tipo.equalsIgnoreCase("normal") || tipo.equalsIgnoreCase("abonada"))
			return true;
		else
			throw new tipoClienteIncorrecto("tipo de cliente incorrecto");
	}

	public static boolean comprobarCabina(int numero, Cabina cabinas[]) {
		for (int i = 0; i < cabinas.length; i++) {
			if (cabinas[i].getNum() == numero)
				if (cabinas[i].isEstado() == true)
					return true;
				else
					return false;
			else
				return false;
		}
		return false;

	}

	public static int asignarVehiculo(Cabina cabinas[], String tipo) {
		for (int i = 0; i < cabinas.length; i++) {
			if (cabinas[i].getTipo().equalsIgnoreCase(tipo)) {
				int pos;
				int menor = 100;
				if (cabinas[i].getContVehiculos() == 0) {
					pos = i;
					return pos;
				} else {
					if (cabinas[i].getContVehiculos() < menor) {
						pos = i;
						menor = cabinas[i].getContVehiculos();
						return pos;
					}
				}
			}
		}
		return -1;

	}

	public static int buscarCabina(int numero, Cabina cabinas[]) {
		for (int i = 0; i < cabinas.length; i++) {
			if (cabinas[i].getNum() == numero)
				return i;
		}
		return -1;
	}

}
