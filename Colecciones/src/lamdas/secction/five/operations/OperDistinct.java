package lambdas.secction.five.operations;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * La operación intermedia "Distict" devuel aquellos elementos que son diferentes
 *
 * 
 * 
 * @author andres.rpenuela
 *
 */
public class OperDistinct {

	public static void main(String[] args) {
		// Suma de los numeros al curado de los numeros pares
		List<Integer> lNumeros = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 4);

		System.out.print("Lista Input: {");
		lNumeros.forEach(num -> {
			System.out.print(" " + num);
		});
		System.out.println(" }");

		//
		System.out.println("Operacion intermecia Distinct");
		List<Integer> result = lNumeros.stream().distinct().toList();
		System.out.print("Lista Reuslt: {");
		result.forEach(num -> {
			System.out.print(" " + num);
		});
		System.out.println(" }");
	}
}
