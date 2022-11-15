package lambdas.secction.three.function.ejercicios.two;

import java.util.function.Function;

public class Ejercicio02 {

	public static void main(String[] args) {
		DatosComensal dComensal = new DatosComensal();
		Comensal com = new Comensal("Andres", "Ruiz",29);
		String nombreComensal = (String) dComensal.getDatoComensal(com, x->com.getName());
		Integer edadComensar = (Integer) dComensal.getDatoComensal(com, x->com.getEdad());
		System.out.println("Nombre comnesal: "+nombreComensal+" Edad: "+edadComensar);
	}	
}
