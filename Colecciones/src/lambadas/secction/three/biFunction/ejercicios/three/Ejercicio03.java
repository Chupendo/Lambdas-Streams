package lambadas.secction.three.biFunction.ejercicios.three;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Ejercicio03 {

	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();
		List<Empleado> lEmpl = Arrays.asList(
				new Empleado("Andres",25200.5),
				new Empleado("Juan",28985.0),
				new Empleado("Pedro",18225.2),
				new Empleado("Ramon",15898.7));
				

		//Suma
		List<Double> cincoPorCiento = calculadora.cal((salario, incremento)-> salario+(salario*incremento/100), lEmpl,5.0);
		System.out.println("El resultado es: "+cincoPorCiento);
		
		//Resta
		List<Double> menosCincoPorCiento = calculadora.cal((salario, incremento)-> salario-(salario*incremento/100), lEmpl,5.0);
		System.out.println("El resultado es: "+menosCincoPorCiento);
	}	
}
