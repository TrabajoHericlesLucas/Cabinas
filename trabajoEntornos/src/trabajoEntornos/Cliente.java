package trabajoEntornos;

import java.util.Vector;

public class Cliente extends Vector {

	private String matricula;
	
	private char tipo;
	
	public Cliente(String matricula, char tipo) {
		super();
		this.matricula = matricula;
		this.tipo = tipo;
	}
	
}
