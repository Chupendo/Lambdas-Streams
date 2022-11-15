package lambadas.secction.three.comparator.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ejercicio3 {

	public static void main(String[] args) {
		// Declara e instancia una lista de persona
		List<Persona> lpersonas = new ArrayList<Persona>();

		lpersonas.add(new Persona(1, "Andres"));
		lpersonas.add(new Persona(4, "Baltasar"));
		lpersonas.add(new Persona(3, "Carlos"));
		lpersonas.add(new Persona(2, "Ana"));

		// Muestra el valor de la lista inicial
		System.out.println("Lista de vocales inical: { ");
		lpersonas.forEach((p) -> System.out.println(p));
		System.out.println("} ");

		OrdenarPersonaByNombre ordenarPorNombre = new OrdenarPersonaByNombre();
		Collections.sort(lpersonas, (o1,o2)-> o1.getNombre().compareTo(o2.getNombre()));
		//Collections.sort(lpersonas, ordenarPorNombre);
		/**
		 * Collections.sort(lpersonas,new Comparator<Persona>() {
		 * 
		 * @Override public int compare(Persona o1, Persona o2) { 
		 * 		if(o1 instanceof
		 *           Persona && o2 instanceof Persona) { 
		 *           	return o1.getNombre().compareTo(o2.getNombre()); 
		 *           }
		 *           return 0; 
		 *      }
		 * });
		 * 
		 */

		// Muestra el valor de la lista tras ser ordenada
		System.out.println("Lista de vocales ordenado por nombre: { ");
		lpersonas.forEach((p) -> System.out.println(p));
		System.out.println("} ");
	}

}
