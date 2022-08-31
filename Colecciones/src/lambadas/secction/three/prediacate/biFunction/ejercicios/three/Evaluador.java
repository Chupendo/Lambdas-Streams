package lambadas.secction.three.prediacate.biFunction.ejercicios.three;

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
	
	public List<Empleado> evaluadornNot(List<Empleado> lEmpleado,
			Predicate<Empleado> eval){
		List<Empleado> listaNueva = new ArrayList<Empleado>();
		for(Empleado empleado: lEmpleado) {
			if(eval.negate().test(empleado)) {
				listaNueva.add(empleado);
			}
		}
		return listaNueva;
	}
	
	public List<Empleado> evaluadornAnd(List<Empleado> lEmpleado,
			Predicate<Empleado> eval){
		List<Empleado> listaNueva = new ArrayList<Empleado>();
		Predicate<Empleado> funcAnd = empleado->empleado.getNombre().startsWith("A");
				
		for(Empleado empleado: lEmpleado) {
			if(eval.and(funcAnd).test(empleado)) {
				listaNueva.add(empleado);
			}
		}
		return listaNueva;
	}
}
