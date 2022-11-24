package lamdas.secction.eight.ejercicio.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperacioensReducionMutable4 {

	// Apartir de una matriz de String obtener una List<String> mediante collect()
	public static void main(String[] args) {
		List<Empleado> lEmpleados = Empleado.empleados();
		System.out.println("Lista de empleados: ");
		lEmpleados.forEach(System.out::println);
		// Obtner los nombres de empleados
		List<String> lNombres = lEmpleados
				.stream()
				.map(Empleado::getNombre)
				.collect(Collectors.toList());

		System.out.println("Lista de nombres: ");
		lNombres.forEach(System.out::println);

		// Obtener una coleccion de edad
		Set<Integer> sEdad = lEmpleados
				.stream()
				.map(Empleado::getEdad)
				.collect(Collectors.toSet());

		System.out.println("Coleccion de dad: ");
		sEdad.forEach(System.out::println);
		
		// Obtener una coleccion de ingresos ordenado
		Set<Double> sIngresos = lEmpleados
				.stream()
				.map(Empleado::getIngresos)
				.collect(Collectors.toCollection(TreeSet::new));

		System.out.println("Coleccion de Ingresos: ");
		sIngresos.forEach(System.out::println);		
	}
}
