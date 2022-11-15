package lambdas.secction.three.biConsumer.ejercicios.one;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

public class Ejercicio3 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0,"Andres");
		map.put(1,"Pedro");
		map.put(2,"Ramon");
		map.put(3,"Jacinto");
		
		
		/*Recorrer un Map con forEach de Java 8*/
		map.forEach((key,value)->System.out.println("Clave: "+key+"Nombre: "+value));
		
	}
}
