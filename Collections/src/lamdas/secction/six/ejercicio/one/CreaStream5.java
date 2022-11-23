package lamdas.secction.six.ejercicio.one;

import java.util.regex.Pattern;
import java.util.stream.IntStream;


public class CreaStream5 {

	public static void main(String[] args) {
		String str = "Java, C#, C++, HTML, JavaScript";
		
		Pattern.compile(", ") //Divide ", " = expresion regular  
				.splitAsStream(str) // Genra un Stream<String> 
									//donde divide la cadena en
									// base la expreison regular de "compile"
				.forEach(System.out::println); 
	}
}
