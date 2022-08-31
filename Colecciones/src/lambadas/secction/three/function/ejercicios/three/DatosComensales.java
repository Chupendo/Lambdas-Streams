package lambadas.secction.three.function.ejercicios.three;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DatosComensales {

	public static Object getDatoComensales(
			Comensal com, Function<Comensal, Object> func
	){
			return func.apply(com);
				
	}
	
	public List<Object> getDatosComensales(
		List<Comensal> lCom, 
		Function<Comensal,Object> fun)
	{
		//Esta lista guardara datos personales de los comensales
		List<Object> listaDatos = new ArrayList<Object>();
		
		//Iteramos la lista de comensales recibidos
		for(Comensal com : lCom) {
			//Obtenemos los datos personalidos
			listaDatos.add(fun.apply(com));
		}
		
		return listaDatos;
	}
}
