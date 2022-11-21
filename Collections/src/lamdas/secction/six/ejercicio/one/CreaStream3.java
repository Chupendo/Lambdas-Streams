package lamdas.secction.six.ejercicio.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lamdas.secction.six.ejercicio.pojos.Estudiante;

public class CreaStream3 {

	public static void main(String[] args) {
		IntStream numStream = Arrays.stream(new int[] {1,2,3,4,5});
		System.out.println("numStream: ");
		numStream.forEach(System.out::println);
		
		Set<String> lenguajesSet = new HashSet<String>();
		
		lenguajesSet.add("Java");
		lenguajesSet.add("C++");
		lenguajesSet.add("C#");
		
		Stream<String> lenagujesStream = lenguajesSet.stream();
		System.out.println("lenagujesStream: ");
		lenagujesStream.forEach(System.out::println);
		
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		estudiantes.add(new Estudiante("Juan", 22, 25,25));
		estudiantes.add(new Estudiante("Juan", 18, 25,12));
		estudiantes.add(new Estudiante("Juan", 8, 8,8));
		estudiantes.add(new Estudiante("Juan", 26, 8,182));

		Stream<Estudiante> estudiantesStream = estudiantes.parallelStream();
		System.out.println("estudiantesStream (parallelStream): ");
		estudiantesStream.forEach(System.out::println);
		
	}

}
