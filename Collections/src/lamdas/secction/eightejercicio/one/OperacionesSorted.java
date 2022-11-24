package lamdas.secction.eightejercicio.one;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class OperacionesSorted {

	public static void main(String[] args) {
		List<Empleado> lEmpleados = Empleado.empleados();
		
		// Ordena los nombres en orden natural
		System.out.println("Nombres ordenados: ");
		String str = Arrays.asList("Alfredo","Maria","Daniel","Brenada")
			.stream()
			.sorted()
			.reduce((a,b)->a+", "+b).orElse("");
			//.forEach(System.out::print);
		System.out.println(str);
		
		System.out.println("Numeros ordenados: ");
		Arrays.asList(1,2,7,8,1,5,2,1,6,3)
			.stream()
			.sorted()
			.forEach(n -> System.out.print(n+", "));
		System.out.println();
		
		System.out.println("Empleados ordenado por ingreso: ");
		lEmpleados.stream().sorted()
			.forEach(System.out::println);
		
		
		System.out.println("Empelados nombre inverso: ");
		lEmpleados
			.stream()
			.sorted((a,b)->b.getNombre().compareTo(a.getNombre()))
			.forEach(System.out::println);
	}

}
