package lambadas.secction.five.operations;

import java.util.Arrays;
import java.util.List;

public class OperAverage {

	public static void main(String[] args) {
		// Suma de los numeros al curado de los numeros pares
		List<Integer> lNumeros = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 4);

		System.out.print("Lista Input: {");
		lNumeros.forEach(num -> {
			System.out.print(" " + num);
		});
		System.out.println(" }");
		
		System.out.println("Funcion final average");
		Double result = lNumeros.stream().mapToDouble(elem->elem).average().getAsDouble();
		System.out.println("promedio: "+result);
	}

}
