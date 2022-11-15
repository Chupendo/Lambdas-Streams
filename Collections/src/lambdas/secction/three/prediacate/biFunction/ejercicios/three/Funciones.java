package lambdas.secction.three.prediacate.biFunction.ejercicios.three;

import java.util.function.BiFunction;

public class Funciones {

	public Double incrementoSalario(Empleado empl, Double incremento,BiFunction<Double, Double, Double> bi ) {
		return bi.apply(empl.getSalario(), incremento);
	}
}
