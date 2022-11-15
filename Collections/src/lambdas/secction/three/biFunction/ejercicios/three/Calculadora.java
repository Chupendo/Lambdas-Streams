package lambdas.secction.three.biFunction.ejercicios.three;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Calculadora {
	public List<Double> cal(BiFunction<Double, Double, Double> bi,List<Empleado> listaEmp, Double incremento) {
		List<Double> lSalarios = new ArrayList<Double>();
		for (Empleado empleado : listaEmp) {
			lSalarios.add(bi.apply(empleado.getSalario(),incremento));
		}
		return lSalarios;
	}
}
