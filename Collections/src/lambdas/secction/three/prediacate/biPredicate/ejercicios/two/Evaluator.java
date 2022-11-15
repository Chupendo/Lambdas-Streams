package lambdas.secction.three.prediacate.biPredicate.ejercicios.two;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import lambdas.secction.three.prediacate.biFunction.ejercicios.two.Empleado;

public class Evaluator {
	public List<Empleado> evaluar(List<Empleado>listaEmp,BiPredicate<Integer, String> eval){
		List<Empleado> listaNueva = new ArrayList<Empleado>();
		
		listaEmp.forEach(empleado->{
			if(eval.test(empleado.getEdad(), empleado.getDepartamento())) {
				listaNueva.add(empleado);
			}
		});
		return listaNueva;
	}
}
