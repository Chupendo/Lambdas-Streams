package lambdas.secction.three.biFunction.ejercicios.one;

import java.util.function.BiFunction;

public class Ejercicio01 {

	public static void main(String[] args) {
		BiFunction<String, String, String> bi = (x,y)-> x+ y; //Concatenación de x e y
		System.out.println(bi.apply("Hola", " Mundo!"));
	}	
}
