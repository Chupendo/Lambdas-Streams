package lambadas.secction.five.operations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * La operación intermedia "sorted" produce un strem con los elmentos ordenados
 *
 * @author andres.rpenuela
 *
 */
public class OperSorted {

	public static void main(String[] args) {
		// Suma de los numeros al curado de los numeros pares
		List<Integer> lNumeros = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 4);

		System.out.print("Lista Input: {");
		lNumeros.forEach(num -> {
			System.out.print(" " + num);
		});
		System.out.println(" }");

		//
		System.out.println("Operacion intermecia comparador natural <");
		List<Integer> result = lNumeros.stream().sorted().toList();
		System.out.print("List Reuslt: {");
		result.forEach(elem->System.out.print(" "+elem));
		System.out.println(" }");
		
		System.out.println("Operacion intermecia comparador natural >");
		Comparator<Integer> comp1 = (o1, o2) -> o2.compareTo(o1);
		result = lNumeros.stream().sorted(comp1).toList();
		System.out.print("List Reuslt: {");
		result.forEach(elem->System.out.print(" "+elem));
		System.out.println(" }");
	}
}
