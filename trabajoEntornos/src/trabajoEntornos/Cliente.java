package trabajoEntornos;

import java.util.Vector;

public class Cliente extends Vector {
	

	public Cliente() {
		super();
		
	}
	
	public void añadir(Object o) {
		//super.add(0,o);
		super.add(o);
		
	}
	
	public void mostrar(int numero) {
		super.get(numero);
	}
	public Object borrar() {
		if (super.size()==0)
			return null;
		return super.remove(super.size()-1);
	}
}
