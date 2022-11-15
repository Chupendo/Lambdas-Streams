package lambdas.secction.three.biConsumer.ejercicios.one;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

public class Ejercicio2 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0,"Andres");
		map.put(1,"Pedro");
		map.put(2,"Ramon");
		map.put(3,"Jacinto");
		
		
		/*Recorrer un Map antes de Java 8*/
		System.out.println("ForEach con uso de la interfaz BiConsumer.");
		Iterator<Map.Entry<Integer, String>> iter = map.entrySet().iterator();
		if(iter!=null) {
			while(iter.hasNext()) {
				Map.Entry<Integer, String> entry = iter.next();
				System.out.println("Clave: "+entry.getKey()+", Valor: "+entry.getValue());
			}
		}
		
		/*ForEach*/
		System.out.println("ForEach sin uso de la interfaz BiConsumer.");
		for (Map.Entry<Integer, String> registro : map.entrySet()) {
			System.out.println("Clave: "+registro.getKey()+", Valor: "+registro.getValue());
		}
		
	}
}
