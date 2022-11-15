package lambadas.secction.five.operations;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * La operación intermedia "Limit" devuelve X elementos (numero limitado) de la colecicón
 *
 * @author andres.rpenuela
 *
 */
public class OperLimit {

	public static void main(String[] args) {
		// Suma de los numeros al curado de los numeros pares
		List<Integer> lNumeros = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 4);

		System.out.print("Lista Input: {");
		lNumeros.forEach(num -> {
			System.out.print(" " + num);
		});
		System.out.println(" }");

		//
		System.out.println("Operacion intermecia Limit");
		List<Integer> result = lNumeros.stream().limit(3).toList();
		System.out.print("Lista Reuslt: {");
		result.forEach(num -> {
			System.out.print(" " + num);
		});
		System.out.println(" }");
	}
}
