import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import dto.OcupacionBabelDto;


public class ListExamples {
	private static List<OcupacionBabelDto> lOcupacion = new ArrayList<OcupacionBabelDto>();
	static Logger logger = Logger.getLogger(ListExamples.class.getName());
	
	public static void main(String[] args) {
		
		setDate();
		//lOcupacion.forEach(System.out::println);
		Set<Integer> sNumProyecto =	getNumProyecto();
		sNumProyecto.forEach(System.out::println);
		
	}
	
	public static Set<Integer> getNumProyecto() {
		logger.info("[getNumProyecto] start -"+System.currentTimeMillis());
		Set<Integer> sNumProyecto = new HashSet<Integer>();
		lOcupacion.stream().filter(f->f.getNumProyecto()!=null).forEach(f->{
			sNumProyecto.add(f.getNumProyecto());
		});
		return sNumProyecto;
		
	}
	public static void setDate() {
		/*OcupacionBabelDto(Integer numProyecto, Integer codEmpleado, String codProyecto, Integer codEmpleadoReal,
				Date fechOcupacion, Integer indManANAtARDE, Integer indRealPrevisto, Integer tipoDia)*/
		
		
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,1,1,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,1,1,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,1,1,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,1,1,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,1,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,1,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,1,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,1,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,5,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,5,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,5,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,5,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,6,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,6,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,6,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,6,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,7,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,7,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,7,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,7,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,8,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,8,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,8,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(19921, 3943, "285-32", 3951, new Date(2022,4,8,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,11,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,11,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,11,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,11,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,12,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,12,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,12,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,12,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,13,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,13,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,13,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,13,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(344, 3943, "F-Loc", 3951, new Date(2022,4,14,2,0,0), 0, 0, 2));
		lOcupacion.add(new OcupacionBabelDto(344, 3943, "F-Loc", 3951, new Date(2022,4,14,2,0,0), 0, 1, 2));
		lOcupacion.add(new OcupacionBabelDto(344, 3943, "F-Loc", 3951, new Date(2022,4,14,2,0,0), 1, 0, 2));
		lOcupacion.add(new OcupacionBabelDto(344, 3943, "F-Loc", 3951, new Date(2022,4,14,2,0,0), 1, 1, 2));
		lOcupacion.add(new OcupacionBabelDto(343, 3943, "F-Nac", 3951, new Date(2022,4,15,2,0,0), 0, 0, 3));
		lOcupacion.add(new OcupacionBabelDto(343, 3943, "F-Nac", 3951, new Date(2022,4,15,2,0,0), 0, 1, 3));
		lOcupacion.add(new OcupacionBabelDto(343, 3943, "F-Nac", 3951, new Date(2022,4,15,2,0,0), 1, 0, 3));
		lOcupacion.add(new OcupacionBabelDto(343, 3943, "F-Nac", 3951, new Date(2022,4,15,2,0,0), 1, 1, 3));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,18,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,18,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,18,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,18,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,19,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,19,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,19,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,19,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,20,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,20,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,20,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,20,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,21,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,21,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,21,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,21,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,22,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,22,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,22,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,22,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,25,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,25,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,25,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20521, 3943, "I-CEN22", 3951, new Date(2022,4,25,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,26,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,26,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,26,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,26,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,27,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,27,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,27,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,27,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,28,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,28,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,28,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,28,2,0,0), 1, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,29,2,0,0), 0, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,29,2,0,0), 0, 1, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,29,2,0,0), 1, 0, 4));
		lOcupacion.add(new OcupacionBabelDto(20035, 3943, "627-4", 3951, new Date(2022,4,29,2,0,0), 1, 1, 4));
	}
}
