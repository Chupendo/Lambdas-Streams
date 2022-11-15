package lambadas.secction.five.ejercicio;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1,2,3,4,5);
		
		//Obtener un stream
		Stream<Integer> stream1 = numeros.stream();
		
		// Obtener el par más alto
		Integer max =  stream1
				.filter(num -> num % 2 == 0)
				.reduce(0, Integer::max);
		
		System.out.println("Numero par de la lista mas alto: "+max);
		
		// Obtener la media
		Double avg2;
		int cont=1,sum=0;
		avg2 = stream1
				.map(Double::new)
				.reduce(0.0, null);
		System.out.println(avg2);
		
	}

}
