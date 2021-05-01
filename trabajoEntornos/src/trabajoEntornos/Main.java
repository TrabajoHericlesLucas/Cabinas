package trabajoEntornos;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String matricula;
		char tipo;
		int numCabina, contCabina = 0, opc, contCabinaA = 0, pos,numero,contCabinaT = 0 ,cabina = 1;
		boolean abierta;
		Cabina[] cabinas = new Cabina[3];
		
		do {
			for (int i = 0;i<cabinas.length;i++) {
				numero = (int)(Math.random()*2+1);
				if (numero == 1 && contCabina < 3) {
					cabinas[contCabinaT] = new normal(cabina);
					contCabina++;
					contCabinaT++;
					cabina++;
				}else {
					cabinas[contCabinaT] = new abonada(cabina);
					contCabinaA++;
					contCabinaT++;
					cabina++;
				}
				if (numero == 2 && contCabinaA <3) {
					cabinas[contCabinaT] = new abonada(cabina);
					contCabinaA++;
					contCabinaT++;
					cabina++;
				}else {
					cabinas[contCabinaT] = new normal(cabina);
					contCabina++;
					contCabinaT++;
					cabina++;
				}
			}
		}while(cabina<5);

		do {
			System.out.println(
					"Elige opcion 1/Abrir cabina.2/Ponerse a la cola.3/Cobrar en cabina.4/Mostrar informacion.5/Cerrar cabina.");
			opc = sc.nextInt();
			switch (opc) {
			case 1:
				System.out.println("dime el numero de la cabina que abrir");
				numCabina = sc.nextInt();
				if (numCabina < 1 || numCabina > 4) {
					System.out.println("La cabina no existe");
					break;
				}
				break;
			case 2:
				System.out.println("dime la matricula del vehiculo");
				matricula = sc.nextLine();
				System.out.println("dime el tipo de cliente");
				tipo = sc.nextLine().charAt(0);
				try {
					comprobarTipo(tipo);
				} catch (tipoClienteIncorrecto e) {
					pos = asignarVehiculo(cabinas, tipo);
					cabinas[pos].entrarCola();
				}
				break;
			case 3:
				System.out.println("Dime la cabina en la que vamos a cobrar");
				numCabina = sc.nextInt();
				if (buscaCabina(numCabina, cabinas) == true) {

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
				break;
			case 6:
				break;
			}

		} while (opc != 7);

	}

	public static boolean comprobarTipo(char tipo) throws tipoClienteIncorrecto {
		if (tipo == 'n' || tipo == 'N' || tipo == 'a' || tipo == 'A')
			return true;
		else
			throw new tipoClienteIncorrecto("tipo de cliente incorrecto");
	}

	public static boolean buscaCabina(int numero, Cabina cabinas[]) {
		for (int i = 0; i < cabinas.length; i++) {
			if (cabinas[i].getnumCabina() == numero)
				if (cabinas[i].getEstado() == true)
					return true;
				else
					return false;
			else
				return false;
		}
		return false;

	}

	public static int asignarVehiculo(Cabina cabinas[], char tipo) {
		for (int i = 0; i < cabinas.length; i++) {
			if (cabinas[i].getTipo().equalsIgnoreCase(tipo)) {
				int pos;
				int menor;
				if (cabinas[i].contVehiculos() == 0) {
					pos = i;
					return pos;
				} else {
					if (cabinas[i].contVehiculos() < menor) {
						pos = i;
						menor = cabinas[i].contVehiculos();
						return pos;
					}
				}
			}
			return -1;
		}

	}
}
