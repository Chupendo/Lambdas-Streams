package lamdas.secction.six.ejercicio.one;

import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lamdas.secction.six.ejercicio.pojos.Estudiante;

public class CreaStream1 {

	public static void main(String[] args) {
		Stream<String> stream1 = Stream.of("Hola ejemplo de creacion de un stream de string");
		System.out.println("stream 1");
		stream1.forEach(System.out::println);
		
		Stream<Object> stream2 = Stream.of("curso1","curso2",15,2.3); //data cannot be null
		System.out.println("stream 2:");
		stream2.forEach(System.out::println);
		
		Object[] data = {"Andres",2,3.2,null};
		
		Stream<Object> stream3 = Stream.of(data); //data cannot be null
		System.out.println("stream 3:");
		stream3.forEach(System.out::println);
		
		Object[] data2 = {"curso1","curso2",null};
		Object[] data3 = null;
		Stream<Object[]> stream41 = Stream.ofNullable(data2); //data can be null
		Stream<Object[]> stream42= Stream.ofNullable(data3); //data can be null
		System.out.println("stream 4_1:");
		stream41.forEach(ob->{
			Stream.of(ob).forEach(System.out::println);
		});
		System.out.println("stream 4_2:");
		stream42.forEach(System.out::println);
		
		Stream<Estudiante> streamEstudiantes = Stream.<Estudiante>builder()
				.add(new Estudiante("n01",17, 1.70, 9.5))
				.add(new Estudiante("n03",17, 1.70, 9.5))
				.build();
		
		System.out.println("streamEstudiantes:");
		streamEstudiantes.forEach(System.out::println);
		
		Random random = new Random();
		IntStream streamInt = random.ints().limit(5);
		System.out.println("streamInt:");
		streamInt.forEach(System.out::println);
		
		IntStream streamInt2 = IntStream.rangeClosed(1, 5);
		System.out.println("streamInt2:");
		streamInt2.forEach(System.out::println);
	}

}
