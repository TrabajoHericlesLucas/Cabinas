package trabajoEntornos;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String matricula,tipo;
		int numCabina,contCabina = 0,opc,contCabinaA = 0;
		Cabina[] cabinas = new Cabina[4];
		
		do{
			System.out.println("Elige opcion 1/Abrir cabina.2/Ponerse a la cola.3/Cobrar en cabina.4/Mostrar informacion.5/Cerrar cabina.");
			opc= sc.nextInt();
			switch(opc){
			case 1:
				System.out.println("dime el numero de la cabina que abrir");
				numCabina = sc.nextInt();
				if (numCabina < 1 || numCabina > 4){
					System.out.println("La cabina no existe");
					break;
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}
			
		}while(opc!=6);		
		
	}

}
