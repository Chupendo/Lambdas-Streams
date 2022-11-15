package lambdas.secction.three.biFunction.ejercicios.two;

import java.util.function.BiFunction;

public class Calculadora {
	public String cal(BiFunction<Integer, Integer, String> biF, Integer i1, Integer i2) {
		return biF.apply(i1, i2);
	}
}
