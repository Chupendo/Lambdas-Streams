package lambdas.secction.five.iteraccion;

import java.util.Arrays;
import java.util.List;

public class IteracionInterna {

	public static void main(String[] args) {
		// Suma de los numeros al curado de los numeros pares
		List<Integer> lNumeros = Arrays.asList(1, 2, 3, 4, 5);

		System.out.println("Suma de los numeros al curado de los numeros pares.");
		System.out.print("Lista: {");
		lNumeros.forEach(num -> {
			System.out.print(" " + num);
		});
		System.out.println(" }");
		
		int suma = lNumeros.stream()
					.filter(numero->numero % 2 == 1) // Devuelve los elemntos que cumpla la condicion
					.map(numero-> numero * numero)	 // Devuleve un Integer del resultado de Function<T> 
					.reduce(0, Integer::sum);		 // Reliza la concaquetcio de param1 con el reustlado de la ByFunction

		System.out.println("Resultado: "+suma);
	}
}
