package lamdas.secction.eight.ejercicio.one;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class OperacioensReducionMutable3 {
	
	// Apartir de una matriz de String obtener una List<String> mediante collect()
	public static void main(String[] args) {
		Stream<String> stream1 = Arrays.stream(new String[]{"Marco","Pedro","Juan","Ramona","Ruth"});
		
		//Firma de collect:
		//<R> R collect(Supplier<R> supplier, Biconsumer<R,? super T> accumulator, Biconsumer<R,R> combiner)
		//<R,A> R collect(Collector<? super T,A,R> collector)
		
		List<String> lNombres = stream1.collect(Collectors.toList());
		System.out.println("Lista de nombres: ");
		lNombres.forEach(System.out::println);
	}

}
