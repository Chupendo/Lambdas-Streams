package lambdas.secction.three.biFunction.ejercicios.two;

import java.util.function.BiFunction;

public class Ejercicio02 {

	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();

		//Suma
		String suma = calculadora.cal((x, y)-> Integer.toString(x+y), 60,10);
		System.out.println("El resultado es: "+suma);
		
		//Resta
		String resta = calculadora.cal((x, y)-> Integer.toString(x-y), 60,10);
		System.out.println("El resultado es: "+resta);
	}	
}
