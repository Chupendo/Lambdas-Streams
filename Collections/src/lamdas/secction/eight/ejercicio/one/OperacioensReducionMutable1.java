package lamdas.secction.eight.ejercicio.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class OperacioensReducionMutable1 {

	// Apartir de una matriz de String obtener una List<String> mediante collect()
	public static void main(String[] args) {
		List<Empleado> lEmpleados = Empleado.empleados();
		System.out.println("Lista de empleados: ");
		lEmpleados.forEach(System.out::println);
		// Obtner los nombres de empleados
		List<String> lNombres = lEmpleados
				.stream()
				.map(Empleado::getNombre)
				.collect(ArrayList::new, ArrayList::add,ArrayList::addAll);

		System.out.println("Lista de nombres: ");
		lNombres.forEach(System.out::println);

		// Obtener una coleccion de edad
		Set<Integer> sEdad = lEmpleados.stream()
				.mapToInt(Empleado::getEdad)
				.collect(HashSet::new, HashSet::add, HashSet::addAll);

		System.out.println("Coleccion de dad: ");
		sEdad.forEach(System.out::println);
	}

}
