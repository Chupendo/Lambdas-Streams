package lambdas.secction.five.operations;

import java.util.Arrays;
import java.util.List;

public class OperReduce {

	public static void main(String[] args) {
		// Suma de los numeros al curado de los numeros pares
		List<Integer> lNumeros = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 4);

		System.out.print("Lista Input: {");
		lNumeros.forEach(num -> {
			System.out.print(" " + num);
		});
		System.out.println(" }");
		
		System.out.println("Funcion final average");
		Integer result = lNumeros.stream().mapToInt(elem->elem).reduce((a,b)->a+b).getAsInt();
		System.out.println("Reduce: "+result);
	}

}
