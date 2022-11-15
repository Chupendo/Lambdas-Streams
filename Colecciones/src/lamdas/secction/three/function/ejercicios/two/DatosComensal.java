package lambadas.secction.three.function.ejercicios.two;

import java.util.function.Function;

public class DatosComensal {

	public static Object getDatoComensal(
			Comensal com, Function<Comensal, Object> func
	){
			return func.apply(com);
				
	}
}
