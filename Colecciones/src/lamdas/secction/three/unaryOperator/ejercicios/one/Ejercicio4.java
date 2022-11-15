package lambadas.secction.three.unaryOperator.ejercicios.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.UnaryOperator;

public class Ejercicio4 {

	public static void main(String[] args) {
		List<Integer> lInteger = Arrays.asList(1,2,3,10,20,30);
		
		//Misma lista
		UnaryOperator<Integer> uo = UnaryOperator.identity();
		System.out.println("Copia Lista");
		for (Integer num : recorrer(uo,lInteger)) {
			System.out.println(num);
		}
		
		//Lista donde cada vlaor es diez veces mayor
		UnaryOperator<Integer> uoX10 = num->num*10;
		System.out.println("Lista x10");
		for (Integer num : recorrer(uoX10,lInteger)) {
			System.out.println(num);
		}
	}
	
	public static List<Integer> recorrer (UnaryOperator<Integer> uo, List<Integer> lista){
		List<Integer> lnueva = new ArrayList<Integer>();
		
		lista.forEach(x->lnueva.add(uo.apply(x)));
		return lnueva;
	}
}
