package lambdas.secction.five.operations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * La operación intermedia "Map" produce un estrem en el que cada elemento es procesado por una función
 *
 * @author andres.rpenuela
 *
 */
public class OperMap {

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
		Function<Integer, Integer> fun1 = (elem)->elem*elem;
		List<Integer> result = lNumeros.stream().map(fun1).toList();
		System.out.print("List Reuslt: {");
		result.forEach(elem->System.out.print(" "+elem));
		System.out.println(" }");
	}
}
