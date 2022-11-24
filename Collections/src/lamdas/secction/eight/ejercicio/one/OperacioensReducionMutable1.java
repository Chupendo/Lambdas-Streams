package lamdas.secction.eight.ejercicio.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class OperacioensReducionMutable1 {
	
	// Apartir de una matriz de String obtener una List<String> mediante collect()
	public static void main(String[] args) {
		Stream<String> stream1 = Arrays.stream(new String[]{"Marco","Pedro","Juan","Ramona","Ruth"});
		
		//Firma de collect:
		//<R> R collect(Supplier<R> supplier, Biconsumer<R,? super T> accumulator, Biconsumer<R,R> combiner)
		//<R,A> R collect(Collector<? super T,A,R> collector)
		
		//Que tipo de dato quremos generar (no recibe nada, solo genera un resultado)
		Supplier<ArrayList<String>> proveedor1 = ()->new ArrayList<String>(); //proveedor "constructor"
		Supplier<ArrayList<String>> proveedor2 = ArrayList::new; //proveedor con metodo referenciado
		
		//Como se van añadir  Biconsumer<Tipo_Suplier, Elemento_Steam>
		BiConsumer<ArrayList<String>, String> acumulador1 = (lista, elemento) -> lista.add(elemento);
		BiConsumer<ArrayList<String>, String> acumulador2 = ArrayList::add;
		
		//Como se van a comibinar los proveedores 
		BiConsumer<ArrayList<String>, ArrayList<String>> combinador1 = (lista1,lista2) -> lista1.addAll(lista2);
		BiConsumer<ArrayList<String>, ArrayList<String>> combinador2 = ArrayList::addAll;
		
		List<String> lString = stream1.collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
		
		lString.forEach(System.out::println);
		

	}

}
