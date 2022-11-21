package lamdas.secction.six.ejercicio.one;

import java.util.Random;
import java.util.stream.Stream;


public class CreaStream1 {

	public static void main(String[] args) {
		Stream<String> stream1 = Stream.iterate("", (x)->x+String.valueOf(Math.random()))
				.limit(5);
		System.out.print("Stream created with 'static <T> Stream<T> itearte(T seed, UnaryOperator<T> f)':\n");
		stream1.forEach(System.out::println);
		
		Stream<String> stream2 = Stream.generate(() -> {
			Random rand = new Random();
			return String.valueOf(rand.nextInt(25,75));
		}).limit(5);
		
		System.out.print("Stream created with 'static <T> Stream<T> generate(Supplier<T> s)':\n");
		stream2.forEach(System.out::println);
		
		System.out.print("Stream created with methods defined in the API, example Random().ints()':\n");
		new Random().ints()
			.limit(5)
			.forEach(System.out::println);
	}

}
