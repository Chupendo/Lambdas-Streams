package lambdas.secction.three.prediacate.biFunction.ejercicios.one;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Evaluador {
	public List<Empleado> evaluador(List<Empleado> lEmpleado,
			Predicate<Empleado> eval){
		List<Empleado> listaNueva = new ArrayList<Empleado>();
		for(Empleado empleado: lEmpleado) {
			if(eval.test(empleado)) {
				listaNueva.add(empleado);
			}
		}
		return listaNueva;
	}
}
