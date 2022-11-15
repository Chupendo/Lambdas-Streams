package lambdas.secction.three.consumer.ejercicios.three;

import java.util.List;
import java.util.function.Consumer;

public class OperacionesEstudiantes {
	public void aceptarTodos(Consumer<Estudiante> cons, List<Estudiante> estudiantes){
		for(Estudiante estudiante:estudiantes) {
			cons.accept(estudiante);
		}
	}
}
