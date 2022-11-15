package lambdas.secction.three.comparator.one;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ejercicio1 {

	public static void main(String[] args) {
		// Declara e instancia una lista de string
		List<String> vocales = Arrays.asList("a", "o","u","i","e");
		
		// Muestra el valor de la lista inicial
		System.out.print("Lista de vocales inical: { ");
		vocales.forEach((v)->System.out.print(v+" "));
		System.out.println("} ");
		
		// Ordeanmos mediante el metodo sort de Colletions
		// String implementa la interfaz Comparable
		Collections.sort(vocales); // usa compareTo de String
		
		// Muestra el resultado de ordenar la lista
		System.out.print("Lista de vocales ordenada: {");
		vocales.forEach((v)->System.out.print(v+" "));
		System.out.println("} ");
	}
}
