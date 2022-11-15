package lambadas.secction.three.function.ejercicios.one;

import java.util.function.Function;

public class Ejercicio01 {

	public static void main(String[] args) {
		Function<Integer, String> convertidor = date -> Integer.toString(date);
		Function<Integer, String> convertidor2 = new Function<Integer, String>() {
			@Override
			public String apply(Integer t) {
				return Integer.toString(t);
			};
		};
		
		System.out.println("Number: "+convertidor.apply(4)+" length= "+convertidor.apply(4).length());
		System.out.println("Number: "+convertidor.apply(40)+" length= "+convertidor.apply(40).length());
	}	
}
