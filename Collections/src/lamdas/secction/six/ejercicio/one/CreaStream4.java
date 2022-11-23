package lamdas.secction.six.ejercicio.one;

import java.util.stream.IntStream;


public class CreaStream4 {

	public static void main(String[] args) {
		System.out.println("String: Hola 123.");
		IntStream stream1 = "Hola Mundo 123.".chars();
		System.out.println("CharSequence.chars()");
		stream1.forEach(System.out::println);
		
		IntStream stream2 = "Hola 123.".codePoints();
		System.out.println("CharSequence.codePoints()");
		stream2.forEach(System.out::println);
		
		IntStream stream3 = "Hola 123.".codePoints();
		System.out.println("Eliminar numeros y espacios en blanco");
		stream3.filter(n->!Character.isDigit(n) && !Character.isWhitespace(n))
			.forEach(n->System.out.print((char)n));
		
	}

}
