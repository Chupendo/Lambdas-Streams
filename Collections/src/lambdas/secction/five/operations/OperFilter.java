package lambdas.secction.five.operations;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * La operación intermedia "Filter" recibe como argumento un Predicate<T>, cuyo
 * metodo funcional es "boolean test(T t);", devuelve el elmenot que satisfa la
 * función "test(T t)."
 *
 * 
 * 
 * @author andres.rpenuela
 *
 */
public class OperFilter {

	public static void main(String[] args) {
		// Suma de los numeros al curado de los numeros pares
		List<Integer> lNumeros = Arrays.asList(1, 2, 3, 4, 5);

		System.out.print("Lista Input: {");
		lNumeros.forEach(num -> {
			System.out.print(" " + num);
		});
		System.out.println(" }");

		// Preicado (condicion a cumplir)
		Predicate<Integer> f1 = (elem) -> elem > 2;
		Predicate<Integer> f2 = (elem) -> elem < 4;
		// Operacion intermedia Filter.
		List<Integer> result = lNumeros.stream().filter(f1).toList();

		System.err.println("-----\n Filter 1Predicate<Integer> f1 = (elem) -> elem > 2;\n-----");
		System.out.print("Lista Result: {");
		result.forEach(num -> {
			System.out.print(" " + num);
		});
		System.out.println(" }");

		// Operacion intermedia Filter.
		result = lNumeros.stream().filter(f1.and(f2))
				.toList();
		
		System.err.println("-----\n Filter 1 & 2\n-----");
		System.out.print("Lista Result: {");
		result.forEach(num -> {
			System.out.print(" " + num);
		});
		System.out.println(" }");

	}

}
