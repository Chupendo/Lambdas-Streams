package lambadas.secction.three.comparator.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio2 {

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

		Collections.sort(lpersonas);

		// Muestra el valor de la lista tras ser ordenada
		System.out.println("Lista de vocales ordando por id: { ");
		lpersonas.forEach((p) -> System.out.println(p));
		System.out.println("} ");

	}
}
